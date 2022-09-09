package com.taller.taller.controllers;

import com.taller.taller.MainApplication;
import com.taller.taller.MainState;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

public class PantallaInformes {

    @FXML
    private Button btnVolverInformes;

    @FXML
    private ImageView imgInfMen;

    @FXML
    private ImageView imgInfDiario;

    @FXML
    private ImageView imgInTrabRealiz;

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
                MainState.getInstance().setStateProperty(Map.of("actualScreen","PantallaInformes", "lastScreen",lastScreen),"navigation");
            }catch (Exception ex){
                return;
            }
        }
    }

    @FXML
    protected void onVolverButtonClick() throws IOException {
        Stage stage = (Stage) btnVolverInformes.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaMenuPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Menu Principal");
        stage.setScene(scene);
    }
    @FXML
    protected void onInformeMensualButtonClick() throws IOException {
        //imprimir  al finalizar volver
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Informe Mensual");
        a.setContentText("Imprimiendo informe mensual");
        final Optional<ButtonType> buttonType = a.showAndWait();
        if(buttonType.get() == ButtonType.CLOSE){
            Stage stage = (Stage) imgInfMen.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaMenuPrincipal.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Informe Mensual");
            stage.setScene(scene);
        }
    }

    @FXML
    protected void onInformeDiarioButtonClick() throws IOException {
        //imprimir  al finalizar volver
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Informe Diario");
        a.setContentText("Imprimiendo Informe Diario");
        final Optional<ButtonType> buttonType = a.showAndWait();
        if(buttonType.get() == ButtonType.CLOSE){
            Stage stage = (Stage) imgInfDiario.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaMenuPrincipal.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Informe Mensual");
            stage.setScene(scene);
        }
    }

    @FXML
    protected void onInformeTrabajosRealizadosButtonClick() throws IOException {
        //imprimir  al finalizar volver
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Informe de Trabajos Realizados");
        a.setContentText("Imprimiendo Informe de Trabajos Reaizados");
        final Optional<ButtonType> buttonType = a.showAndWait();
        if(buttonType.get() == ButtonType.CLOSE){
            Stage stage = (Stage) imgInTrabRealiz.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaMenuPrincipal.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Informe Mensual");
            stage.setScene(scene);
        }
    }
}
