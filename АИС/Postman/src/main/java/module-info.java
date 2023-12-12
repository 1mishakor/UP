module com.example.postman {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

    opens com.example.postman to javafx.fxml;
    exports com.example.postman;
}