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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PantallaClientes {

    @FXML
    private Button btnVolverClientes;

    @FXML
    private Button btnNuevoCliente;

    @FXML
    private Button btnAgregarVehiculoCliente;

    @FXML
    private Button btnEditarVehiculoCliente;

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
    private ComboBox cmbClientes;

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

    private String lastScreen;

    private ClienteDao clienteDao = ClienteDao.instance();
    private TipoDocumentoDao tipoDocumentoDao = TipoDocumentoDao.instance();

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

        PantallaAltaCliente myController = fxmlLoader.getController();
        myController.setData();
    }

    @FXML
    protected void onEditarClienteButtonClick() throws IOException {

        final Optional<ButtonType> buttonType;

        Cliente cliente = clienteDao.getById(Integer.parseInt(cmbClientes.getValue().toString()));;

        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Actualizar cliente");
        a.setContentText("¿ Deséa actualizar el cliente ?");
        buttonType = a.showAndWait();


        if(buttonType.get() == ButtonType.OK) {
            cliente.setCalle(tfCalle.getText());
            cliente.setDni(tfNroDocumento.getText());
            cliente.setEmail(tfEmail.getText());
            cliente.setLocalidad(tfLocalidad.getText());
            cliente.setCalleNro(tfCalleNro.getText());
            cliente.setNombre(tfNombre.getText());
            cliente.setTelefono(tfNroTelefono.getText());
            cliente.setProvincia(tfProvincia.getText());
            cliente.setFechaNacimiento(dpFechaNacimiento.getValue());

            TipoDocumento tipoDocumento = tipoDocumentoDao.getByDescripcion(cmbTipoDocumento.getValue().toString());
            cliente.setTipoDocumento(tipoDocumento);

            cliente.setValido(true);

            clienteDao.save(cliente);
        }

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
    protected void onEditarVehiculoButtonClick() throws IOException {
        Stage stage = (Stage) btnEditarVehiculoCliente.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaAltaVehiculo.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Agregar un Vehículo");
        stage.setScene(scene);

        PantallaAltaVehiculo controller = fxmlLoader.getController();
        controller.setData(tblVehiculos.selectionModelProperty().get().getSelectedItem());
    }

    @FXML
    protected void onVolverButtonClick() throws IOException {
        Stage stage = (Stage) btnVolverClientes.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaMenuPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        stage.setTitle("Menu Principal");
        stage.setScene(scene);
    }

    private void comboAction() {
        Cliente cliente = clienteDao.getById(Integer.parseInt(cmbClientes.getValue().toString()));
        tfCalle.setText(cliente.getCalle());
        tfEmail.setText(cliente.getEmail());
        tfLocalidad.setText(cliente.getLocalidad());
        tfNombre.setText(cliente.getNombre());
        tfCalleNro.setText(cliente.getCalleNro());
        tfNroDocumento.setText(cliente.getDni());
        tfNroTelefono.setText(cliente.getTelefono());
        tfProvincia.setText(cliente.getProvincia());
        if(cliente.getFechaNacimiento() != null) {
            dpFechaNacimiento.setValue(cliente.getFechaNacimiento());
        }else{
            dpFechaNacimiento.setValue(null);
        }
        cmbTipoDocumento.setValue(cliente.getTipoDocumento().getDescripcion());
        vehiculosList = cliente.getVehiculos();
        ObservableList<Vehiculo> vehiculoObservableList = FXCollections.observableArrayList(vehiculosList);
        tblVehiculos.setItems(vehiculoObservableList);
    }

    public void setData(){

        cmbTipoDocumento.getItems().clear();

        List<TipoDocumento> tdlist = tipoDocumentoDao.getAll();
        for (TipoDocumento tipoDocumento : tdlist) {
            cmbTipoDocumento.getItems().add(tipoDocumento.getDescripcion());
        }

        //make sure the property value factory should be exactly same as the e.g getStudentId from your model class
        tblClmPatente.setCellValueFactory(new PropertyValueFactory<>("Patente"));
        tblClmMarca.setCellValueFactory(new PropertyValueFactory<>("Marca"));
        tblClmPoliza.setCellValueFactory(new PropertyValueFactory<>("NroPoliza"));
        tblClmAseguradora.setCellValueFactory(new PropertyValueFactory<>("Aseguradora"));
        tblClmModelo.setCellValueFactory(new PropertyValueFactory<>("Modelo"));

        cmbClientes.getItems().clear();
        List<Cliente> list = clienteDao.getAll();
        ObservableList<Cliente> clienteObservableList = FXCollections.observableArrayList(list);
        cmbClientes.getItems().addAll(clienteObservableList);

        cmbClientes.setCellFactory(new Callback<ListView<Cliente>, ListCell<Cliente>>(){

            @Override
            public ListCell<Cliente> call(ListView<Cliente> p) {

                final ListCell<Cliente> cell = new ListCell<Cliente>(){

                    @Override
                    protected void updateItem(Cliente t, boolean bln) {
                        super.updateItem(t, bln);

                        if(t != null){
                            setText(t.getId() + " - " + t.getNombre());
                        }else{
                            setText(null);
                        }
                    }

                };

                return cell;
            }
        });

        // Create action event
        EventHandler<ActionEvent> event = e -> comboAction();

        // Set on action
        cmbClientes.setOnAction(event);

    }
}
