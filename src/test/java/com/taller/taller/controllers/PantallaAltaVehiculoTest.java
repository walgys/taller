package com.taller.taller.controllers;

import com.taller.taller.MainApplication;
import com.taller.taller.MainState;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.base.NodeMatchers;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.testfx.api.FxAssert.verifyThat;

@ExtendWith(ApplicationExtension.class)
class PantallaAltaVehiculoTest {

    private Stage stage;

    @Start
    public void start (Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaAltaVehiculo.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
        stage.toFront();
        this.stage = stage;
    }

    @Test
    public void should_contain_elements(FxRobot robot) {
        Assertions.assertThat(robot.lookup("#btnAgregarVehiculo").queryAs(Button.class)).hasText("Agregar Vehículo");
        Assertions.assertThat(robot.lookup("#btnVolverAgregarVehiculos").queryAs(Button.class)).hasText("<< Volver");
    }

    @Test
    void when_btnVolverAgregarVehiculos_is_clicked(FxRobot robot) {
        //from AltaClientes
        MainState.getInstance().setStateProperty(Map.of("actualScreen","PantallaAltaVehiculo", "lastScreen","PantallaAltaCliente"),"navigation");
        // when:
        robot.clickOn("#btnVolverAgregarVehiculos");
        assertEquals("Clientes",stage.getTitle());
    }

    @Test
    void when_btnAgregarVehiculos_is_clicked(FxRobot robot) {
        // when:
        robot.clickOn("#btnAgregarVehiculo");
        verifyThat("OK", NodeMatchers.isVisible());
        verifyThat("Cancel", NodeMatchers.isVisible());
        robot.clickOn("Cancel");
    }

}