package com.taller.taller.controllers;

import com.taller.taller.MainApplication;
import com.taller.taller.MainState;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
    protected void onRegistrarAsistenciaClick() throws IOException {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Registrar Asistencia");
        a.setContentText("Registrando Asistencia");
        a.show();
    }

    @FXML
    protected void onConfirmarTurnoButtonClick() throws IOException {
        Stage stage = (Stage) btnConfirmarTurno.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaReservarTurno.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Reservar Turno");
        stage.setScene(scene);
    }

    @FXML
    protected void onTrabajosRealizadosButtonClick() throws IOException {
        Stage stage = (Stage) btnTrabajosRealizadosAgenda.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaTrabajosRealizados.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Registrar Trabajos Realizados");
        stage.setScene(scene);
    }
}
