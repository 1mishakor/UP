package com.example.matematico.MyClass;

import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Random;

public class CardReader {
    public Label label;
    private final int[][] cards = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}};
    private  int i = new Random().nextInt(0, 3);
    private  int j = new Random().nextInt(0, 12);
    private int a = cards[i][j];

    public CardReader(Label label) {
        this.label = label;
    }

    public void cardNew() {
        cards[i][j] = -1;
        //int ar=0;
        do {
            i = new Random().nextInt(0, 4);
            j = new Random().nextInt(0, 13);
            a = cards[i][j];
            //ar++;
        }while (a == -1);
        //System.out.println(ar);
    }

    public void labelWrite() {
        label.setText("Выпавшая карта: " + a);
    }
    public void labelEndWrite(){
        label.setText("И победитель у нас!!!");
    }
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public String getCards() {
        StringBuilder res= new StringBuilder("cards:\n");
        for (int k = 0; k < 4; k++) {
            for (int k1 = 0; k1 < 13; k1++){
                res.append(+cards[k][k1]+", ");
            }
            res.append("\n");
        }
        return res.toString();
    }
}
