package com.taller.taller.controllers;

import com.taller.taller.MainApplication;
import com.taller.taller.MainState;
import com.taller.taller.dao.ClienteDao;
import com.taller.taller.dao.TipoDocumentoDao;
import com.taller.taller.models.Cliente;
import com.taller.taller.models.TipoDocumento;
import com.taller.taller.models.Vehiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class PantallaAltaCliente {

    @FXML
    private Button btnVolverAltaCliente;

    @FXML
    private Button btnAltaCliente;

    @FXML
    private Button btnAgregarVehiculo;

    private String lastScreen;

    @FXML
    private ComboBox cmbTipoDocumento;

    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfNroDocumento;
    @FXML
    private TextField tfNroTelefono;
    @FXML
    private TextField tfEmail;
    @FXML
    private DatePicker dpFechaNacimiento;
    @FXML
    private TextField tfProvincia;
    @FXML
    private TextField tfLocalidad;
    @FXML
    private TextField tfCalle;
    @FXML
    private TextField tfCalleNro;

    @FXML
    private TableView<Vehiculo> tblVehiculos;
    @FXML
    private TableColumn<Vehiculo, String> tblClmPatente;
    @FXML
    private TableColumn<Vehiculo, String> tblClmMarca;
    @FXML
    private TableColumn<Vehiculo, String> tblClmModelo;
    @FXML
    private TableColumn<Vehiculo, String> tblClmPoliza;
    @FXML
    private TableColumn<Vehiculo, String> tblClmAseguradora;

    private List<Vehiculo> vehiculosList = new ArrayList<>();

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

            ClienteDao clienteDao = new ClienteDao();

            Cliente cliente = new Cliente();
            cliente.setCalle(tfCalle.getText());
            cliente.setDni(tfNroDocumento.getText());
            cliente.setEmail(tfEmail.getText());
            cliente.setLocalidad(tfLocalidad.getText());
            cliente.setCalleNro(tfCalleNro.getText());
            cliente.setNombre(tfNombre.getText());
            cliente.setTelefono(tfNroTelefono.getText());
            cliente.setProvincia(tfProvincia.getText());
            cliente.addVehiculos(vehiculosList);
            cliente.setFechaNacimiento(dpFechaNacimiento.getValue());

            TipoDocumentoDao tipoDocumentoDao = new TipoDocumentoDao();
            TipoDocumento tipoDocumento = tipoDocumentoDao.getByDescripcion(cmbTipoDocumento.getValue().toString());
            cliente.setTipoDocumento(tipoDocumento);

            clienteDao.save(cliente);

            Stage stage = (Stage) btnAltaCliente.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaClientes.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Clientes");
            stage.setScene(scene);
        }
    }

    public void setData(){

        cmbTipoDocumento.getItems().clear();
        TipoDocumentoDao tipoDocumentoDao = new TipoDocumentoDao();
        List<TipoDocumento> list = tipoDocumentoDao.getAll();
        for (TipoDocumento tipoDocumento : list) {
            cmbTipoDocumento.getItems().add(tipoDocumento.getDescripcion());
        }

        //make sure the property value factory should be exactly same as the e.g getStudentId from your model class
        tblClmPatente.setCellValueFactory(new PropertyValueFactory<>("Patente"));
        tblClmMarca.setCellValueFactory(new PropertyValueFactory<>("Marca"));
        tblClmPoliza.setCellValueFactory(new PropertyValueFactory<>("NroPoliza"));
        tblClmAseguradora.setCellValueFactory(new PropertyValueFactory<>("Aseguradora"));
        tblClmModelo.setCellValueFactory(new PropertyValueFactory<>("Modelo"));

        ObservableList<Vehiculo> vehiculoObservableList = FXCollections.observableArrayList(vehiculosList);
        tblVehiculos.setItems(vehiculoObservableList);
    }

    public void addVehiculo(Vehiculo vehiculo){
        vehiculosList.add(vehiculo);
    }
}
