package com.taller.taller.controllers;

import com.taller.taller.MainApplication;
import com.taller.taller.MainState;
import com.taller.taller.bean.ReservaTurno;
import com.taller.taller.dao.TipoDocumentoDao;
import com.taller.taller.dao.TurnoDao;
import com.taller.taller.models.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PantallaReservarTurno {

    @FXML
    private Button btnVolverReservar;

    @FXML
    private Button btnReservar;

    private String lastScreen;

    private ReservaTurno reservaTurno;

    @FXML
    private TextField tfNombre;

    @FXML
    private TextField tfNroDocumento;

    @FXML
    private TextField tfNroTelefono;

    @FXML
    private TextField tfAseguradora;

    @FXML
    private TextField tfModelo;

    @FXML
    private TextField tfMarca;

    @FXML
    private TextField tfNroPoliza;

    @FXML
    private ComboBox  cmbTipoDocumento;

    private TurnoDao turnoDao = TurnoDao.instance();
    private TipoDocumentoDao tipoDocumentoDao = TipoDocumentoDao.instance();

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
                MainState.getInstance().setStateProperty(Map.of("actualScreen","PantallaReservarTurno", "lastScreen",lastScreen),"navigation");
            }catch (Exception ex){
                return;
            }
        }
    }

    @FXML
    protected void onVolverButtonClick() throws IOException {
        Stage stage = (Stage) btnVolverReservar.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaAgenda.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Agenda");
        stage.setScene(scene);
    }

    @FXML
    protected void onReservarButtonClick() throws IOException {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Reservar Turno");
        a.setContentText("¿ Deséa reservar el turno ?");
        Optional<ButtonType> action = a.showAndWait();
        if(action.get() == ButtonType.OK) {
            Stage stage = (Stage) btnReservar.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaAgenda.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Agenda");
            stage.setScene(scene);

            PantallaAgenda controller = fxmlLoader.getController();
            controller.setData();

            Turno turno = new Turno();

            Horario horario = new Horario();
            horario.setId(reservaTurno.getIdHora());
            turno.setHora(horario);

            Mecanico mecanico = new Mecanico();
            mecanico.setId(reservaTurno.getIdMecanico());
            turno.setMecanico(mecanico);

            Especialidad especialidad = new Especialidad();
            especialidad.setId(reservaTurno.getIdEspecialidad());
            turno.setEspecialidad(especialidad);

            turno.setFechaTurno(reservaTurno.getFechaReserva());

            Cliente cliente = new Cliente();
            cliente.setNombre(tfNombre.getText());
            cliente.setTelefono(tfNroTelefono.getText());
            cliente.setDni(tfNroDocumento.getText());

            cliente.setTipoDocumento(tipoDocumentoDao.getByDescripcion(cmbTipoDocumento.getValue().toString()));
            turno.setCliente(cliente);

            Vehiculo vehiculo = new Vehiculo();
            vehiculo.setAseguradora(tfAseguradora.getText());
            vehiculo.setModelo(tfModelo.getText());
            vehiculo.setNroPoliza(tfNroPoliza.getText());
            vehiculo.setMarca(tfMarca.getText());
            vehiculo.setCliente(cliente);
            turno.setVehiculo(vehiculo);

            turnoDao.save(turno);

        }
    }

    public void setData(ReservaTurno reservaTurno){

        cmbTipoDocumento.getItems().clear();
        List<TipoDocumento> list = tipoDocumentoDao.getAll();
        for (TipoDocumento tipoDocumento : list) {
            cmbTipoDocumento.getItems().add(tipoDocumento.getDescripcion());
        }

        this.reservaTurno = reservaTurno;
    }
}
