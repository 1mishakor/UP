package com.example.matematico.MyClass;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.Map;
import java.util.Objects;

public class Player {
    protected GridPane pole;
    public Map elem;
    CardReader cardReader;
    Computer computer;
    public Player(GridPane pole, Map elem, CardReader cardReader, Computer computer){
        this.pole = pole;
        this.elem = elem;
        this.cardReader = cardReader;
        this.computer = computer;
    }
    public void insertLabel(){
        pole.getChildren().forEach(item -> {
            item.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (Objects.equals(labelsPlayer(item.getId()).getText(), "")) {
                        labelsPlayer(item.getId()).setText(String.valueOf(cardReader.getA()));
                        computer.insertLabel(Player.this);
                    }
                }

            });
        });
    }

    private Label labelsPlayer(String id){
        return (Label) elem.get(id);
    }
}
