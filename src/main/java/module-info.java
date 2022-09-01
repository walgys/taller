module com.taller.taller {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.taller.taller to javafx.fxml;
    exports com.taller.taller;
    exports com.taller.taller.controllers;
    opens com.taller.taller.controllers to javafx.fxml;
}