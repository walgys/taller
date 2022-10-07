package com.taller.taller.controllers;

import com.taller.taller.MainApplication;
import com.taller.taller.MainState;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Map;


public class PantallaMenuPrincipal {

    @FXML
    private ImageView accountButton;

    @FXML
    private ImageView scheduleButton;

    @FXML
    private ImageView btnInformes;

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
                MainState.getInstance().setStateProperty(Map.of("actualScreen","PantallaMenuPrincipal", "lastScreen",lastScreen),"navigation");
            }catch (Exception ex){
                return;
            }
        }
    }
    @FXML
    protected void onAccountButtonClick() throws IOException {
        Stage stage = (Stage) accountButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaClientes.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Clientes");
        stage.setScene(scene);
        PantallaClientes controller = fxmlLoader.getController();
        controller.setData();
    }

    @FXML
    protected void onScheduleButtonClick() throws IOException {
        Stage stage = (Stage) scheduleButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaAgenda.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Agenda");
        stage.setScene(scene);

        PantallaAgenda controller = fxmlLoader.getController();
        controller.setData();

    }

    @FXML
    protected void onInformesButtonClick() throws IOException {
        Stage stage = (Stage) btnInformes.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaInformes.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Informes");
        stage.setScene(scene);
    }
}
