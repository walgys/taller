package com.taller.taller.controllers;

import com.taller.taller.MainApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PantallaTrabajosRealizados {

    @FXML
    private Button btnVolverTrabajos;

    @FXML
    private Button btnNuevaPlanilla;

    @FXML
    protected void initialize(){
        //obtener datos del estado o Dao para poblar la vista.
    }

    @FXML
    protected void onVolverButtonClick() throws IOException {
        Stage stage = (Stage) btnVolverTrabajos.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaMenuPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        stage.setTitle("Menu Principal");
        stage.setScene(scene);
    }
    @FXML
    protected void onNuevaPlanillaClick() throws IOException {
        //imprimir  al finalizar volver
        System.out.println("NuevaPlanilla");
        Stage stage = (Stage) btnNuevaPlanilla.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaMenuPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        stage.setTitle("Menu Principal");
        stage.setScene(scene);

    }
}
