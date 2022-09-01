package com.taller.taller.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

public class PantallaAgenda {

    @FXML
    private FlowPane agendaAnchor;

    public void addChildToPane(Node node){
        agendaAnchor.getChildren().add(node);
    }
}
