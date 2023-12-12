package com.example.matematico.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import com.example.matematico.MyClass.CardReader;
import com.example.matematico.MyClass.DOP.WindowChanger;
import javafx.event.ActionEvent;
import com.example.matematico.MyClass.Computer;
import com.example.matematico.MyClass.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane Computer;

    @FXML
    private GridPane Player;

    @FXML
    private Label l1;

    @FXML
    private Label l10;

    @FXML
    private Label l10c;

    @FXML
    private Label l11;

    @FXML
    private Label l11c;

    @FXML
    private Label l12;

    @FXML
    private Label l12c;

    @FXML
    private Label l13;

    @FXML
    private Label l13c;

    @FXML
    private Label l14;

    @FXML
    private Label l14c;

    @FXML
    private Label l15;

    @FXML
    private Label l15c;

    @FXML
    private Label l16;

    @FXML
    private Label l16c;

    @FXML
    private Label l17;

    @FXML
    private Label l17c;

    @FXML
    private Label l18;

    @FXML
    private Label l18c;

    @FXML
    private Label l19;

    @FXML
    private Label l19c;

    @FXML
    private Label l1c;

    @FXML
    private Label l2;

    @FXML
    private Label l20;

    @FXML
    private Label l20c;

    @FXML
    private Label l21;

    @FXML
    private Label l21c;

    @FXML
    private Label l22;

    @FXML
    private Label l22c;

    @FXML
    private Label l23;

    @FXML
    private Label l23c;

    @FXML
    private Label l24;

    @FXML
    private Label l24c;

    @FXML
    private Label l25;

    @FXML
    private Label l25c;

    @FXML
    private Label l2c;

    @FXML
    private Label l3;

    @FXML
    private Label l3c;

    @FXML
    private Label l4;

    @FXML
    private Label l4c;

    @FXML
    private Label l5;

    @FXML
    private Label l5c;

    @FXML
    private Label l6;

    @FXML
    private Label l6c;

    @FXML
    private Label l7;

    @FXML
    private Label l7c;

    @FXML
    private Label l8;

    @FXML
    private Label l8c;

    @FXML
    private Label l9;

    @FXML
    private Label l9c;

    @FXML
    private Label yacubovichWord;
    @FXML
    void onMenu(ActionEvent event) {
        new WindowChanger().newWind(event, "/com/example/matematico/Menu.fxml", "Меню");
    }
    private Map<String, Label> labelsP = new HashMap<>();
    private Map<String, Label> labelsC = new HashMap<>();

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    // Player
        labelsP.put("l1", l1);
        labelsP.put("l2", l2);
        labelsP.put("l3", l3);
        labelsP.put("l4", l4);
        labelsP.put("l5", l5);
        labelsP.put("l6", l6);
        labelsP.put("l7", l7);
        labelsP.put("l8", l8);
        labelsP.put("l9", l9);
        labelsP.put("l10", l10);
        labelsP.put("l11", l11);
        labelsP.put("l12", l12);
        labelsP.put("l13", l13);
        labelsP.put("l14", l14);
        labelsP.put("l15", l15);
        labelsP.put("l16", l16);
        labelsP.put("l17", l17);
        labelsP.put("l18", l18);
        labelsP.put("l19", l19);
        labelsP.put("l20", l20);
        labelsP.put("l21", l21);
        labelsP.put("l22", l22);
        labelsP.put("l23", l23);
        labelsP.put("l24", l24);
        labelsP.put("l25", l25);
    //Computer
        labelsC.put("l1c", l1c);
        labelsC.put("l2c", l2c);
        labelsC.put("l3c", l3c);
        labelsC.put("l4c", l4c);
        labelsC.put("l5c", l5c);
        labelsC.put("l6c", l6c);
        labelsC.put("l7c", l7c);
        labelsC.put("l8c", l8c);
        labelsC.put("l9c", l9c);
        labelsC.put("l10c", l10c);
        labelsC.put("l11c", l11c);
        labelsC.put("l12c", l12c);
        labelsC.put("l13c", l13c);
        labelsC.put("l14c", l14c);
        labelsC.put("l15c", l15c);
        labelsC.put("l16c", l16c);
        labelsC.put("l17c", l17c);
        labelsC.put("l18c", l18c);
        labelsC.put("l19c", l19c);
        labelsC.put("l20c", l20c);
        labelsC.put("l21c", l21c);
        labelsC.put("l22c", l22c);
        labelsC.put("l23c", l23c);
        labelsC.put("l24c", l24c);
        labelsC.put("l25c", l25c);
        // Code
        CardReader cardReader = new CardReader(yacubovichWord);
        cardReader.labelWrite();
        Computer computer = new Computer(Computer, labelsC, cardReader);
        Player player = new Player(Player, labelsP, cardReader, computer);
        player.insertLabel();

        //new WindowChanger().getStage().close();
    }
}
