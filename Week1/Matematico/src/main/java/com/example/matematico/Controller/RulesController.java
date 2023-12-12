package com.example.matematico.Controller;

import java.io.File;
import java.net.URL;

import com.example.matematico.MyClass.DOP.WindowChanger;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class RulesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonBack;

    @FXML
    private Button goButton;

    @FXML
    private ImageView image;

    @FXML
    void back(ActionEvent event) {
        File file = new File("C:\\Users\\ko-ma\\IdeaProjects\\" +
                "Matematico\\src\\main\\resources\\com\\example\\matematico\\" +
                "Image\\Rules\\rules.png");
        Image image2 = new Image(file.toURI().toString());
        image.setImage(image2);
        goButton.setDisable(false);
        buttonBack.setDisable(true);
    }

    @FXML
    void go(ActionEvent event) {
        File file = new File("C:\\Users\\ko-ma\\IdeaProjects\\" +
                "Matematico\\src\\main\\resources\\com\\example\\matematico\\" +
                "Image\\Rules\\Таблица_Оценивания.png");
        Image image2 = new Image(file.toURI().toString());
        image.setImage(image2);
        goButton.setDisable(true);
        buttonBack.setDisable(false);
    }

    @FXML
    void initialize() {
        File file = new File("C:\\Users\\ko-ma\\IdeaProjects\\" +
                "Matematico\\src\\main\\resources\\com\\example\\matematico\\" +
                "Image\\Rules\\rules.png");
        Image image2 = new Image(file.toURI().toString());
        image.setImage(image2);
    }

}