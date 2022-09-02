package com.taller.taller.controllers;

import com.taller.taller.MainApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class PantallaReservarTurno {

    @FXML
    private Button btnVolverReservar;

    @FXML
    private Button btnReservar;

    @FXML
    protected void onVolverButtonClick() throws IOException {
        Stage stage = (Stage) btnVolverReservar.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaAgenda.fxml"));
        VBox view = new FullCalendarView().getView();
        Parent root = fxmlLoader.load();
        final PantallaAgenda controller = fxmlLoader.getController();
        controller.addChildToPane(view);
        Scene scene = new Scene(root,700,500);
        stage.setTitle("Agenda");
        stage.setScene(scene);
    }

    @FXML
    protected void onReservarButtonClick() throws IOException {
        Stage stage = (Stage) btnReservar.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ModalConfirmarTurno.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 200, 250);
        stage.setTitle("Confirmar turno");
        stage.setScene(scene);
    }

}