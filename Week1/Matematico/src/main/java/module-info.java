module com.example.matematico {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.matematico to javafx.fxml;
    exports com.example.matematico;
    exports com.example.matematico.Controller;
    opens com.example.matematico.Controller to javafx.fxml;
}