package com.taller.taller.controllers;

import com.taller.taller.MainApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.YearMonth;

public class PantallaMenuPrincipalController {

    @FXML
    private ImageView accountButton;

    @FXML
    private ImageView scheduleButton;

    @FXML
    private ImageView worksheetButton;

    @FXML
    private ImageView reportsButton;

    @FXML
    protected void onAccountButtonClick() throws IOException {
        Stage stage = (Stage) accountButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaClientes.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        stage.setTitle("Menu Principal");
        stage.setScene(scene);
    }

    @FXML
    protected void onScheduleButtonClick() throws IOException {
        Stage stage = (Stage) scheduleButton.getScene().getWindow();
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
    protected void onWorksheetButtonClick() throws IOException {
        Stage stage = (Stage) worksheetButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaTrabajoRealizado.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        stage.setTitle("Trabajos Realizados");
        stage.setScene(scene);
    }

    @FXML
    protected void onReportsButtonClick() throws IOException {
        Stage stage = (Stage) reportsButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaInformes.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        stage.setTitle("Informes");
        stage.setScene(scene);
    }
}
