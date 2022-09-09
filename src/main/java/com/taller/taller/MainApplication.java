package com.taller.taller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MainState.getInstance().setStateProperty(Map.of("actualScreen","MainApp"),"navigation");
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 187);
        stage.setTitle("Ingrese a Taller");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}