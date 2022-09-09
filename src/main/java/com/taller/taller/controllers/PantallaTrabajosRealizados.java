package com.taller.taller.controllers;

import com.taller.taller.MainApplication;
import com.taller.taller.MainState;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

public class PantallaTrabajosRealizados {

    @FXML
    private Button btnVolverTrabajos;

    @FXML
    private Button btnNuevaPlanilla;

    private String lastScreen;

    @FXML
    protected void initialize(){
        final Map<String, Object> state = MainState.getInstance().getState();
        Map<String,Object> navigation;
        try{
            navigation = (Map<String, Object>) state.get("navigation");
        }catch (Exception ex){
            navigation = null;
        }

        if(navigation != null){
            try {
                lastScreen  = (String) navigation.get("actualScreen");
                MainState.getInstance().setStateProperty(Map.of("actualScreen","TrabajosRealizados", "lastScreen",lastScreen),"navigation");
            }catch (Exception ex){
                return;
            }
        }
    }

    @FXML
    protected void onVolverButtonClick() throws IOException {
        Stage stage = (Stage) btnVolverTrabajos.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaAgenda.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Menu Principal");
        stage.setScene(scene);
    }
    @FXML
    protected void onNuevaPlanillaClick() throws IOException {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText("Trabajos Realizados");
        a.setTitle("¿ Deséa guardar los cambios ?");
        Optional<ButtonType> action = a.showAndWait();
        if(action.get() == ButtonType.OK) {
            Stage stage = (Stage) btnNuevaPlanilla.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaAgenda.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Menu Principal");
            stage.setScene(scene);
        }
    }
}
