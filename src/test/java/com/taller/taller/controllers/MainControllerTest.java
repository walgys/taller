package com.taller.taller.controllers;

import com.taller.taller.MainApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
class MainControllerTest {

    Stage stage;

    @Start
    public void start (Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaLogin.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
        stage.toFront();
        this.stage = stage;
    }

    @Test
    public void should_contain_elements_with_text(FxRobot robot) {
        Assertions.assertThat(robot.lookup("#loginButton").queryAs(Button.class)).hasText("Ingresar");
        Assertions.assertThat(robot.lookup("#userInput").queryAs(TextField.class)).hasText("");
        Assertions.assertThat(robot.lookup("#passInput").queryAs(TextField.class)).hasText("");
    }

    @Test
    void when_button_is_clicked_text_changes(FxRobot robot) {
        // when:
        robot.clickOn("#userInput").write("test");
        robot.clickOn("#passInput").write("test");
        robot.clickOn("#loginButton");

        assertEquals("Menu Principal",stage.getTitle());
    }
}