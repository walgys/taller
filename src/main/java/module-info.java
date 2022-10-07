module com.taller.taller {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.naming;
    requires java.sql;

    opens com.taller.taller to javafx.fxml;
    exports com.taller.taller;
    exports com.taller.taller.controllers;
    exports com.taller.taller.models;
    opens com.taller.taller.controllers to javafx.fxml;
    opens com.taller.taller.models to org.hibernate.orm.core;
}