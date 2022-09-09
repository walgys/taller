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

public class PantallaAltaCliente {

    @FXML
    private Button btnVolverAltaCliente;

    @FXML
    private Button btnAltaCliente;

    @FXML
    private Button btnAgregarVehiculo;

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
                MainState.getInstance().setStateProperty(Map.of("actualScreen","PantallaAltaCliente", "lastScreen",lastScreen),"navigation");
            }catch (Exception ex){
                return;
            }
        }
    }

    @FXML
    protected void onVolverButtonClick() throws IOException {
        Stage stage = (Stage) btnVolverAltaCliente.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaClientes.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Clientes");
        stage.setScene(scene);
    }

    @FXML
    protected void onAgeregarVehiculoButtonClick() throws IOException {
        Stage stage = (Stage) btnAgregarVehiculo.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaAltaVehiculo.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Agregar un Vehículo");
        stage.setScene(scene);
    }

    @FXML
    protected void onAltaButtonClick() throws IOException {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Crear cliente");
        a.setContentText("¿ Deséa crear el cliente ?");
        final Optional<ButtonType> buttonType = a.showAndWait();
        if(buttonType.get() == ButtonType.OK){
            Stage stage = (Stage) btnAltaCliente.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaClientes.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Clientes");
            stage.setScene(scene);
        }
    }
}
