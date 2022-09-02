package com.taller.taller.controllers;

import com.taller.taller.MainApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PantallaClientes {

    @FXML
    private Button btnVolverClientes;

    @FXML
    private Button btnNuevoCliente;

    @FXML
    protected void onNuevoClienteButtonClick() throws IOException {
        //operaciones de destrabar los inputs para crear un nuevo cliente.
    }

    @FXML
    protected void onVolverButtonClick() throws IOException {
        Stage stage = (Stage) btnVolverClientes.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaClientes.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 200, 250);
        stage.setTitle("Confirmar turno");
        stage.setScene(scene);
    }

}
