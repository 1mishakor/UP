package Misha.Week1.N7;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Кубик рубика");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyPanel panel = new MyPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        frame.add(panel);
        frame.setBounds(500,20,1000,1000);
        frame.setVisible(true);
    }
}
