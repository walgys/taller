package com.taller.taller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Create an anchor pane that can store additional data.
 */
public class AnchorPaneNode extends AnchorPane {

    // Date associated with this pane
    private LocalDate date;
    private Boolean available = true;
    /**
     * Create a anchor pane node. Date is not assigned in the constructor.
     * @param children children of the anchor pane
     */
    public AnchorPaneNode(Node... children) {
        super(children);
        this.setStyle("-fx-border-color:black; -fx-border-width:1;");
        // Add action handler for mouse clicked
        this.setOnMouseClicked(e -> {
            if (available){
                Stage stage = (Stage) this.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaReservarTurno.fxml"));
                Scene scene = null;
                try {
                    scene = new Scene(fxmlLoader.load(), 400, 400);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                stage.setTitle("Reservar turno");
                stage.setScene(scene);
            }else{
                Stage stage = (Stage) this.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ModalCancelarTurno.fxml"));
                Scene scene = null;
                try {
                    scene = new Scene(fxmlLoader.load(), 400, 400);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                stage.setTitle("Cancelar turno");
                stage.setScene(scene);
            }
        });
    }

    public void setNotAvailable(){
        this.setStyle("-fx-background-color:red; -fx-border-color:black; -fx-border-width:1;");

        this.available = false;
    }
}