package com.taller.taller.controllers;

import com.taller.taller.MainApplication;
import com.taller.taller.MainState;
import com.taller.taller.bean.HorarioMecanico;
import com.taller.taller.bean.ReservaTurno;
import com.taller.taller.dao.EspecialidadDao;
import com.taller.taller.dao.TipoDocumentoDao;
import com.taller.taller.dao.TurnoDao;
import com.taller.taller.models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.util.*;

public class PantallaAgenda {

    @FXML
    private Button btnVolverAgenda;

    @FXML
    private Button btnAltaClienteAgenda;

    @FXML
    private Button btnConfirmarTurno;

    @FXML
    private Button btnTrabajosRealizadosAgenda;

    @FXML
    private Button btnImpFichaMec;

    @FXML
    private Button btnRegAsis;

    private String lastScreen;

    @FXML
    private ComboBox cbxEspecialidadReserva;

    @FXML
    private TableView<ReservaTurno> tblReservarTurno;
    @FXML
    private TableColumn<ReservaTurno, String> tblClmHora;
    @FXML
    private TableColumn<ReservaTurno, String> tblClmMecanico;
    @FXML
    private TableColumn<ReservaTurno, String> tblClmIDMecanico;
    @FXML
    private TableColumn<ReservaTurno, String> tblClmIDHora;
    @FXML
    private TableColumn<ReservaTurno, String> tblClmIDEspecialidad;

    List<ReservaTurno> reservas = new ArrayList<>();


    @FXML
    private TableView<ReservaTurno> tblBuscarTurno;
    @FXML
    private TableColumn<ReservaTurno, String> tblClmTurnoEspecialidad;
    @FXML
    private TableColumn<ReservaTurno, String> tblClmTurnoMecanico;
    @FXML
    private TableColumn<ReservaTurno, String> tblClmTurnoHora;
    @FXML
    private TableColumn<ReservaTurno, String> tblClmTurnoCliente;
    @FXML
    private TableColumn<ReservaTurno, String> tblClmTurnoVehiculo;
    @FXML
    private TableColumn<ReservaTurno, String> tblClmTurnoId;

    private List<ReservaTurno> busqquedaTurno = new ArrayList<>();

    private TurnoDao turnoDao = TurnoDao.instance();
    private EspecialidadDao especialidadDao = EspecialidadDao.instance();

    @FXML
    private DatePicker dtpFechaTurnoReserva;

    @FXML
    protected void initialize(){
        final Map<String, Object> state = MainState.getInstance().getState();
        Map<String,Object> navigation;
        try{
             navigation = (Map<String, Object>) state.get("navigation");
        }catch (Exception ex){
            navigation = null;
        }

        if(navigation != null){
            try {
                lastScreen  = (String) navigation.get("actualScreen");
                MainState.getInstance().setStateProperty(Map.of("actualScreen","PantallaAgenda", "lastScreen",lastScreen),"navigation");
            }catch (Exception ex){
                return;
            }
        }
    }

    @FXML
    protected void onVolverButtonClick() throws IOException {
        Stage stage = (Stage) btnVolverAgenda.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaMenuPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        stage.setTitle("Menu Principal");
        stage.setScene(scene);
    }

    @FXML
    protected void onImprimirFichaClick() throws IOException {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Imprimir Ficha");
        a.setContentText("Imprimiendo Ficha Mecánica");
        a.show();
    }

    @FXML
    protected void onBuscarTurnosDisponiblesClick() throws IOException {

        tblReservarTurno.getItems().clear();

        Especialidad especialidad = especialidadDao.getByDescripcion(cbxEspecialidadReserva.getValue().toString());

        List<HorarioMecanico> horariosDisponibles = turnoDao.searchByEspecialidadFecha(especialidad.getId(), dtpFechaTurnoReserva.getValue());

        for (HorarioMecanico horarioMecanico: horariosDisponibles) {
            tblReservarTurno.getItems().add(new ReservaTurno(horarioMecanico.getMecanicoNombre(), horarioMecanico.getHorarioDesc(), horarioMecanico.getMecanicoId(), horarioMecanico.getHorarioId(), especialidad.getId(), dtpFechaTurnoReserva.getValue()));
        }

    }

