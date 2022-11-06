package com.taller.taller.controllers;

import com.taller.taller.MainApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
class PantallaMenuPrincipalTest {

    Stage stage;

    @Start
    public void start (Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaMenuPrincipal.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
        stage.toFront();
        this.stage = stage;
    }

    @Test
    public void should_contain_elements(FxRobot robot) {
        Assertions.assertThat(robot.lookup("#accountButton").queryAs(ImageView.class)).isEnabled();
        Assertions.assertThat(robot.lookup("#scheduleButton").queryAs(ImageView.class)).isEnabled();
        Assertions.assertThat(robot.lookup("#btnInformes").queryAs(ImageView.class)).isEnabled();
    }

    @Test
    void when_accountButton_is_clicked_text_changes(FxRobot robot) {
        // when:
        robot.clickOn("#accountButton");
        assertEquals("Clientes",stage.getTitle());
    }

    @Test
    void when_scheduleButton_is_clicked_text_changes(FxRobot robot) {
        // when:
        robot.clickOn("#scheduleButton");
        assertEquals("Agenda",stage.getTitle());
    }

    @Test
    void when_btnInformes_is_clicked_text_changes(FxRobot robot) {
        // when:
        robot.clickOn("#btnInformes");
        assertEquals("Informes",stage.getTitle());
    }
}