package com.taller.taller.controllers;

import com.taller.taller.MainApplication;
import com.taller.taller.MainState;
import com.taller.taller.bean.ReservaTurno;
import com.taller.taller.dao.ActividadTurnoDao;
import com.taller.taller.dao.EspecialidadDao;
import com.taller.taller.dao.TurnoDao;
import com.taller.taller.models.Actividad;
import com.taller.taller.models.ActividadesTurno;
import com.taller.taller.models.Especialidad;
import com.taller.taller.models.Turno;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PantallaTrabajosRealizados {

    @FXML
    private Button btnVolverTrabajos;

    @FXML
    private Button btnNuevaPlanilla;

    @FXML
    private TextField tfCliente;

    @FXML
    private TextField tfAseguradora;

    @FXML
    private TextField tfVehiculo;

    @FXML
    private TextField tfEspecialidad;

    @FXML
    private TextField tfTiempoEmpleado;

    @FXML
    private ComboBox cmbActividadRealizada;

    @FXML
    private TableView<ActividadesTurno> tblTrabajosRealizados;
    @FXML
    private TableColumn<ActividadesTurno, String> tblClmActividadRealizada;
    @FXML
    private TableColumn<ActividadesTurno, String> tblClmTiempoEmpleado;
    @FXML
    private TableColumn<ActividadesTurno, String> tblClmIDActividadTurno;

    private String lastScreen;

    private Turno turno;

    ActividadTurnoDao actividadTurnoDao = ActividadTurnoDao.instance();

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
                MainState.getInstance().setStateProperty(Map.of("actualScreen","TrabajosRealizados", "lastScreen",lastScreen),"navigation");
            }catch (Exception ex){
                return;
            }
        }
    }

    @FXML
    protected void onVolverButtonClick() throws IOException {
        Stage stage = (Stage) btnVolverTrabajos.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaAgenda.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Menu Principal");
        stage.setScene(scene);

        PantallaAgenda controller = fxmlLoader.getController();
        controller.setData();
    }

    @FXML
    protected void onAgregarActividadButtonClick() throws IOException {

        Actividad actividad = (Actividad) cmbActividadRealizada.getSelectionModel().getSelectedItem();

        ActividadesTurno actividadesTurno = new ActividadesTurno();
        actividadesTurno.setActividad(actividad);
        actividadesTurno.setTurno(turno);
        actividadesTurno.setTiempoEmpleado(Integer.parseInt(tfTiempoEmpleado.getText()));
        actividadTurnoDao.save(actividadesTurno);

        tblTrabajosRealizados.getItems().clear();
        List<ActividadesTurno> actividadesTurnoList = actividadTurnoDao.getByIdTurno(turno.getId());
        ObservableList<ActividadesTurno> actividadesTurnosObservableList = FXCollections.observableArrayList(actividadesTurnoList);
        tblTrabajosRealizados.setItems(actividadesTurnosObservableList);
    }

    @FXML
    protected void onDeleteActividadButtonClick() throws IOException {

        ActividadesTurno actividadesTurno = tblTrabajosRealizados.getSelectionModel().getSelectedItem();
        actividadTurnoDao.delete(actividadesTurno);

        tblTrabajosRealizados.getItems().clear();
        List<ActividadesTurno> actividadesTurnoList = actividadTurnoDao.getByIdTurno(turno.getId());
        ObservableList<ActividadesTurno> actividadesTurnosObservableList = FXCollections.observableArrayList(actividadesTurnoList);
        tblTrabajosRealizados.setItems(actividadesTurnosObservableList);
    }

    public void setData(ReservaTurno reservaTurno) {

        TurnoDao turnoDao = new TurnoDao();
        Turno turno = turnoDao.getById(reservaTurno.getIdTurno());
        this.turno = turno;

        tfCliente.setText(turno.getCliente().getNombre());
        tfVehiculo.setText(turno.getVehiculo().getMarca() + " - " + turno.getVehiculo().getModelo() + " - " + turno.getVehiculo().getPatente());
        tfAseguradora.setText(turno.getVehiculo().getAseguradora());
        tfEspecialidad.setText(turno.getEspecialidad().getDescripcion());

        cmbActividadRealizada.getItems().addAll(turno.getEspecialidad().getActividades());

        tblClmActividadRealizada.setCellValueFactory(new PropertyValueFactory<>("Actividad"));
        tblClmTiempoEmpleado.setCellValueFactory(new PropertyValueFactory<>("TiempoEmpleado"));
        tblClmIDActividadTurno.setCellValueFactory(new PropertyValueFactory<>("Id"));

        List<ActividadesTurno> actividadesTurnoList = actividadTurnoDao.getByIdTurno(turno.getId());
        ObservableList<ActividadesTurno> actividadesTurnosObservableList = FXCollections.observableArrayList(actividadesTurnoList);
        tblTrabajosRealizados.setItems(actividadesTurnosObservableList);

    }

}