    @FXML
    protected void onRegistrarAsistenciaClick() throws IOException {

        ReservaTurno reservaTurno = tblBuscarTurno.getSelectionModel().getSelectedItem();

        Turno turno = turnoDao.getById(reservaTurno.getIdTurno());

        if(!turno.getCliente().isValido()){
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Registrar Asistencia");
            a.setContentText("Se requiere alta del cliente");
            a.show();
        }else{
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setTitle("Registrar Asistencia");
            a.setContentText("Confirma Asistencia");
            a.show();
            turno.setAsistencia(true);
            turnoDao.save(turno);
        }
    }

    @FXML
    protected void onConfirmarTurnoButtonClick() throws IOException {
        Stage stage = (Stage) btnConfirmarTurno.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaReservarTurno.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Reservar Turno");
        stage.setScene(scene);

        ReservaTurno reservaTurno = tblReservarTurno.getSelectionModel().getSelectedItem();

        PantallaReservarTurno controller = fxmlLoader.getController();
        controller.setData(reservaTurno);
    }

    @FXML
    protected void onTrabajosRealizadosButtonClick() throws IOException {
        Stage stage = (Stage) btnTrabajosRealizadosAgenda.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaTrabajosRealizados.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Registrar Trabajos Realizados");
        stage.setScene(scene);

        ReservaTurno reservaTurno = tblBuscarTurno.getSelectionModel().getSelectedItem();
        PantallaTrabajosRealizados controller = fxmlLoader.getController();
        controller.setData(reservaTurno);
    }

    public void setData() {
        cbxEspecialidadReserva.getItems().clear();

        List<Especialidad> list = especialidadDao.getAll();
        for (Especialidad especialidad : list) {
            cbxEspecialidadReserva.getItems().add(especialidad.getDescripcion());
        }

        tblClmHora.setCellValueFactory(new PropertyValueFactory<>("Horario"));
        tblClmMecanico.setCellValueFactory(new PropertyValueFactory<>("Mecanico"));
        tblClmIDHora.setCellValueFactory(new PropertyValueFactory<>("IdHora"));
        tblClmIDMecanico.setCellValueFactory(new PropertyValueFactory<>("IdMecanico"));
        tblClmIDEspecialidad.setCellValueFactory(new PropertyValueFactory<>("IdEspecialidad"));

        tblClmTurnoEspecialidad.setCellValueFactory(new PropertyValueFactory<>("Especialidad"));
        tblClmTurnoMecanico.setCellValueFactory(new PropertyValueFactory<>("Mecanico"));
        tblClmTurnoHora.setCellValueFactory(new PropertyValueFactory<>("Horario"));
        tblClmTurnoCliente.setCellValueFactory(new PropertyValueFactory<>("Cliente"));
        tblClmTurnoVehiculo.setCellValueFactory(new PropertyValueFactory<>("Vehiculo"));
        tblClmTurnoId.setCellValueFactory(new PropertyValueFactory<>("IdTurno"));

        for (Turno turno : turnoDao.getAllOfNow()) {
            ReservaTurno reservaTurno = new ReservaTurno();
            reservaTurno.setCliente(turno.getCliente().getNombre());
            reservaTurno.setVehiculo(turno.getVehiculo().getMarca() + " - " + turno.getVehiculo().getModelo());
            reservaTurno.setEspecialidad(turno.getEspecialidad().getDescripcion());
            reservaTurno.setHorario(turno.getHora().getDescripcion());
            reservaTurno.setMecanico(turno.getMecanico().getNombre());
            reservaTurno.setIdTurno(turno.getId());
            busqquedaTurno.add(reservaTurno);
        }

        ObservableList<ReservaTurno> reservasObservableList = FXCollections.observableArrayList(busqquedaTurno);
        tblBuscarTurno.setItems(reservasObservableList);

    }
}
