package com.taller.taller.controllers;

import com.taller.taller.MainApplication;
import com.taller.taller.dao.UsuarioDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private Button loginButton;

    @FXML
    private TextField userInput;

    @FXML
    private TextField passInput;

    private UsuarioDao usuarioDao = UsuarioDao.instance();

    @FXML
    protected void onLoginButtonClick() throws IOException {

        String user = userInput.getText();
        String pass = passInput.getText();

        if (usuarioDao.isValidUser(user, pass)) {
            Stage stage = (Stage) loginButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaMenuPrincipal.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 400);
            stage.setTitle("Menu Principal");
            stage.setScene(scene);
        }

    }
}