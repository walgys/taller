package com.taller.taller.controllers;

import com.taller.taller.MainApplication;
import com.taller.taller.MainState;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

public class PantallaClientes {

    @FXML
    private Button btnVolverClientes;

    @FXML
    private Button btnNuevoCliente;

    @FXML
    private Button btnAgregarVehiculoCliente;

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
                MainState.getInstance().setStateProperty(Map.of("actualScreen","PantallaClientes", "lastScreen",lastScreen),"navigation");
            }catch (Exception ex){
                return;
            }
        }
    }

    @FXML
    protected void onNuevoClienteButtonClick() throws IOException {
        Stage stage = (Stage) btnNuevoCliente.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaAltaCliente.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Alta de Cliente");
        stage.setScene(scene);

    }

    @FXML
    protected void onAgregarVehiculoButtonClick() throws IOException {
        Stage stage = (Stage) btnAgregarVehiculoCliente.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaAltaVehiculo.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Agregar un Vehículo");
        stage.setScene(scene);

    }

    @FXML
    protected void onVolverButtonClick() throws IOException {
        Stage stage = (Stage) btnVolverClientes.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaMenuPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        stage.setTitle("Menu Principal");
        stage.setScene(scene);
    }

}
