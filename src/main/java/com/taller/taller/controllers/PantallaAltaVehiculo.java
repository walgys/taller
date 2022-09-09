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

public class PantallaAltaVehiculo {

    @FXML
    private Button btnAgregarVehiculo;

    @FXML
    private Button btnVolverAgregarVehiculos;

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
    protected void onAgeregarVehiculoButtonClick() throws IOException {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Agregar Vehículo");
        a.setContentText("¿ Deséa agregar el vehículo ?");
        Optional<ButtonType> action = a.showAndWait();
        if(action.get() == ButtonType.OK){
            Stage stage = (Stage) btnAgregarVehiculo.getScene().getWindow();
            FXMLLoader fxmlLoader;
            if("PantallaAltaCliente".equals(lastScreen)){
                fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaAltaCliente.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage.setTitle("Alta de Cliente");
                stage.setScene(scene);
            }else{
                fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaClientes.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage.setTitle("Clientes");
                stage.setScene(scene);
            }
        }

    }

    @FXML
    protected void onVolverButtonClick() throws IOException {
        Stage stage = (Stage) btnAgregarVehiculo.getScene().getWindow();
        FXMLLoader fxmlLoader;
        if("PantallaAltaCliente".equals(lastScreen)){
            fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaAltaCliente.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Alta de Cliente");
            stage.setScene(scene);
        }else{
            fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaClientes.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Clientes");
            stage.setScene(scene);
        }
    }

}
