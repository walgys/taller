package com.taller.taller.controllers;

import com.taller.taller.MainApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

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
    protected void initialize(){
        //obtener datos del estado o Dao para poblar la vista.
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
    protected void onAltaClienteButtonClick() throws IOException {
        Stage stage = (Stage) btnAltaClienteAgenda.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaAltaCliente.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Nuevo Cliente");
        stage.setScene(scene);
    }

    @FXML
    protected void onConfirmarTurnoButtonClick() throws IOException {
        Stage stage = (Stage) btnConfirmarTurno.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaReservarTurno.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Turno");
        stage.setScene(scene);
    }

    @FXML
    protected void onTrabajosRealizadosButtonClick() throws IOException {
        Stage stage = (Stage) btnTrabajosRealizadosAgenda.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaTrabajosRealizados.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Informe Trabajos Realizados");
        stage.setScene(scene);
    }
}
