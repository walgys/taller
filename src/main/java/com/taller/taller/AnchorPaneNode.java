package com.taller.taller;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

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
                System.out.println("Available");
            }else{
                System.out.println("Unavailable day");
            }
        });
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setNotAvailable(){
        this.setStyle("-fx-background-color:red; -fx-border-color:black; -fx-border-width:1;");

        this.available = false;
    }
}