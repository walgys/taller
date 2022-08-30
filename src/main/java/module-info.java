module com.taller.taller {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.taller.taller to javafx.fxml;
    exports com.taller.taller;
}