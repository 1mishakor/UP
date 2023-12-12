package com.example.matematico.MyClass;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.*;

public class Computer {
    protected GridPane pole;
    public Map elem;
    CardReader cardReader;
    public Computer(GridPane pole, Map elem, CardReader cardReader){
        this.pole = pole;
        this.elem = elem;
        this.cardReader = cardReader;
    }
    public void insertLabel(Player player){
        while (true) {
            int i1 = new Random().nextInt(0, 5),
                    i2 = new Random().nextInt(0, 5);
            if (Objects.equals(labelsComputer(getID(i1, i2)).getText(), "")) {
                labelsComputer(getID(i1,i2)).setText(String.valueOf(cardReader.getA()));
                cardReader.cardNew();
                cardReader.labelWrite();
                //System.out.println(cardReader.getCards());
                break;
            }
            //System.out.println("povt");
        }
        boolean bool = false;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String b = labelsComputer(getID(i, j)).getText();
                if (Objects.equals(b, "")) {
                    //System.out.println("-"+labelsComputer(getID(i, j))+"-");
                    bool = false;
                    break;
                }else {
                    //System.out.print(labelsComputer(getID(i, j))+",");
                    bool = true;
                }
            }if (!bool) break;
        }
        if (bool){
            new Checker(elem, pole, player.elem, player.pole, cardReader).checkResults();
        }
    }
    public String getID(int i, int j){
        return pole.getChildren().get(i*5+j).getId();
    }
    private Label labelsComputer(String id){
        return (Label) elem.get(id);
    }
}
