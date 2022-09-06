package com.taller.taller.controllers;

import com.taller.taller.MainApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class InformeMensual {

    @FXML
    private Button btnVolverInfMen;

    @FXML
    private Button btnImprimirInfMen;

    @FXML
    protected void initialize(){
        //obtener datos del estado o Dao para poblar la vista.
    }

    @FXML
    protected void onVolverButtonClick() throws IOException {
        Stage stage = (Stage) btnImprimirInfMen.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaMenuPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        stage.setTitle("Menu Principal");
        stage.setScene(scene);
    }

    @FXML
    protected void onImprimirButtonClick() throws IOException {
        System.out.println("imprimiendo informe");
        Stage stage = (Stage) btnVolverInfMen.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaInformes.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        stage.setTitle("Informes");
        stage.setScene(scene);
    }
}
