package com.taller.taller.controllers;

import com.taller.taller.MainApplication;
import com.taller.taller.MainState;
import com.taller.taller.dao.VehiculoDao;
import com.taller.taller.models.Vehiculo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
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
    private TextField tfMarca;

    @FXML
    private TextField tfModelo;

    @FXML
    private TextField tfPatente;

    @FXML
    private TextField tfColor;

    @FXML
    private TextField tfNroChasis;

    @FXML
    private TextField tfNroMotor;

    @FXML
    private TextField tfAnio;

    @FXML
    private TextField tfAseguradora;

    @FXML
    private TextField tfNroPoliza;

    private Vehiculo vehiculo;

    private VehiculoDao vehiculoDao = VehiculoDao.instance();

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

                vehiculo = new Vehiculo();

                vehiculo.setAnio(tfAnio.getText());
                vehiculo.setAseguradora(tfAseguradora.getText());
                vehiculo.setColor(tfColor.getText());
                vehiculo.setMarca(tfMarca.getText());
                vehiculo.setModelo(tfModelo.getText());
                vehiculo.setNroChasis(tfNroChasis.getText());
                vehiculo.setNroMotor(tfNroMotor.getText());
                vehiculo.setNroPoliza(tfNroPoliza.getText());
                vehiculo.setPatente(tfPatente.getText());

                PantallaAltaCliente myController = fxmlLoader.getController();
                myController.addVehiculo(vehiculo);
                myController.setData();

            }else{
                fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaClientes.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage.setTitle("Clientes");
                stage.setScene(scene);

                vehiculo.setAnio(tfAnio.getText());
                vehiculo.setAseguradora(tfAseguradora.getText());
                vehiculo.setColor(tfColor.getText());
                vehiculo.setMarca(tfMarca.getText());
                vehiculo.setModelo(tfModelo.getText());
                vehiculo.setNroChasis(tfNroChasis.getText());
                vehiculo.setNroMotor(tfNroMotor.getText());
                vehiculo.setNroPoliza(tfNroPoliza.getText());
                vehiculo.setPatente(tfPatente.getText());
                vehiculoDao.save(vehiculo);

                PantallaClientes controller = fxmlLoader.getController();
                controller.setData();
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
            PantallaAltaCliente controller = fxmlLoader.getController();
            controller.setData();
        }else{
            fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaClientes.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Clientes");
            stage.setScene(scene);
            PantallaClientes controller = fxmlLoader.getController();
            controller.setData();
        }
    }

    public void setData(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
        tfAnio.setText(vehiculo.getAnio());
        tfAseguradora.setText(vehiculo.getAseguradora());
        tfColor.setText(vehiculo.getColor());
        tfMarca.setText(vehiculo.getMarca());
        tfModelo.setText(vehiculo.getModelo());
        tfNroChasis.setText(vehiculo.getNroChasis());
        tfNroMotor.setText(vehiculo.getNroMotor());
        tfNroPoliza.setText(vehiculo.getNroPoliza());
        tfPatente.setText(vehiculo.getPatente());
    }
}
