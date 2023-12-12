package com.example.matematico.MyClass;

import com.example.matematico.MyClass.DOP.WWPies;
import com.example.matematico.MyClass.DOP.WindowChanger;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.*;

public class Checker {
    private Map elemC, elemP;
    private int markC = 0, markP = 0;
    private GridPane poleC, poleP;
    private CardReader cardReader;

    public Checker(Map elemC, GridPane poleC, Map elemP, GridPane poleP, CardReader cardReader) {
        this.elemC = elemC;
        this.elemP = elemP;
        this.poleC = poleC;
        this.poleP = poleP;
        this.cardReader = cardReader;
    }

    private int checkC() {
        // rows
        for (int i = 0; i < 5; i++) {
            Integer[] list = new Integer[5];
            for (int j = 0; j < 5; j++) {
                int b = Integer.parseInt(labelsComputer(elemC, getID(poleC, i, j)).getText());
                list[j] = b;
            }
            markC += new Rules().getRules(list, false);
        }
        // columns
        for (int i = 0; i < 5; i++) {
            Integer[] list = new Integer[5];
            for (int j = 0; j < 5; j++) {
                int b = Integer.parseInt(labelsComputer(elemC, getID(poleC, j, i)).getText());
                list[j] = b;
            }
            markC += new Rules().getRules(list, false);
        }
        //diagonal 1
        Integer[] list = new Integer[5];
        for (int i = 0; i < 5; i++) {
            int b = Integer.parseInt(labelsComputer(elemC, getID(poleC, i, i)).getText());
            list[i] = b;
        }
        markC += new Rules().getRules(list, true);
        //diagonal 2
        Integer[] list2 = new Integer[5];
        for (int i = 0; i < 5; i++) {
            int b = Integer.parseInt(labelsComputer(elemC, getID(poleC, i, 4 - i)).getText());
            list2[i] = b;
        }
        markC += new Rules().getRules(list2, true);
        return markC;
    }

    private int checkP() {
        // rows
        for (int i = 0; i < 5; i++) {
            Integer[] list = new Integer[5];
            for (int j = 0; j < 5; j++) {
                int b = Integer.parseInt(labelsComputer(elemP, getID(poleP, i, j)).getText());
                list[j] = b;
            }
            markP += new Rules().getRules(list, false);
        }
        // columns
        for (int i = 0; i < 5; i++) {
            Integer[] list = new Integer[5];
            for (int j = 0; j < 5; j++) {
                int b = Integer.parseInt(labelsComputer(elemP, getID(poleP, j, i)).getText());
                list[j] = b;
            }
            markP += new Rules().getRules(list, false);
        }
        //diagonal 1
        Integer[] list = new Integer[5];
        for (int i = 0; i < 5; i++) {
            int b = Integer.parseInt(labelsComputer(elemP, getID(poleP, i, i)).getText());
            list[i] = b;
        }
        markP += new Rules().getRules(list, true);
        //diagonal 2
        Integer[] list2 = new Integer[5];
        for (int i = 0; i < 5; i++) {
            int b = Integer.parseInt(labelsComputer(elemP, getID(poleP, i, 4 - i)).getText());
            list2[i] = b;
        }
        markP += new Rules().getRules(list2, true);
        return markP;
    }

    public String getID(GridPane pole, int i, int j) {
        return pole.getChildren().get(i * 5 + j).getId();
    }

    private Label labelsComputer(Map elem, String id) {
        return (Label) elem.get(id);
    }

    public void checkResults() {
        WWPies wwPies = new WWPies("src\\main\\resources\\com\\example\\matematico\\Properties\\Marcs.properties");
        wwPies.writeProperty("markP", String.valueOf(checkP()));
        wwPies.writeProperty("markC", String.valueOf(checkC()));
        if (checkP()>checkC()) wwPies.writeProperty("winner", "true");
        else wwPies.writeProperty("winner", "false");
        cardReader.labelEndWrite();
       new WindowChanger().doterWind("/com/example/matematico/EndGame.fxml", "Победитель!");
    }
}
