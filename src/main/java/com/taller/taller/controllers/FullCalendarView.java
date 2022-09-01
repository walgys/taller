package com.taller.taller.controllers;
import com.taller.taller.AnchorPaneNode;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.*;


public class FullCalendarView {

    private ArrayList<AnchorPaneNode> allCalendarDays = new ArrayList<>(35);
    private VBox view;
    private Map<String,String> turnosTotales = new HashMap<>();
    private Map<String,String> turnosOcupados = new HashMap<>();

    public FullCalendarView() {
        // Create the calendar grid pane
        FlowPane calendar = new FlowPane();
        calendar.setAlignment(Pos.CENTER);
        calendar.setHgap(40);
        calendar.setVgap(40);
        calendar.setPrefSize(600, 400);
        // Create rows and columns with anchor panes for the calendar
        turnosTotales.put("8","8:00 hs");
        turnosTotales.put("9","9:00 hs");
        turnosTotales.put("10","10:00 hs");
        turnosTotales.put("11","11:00 hs");
        turnosTotales.put("13","13:00 hs");
        turnosTotales.put("12","12:00 hs");
        turnosTotales.put("14","14:00 hs");
        turnosTotales.put("15","15:00 hs");
        turnosTotales.put("16","16:00 hs");
        turnosTotales.put("17","17:00 hs");
        turnosOcupados.put("12","Almuerzo");
        turnosOcupados.put("9","Juan Martinez");
        turnosTotales.forEach((key,value)->{
            AnchorPaneNode apn = new AnchorPaneNode();
            apn.setPrefSize(100, 100);
            if(turnosOcupados.keySet().contains(key)){
                String reason = turnosOcupados.get(key);
                Text text = new Text(reason);
                AnchorPane ap = new AnchorPane();
                ap.setPrefSize(100, 10);
                ap.setBottomAnchor(text, 5.0);
                ap.getChildren().add(text);
                apn.getChildren().add(ap);
                apn.setNotAvailable();
            }else{
                Text text = new Text(value);
                AnchorPane ap = new AnchorPane();
                ap.setPrefSize(100, 10);
                ap.setBottomAnchor(text, 5.0);
                ap.getChildren().add(text);
                apn.getChildren().add(ap);
            }
            calendar.getChildren().add(apn);
        });
        view = new VBox(calendar);
    }

    public VBox getView() {
        return view;
    }
}