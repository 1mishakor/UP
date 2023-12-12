package com.example.matematico.Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import com.example.matematico.HelloApplication;
import com.example.matematico.MyClass.DOP.WWPies;
import com.example.matematico.MyClass.DOP.WindowChanger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class EndGameController {
    WWPies wwPies = new WWPies("src\\main\\resources\\com\\example\\matematico\\Properties\\Marcs.properties");
    private String markC = wwPies.getElement("markC");
    private String markP = wwPies.getElement("markP");
    private boolean winner = Boolean.parseBoolean(wwPies.getElement("winner"));

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView Gramote;

    @FXML
    private Label marcsC;

    @FXML
    private Label marcsP;

    @FXML
    private Label nameLable;
    @FXML
    private Button closeButton;

    @FXML
    void close(ActionEvent event) {
        Platform.exit();
        System.exit(0);
        //new HelloApplication().getClass();
    }

    //@FXML
    //private Button menu;

    //@FXML
    //void onMenu(ActionEvent event) {
    //    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    //}

    //@FXML
    //void restart(ActionEvent event) {
    //    new WindowChanger().newWind(event, "/com/example/matematico/hello-view.fxml", "Меню");
    //}

    @FXML
    void initialize() {
        if (winner) {
            File file = new File("C:\\Users\\ko-ma\\IdeaProjects\\" +
                    "Matematico\\src\\main\\resources\\com\\example\\matematico\\" +
                    "Image\\GramoteP.png");
            Image image2 = new Image(file.toURI().toString());
            Gramote.setImage(image2);
            nameLable.setText("Игрок!");
        } else {
            File file = new File("C:\\Users\\ko-ma\\IdeaProjects\\" +
                    "Matematico\\src\\main\\resources\\com\\example\\matematico\\" +
                    "Image\\GramoteC.png");
            Image image2 = new Image(file.toURI().toString());
            Gramote.setImage(image2);
            nameLable.setText("Компьютер!");
        }
        marcsC.setText("Баллы Компьютера: " + markC);
        marcsP.setText("Баллы Игрока: " + markP);
    }

}
