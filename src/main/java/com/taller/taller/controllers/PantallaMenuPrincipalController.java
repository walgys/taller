package com.taller.taller.controllers;

import com.taller.taller.MainApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;


public class PantallaMenuPrincipalController {

    @FXML
    private ImageView accountButton;

    @FXML
    private ImageView scheduleButton;

    @FXML
    private ImageView informeMensualButton;

    @FXML
    private ImageView informeDiarioButton;

    @FXML
    protected void onAccountButtonClick() throws IOException {
        Stage stage = (Stage) accountButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaClientes.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Clientes");
        stage.setScene(scene);
    }

    @FXML
    protected void onScheduleButtonClick() throws IOException {
        Stage stage = (Stage) scheduleButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaAgenda.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Agenda");
        stage.setScene(scene);
    }
    @FXML
    protected void onInformeDiarioButtonClick() throws IOException {
//        Stage stage = (Stage) worksheetButton.getScene().getWindow();
//        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaTrabajosRealizados.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setTitle("Trabajos Realizados");
//        stage.setScene(scene);
    }

    @FXML
    protected void onInformeMensualButtonClick() throws IOException {
//        Stage stage = (Stage) reportsButton.getScene().getWindow();
//        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaInformes.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setTitle("Informes");
//        stage.setScene(scene);
    }
}
