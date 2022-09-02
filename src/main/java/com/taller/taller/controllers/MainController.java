package com.taller.taller.controllers;

import com.taller.taller.MainApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML
    private Button loginButton;

    @FXML
    protected void onLoginButtonClick() throws IOException {
        Stage stage = (Stage) loginButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaMenuPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        stage.setTitle("Menu Principal");
        stage.setScene(scene);
    }
}