package com.taller.taller.controllers;

import com.taller.taller.MainApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ModalConfirmarCliente {


    @FXML
    private Button btnCrearCliente;

    @FXML
    private Button bntVolverCrearCliente;

    @FXML
    protected void onCrearClienteButtonClick() throws IOException {
        Stage stage = (Stage) btnCrearCliente.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ModalConfirmarTurno.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 200, 250);
        stage.setTitle("Confirmar turno");
        stage.setScene(scene);
    }

    @FXML
    protected void onVolverButtonClick() throws IOException {
        Stage stage = (Stage) bntVolverCrearCliente.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaClientes.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 200, 250);
        stage.setTitle("Confirmar turno");
        stage.setScene(scene);
    }
}
