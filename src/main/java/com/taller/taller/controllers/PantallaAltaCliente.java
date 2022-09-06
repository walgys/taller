package com.taller.taller.controllers;

import com.taller.taller.MainApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PantallaAltaCliente {

    @FXML
    private Button btnVolverAltaCliente;

    @FXML
    private Button btnAltaCliente;

    @FXML
    protected void initialize(){
        //obtener datos del estado o Dao para poblar la vista.
    }

    @FXML
    protected void onVolverButtonClick() throws IOException {
        Stage stage = (Stage) btnVolverAltaCliente.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaClientes.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        stage.setTitle("Alta cliente");
        stage.setScene(scene);
    }

    @FXML
    protected void onAltaButtonClick() throws IOException {
        System.out.println("creando cliente");
        Stage stage = (Stage) btnAltaCliente.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaClientes.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        stage.setTitle("Clientes");
        stage.setScene(scene);
    }
}
