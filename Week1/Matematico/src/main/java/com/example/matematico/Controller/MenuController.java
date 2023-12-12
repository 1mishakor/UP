package com.example.matematico.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.matematico.MyClass.DOP.WWPies;
import com.example.matematico.MyClass.DOP.WindowChanger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button YaAvto;

    @FXML
    private Label textAvtomob;

    @FXML
    private Button closeButton;

    @FXML
    void exit(ActionEvent event) {
        /*Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();*/
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void gameNow(ActionEvent event) {
        WindowChanger windowChanger = new WindowChanger();
        windowChanger.newWind(event, "/com/example/matematico/hello-view.fxml", "Математико");
    }

    @FXML
    void rules(ActionEvent event) {
        new WindowChanger().doterWind("/com/example/matematico/Rules.fxml", "Правила");
    }

    boolean b = false;

    @FXML
    void initialize() {
        YaAvto.setOnAction(event -> {
            b = !b;
            textAvtomob.setVisible(b);
        });
    }

}
