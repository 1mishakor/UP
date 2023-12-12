package Misha.Week1.N7;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    protected int sizeBlock = 100;
    protected int x = 300;
    protected int y = 300;

    public void paintComponent(Graphics g) {
        this.setBackground(Color.LIGHT_GRAY);
// red green blue white orange yellow
        Color[] colors1 = {
                Color.RED, Color.BLUE,Color.GREEN,
                Color.ORANGE, Color.YELLOW,Color.WHITE,
                Color.BLUE, Color.WHITE,Color.RED,
        };
        Color[] colors2 = {
                Color.RED, Color.ORANGE,Color.GREEN,
                Color.WHITE, Color.GREEN,Color.RED,
                Color.YELLOW, Color.RED,Color.ORANGE,
        };
        Color[] colors3 = {
                Color.RED, Color.GREEN,Color.YELLOW,
                Color.BLUE, Color.ORANGE,Color.WHITE,
                Color.BLUE, Color.YELLOW,Color.YELLOW,
        };

        int[] arrayX;
        int[] arrayY;
        int jx = 1;
        int jy = 1;
        for (int i = 1; i <= 9; i++) {
            arrayX = new int[]{x + (sizeBlock * (jx - 1)), x + sizeBlock * jx, x + sizeBlock * jx, x + (sizeBlock * (jx - 1))};
            arrayY = new int[]{y + (sizeBlock * (jy - 1)), y + (sizeBlock * (jy - 1)), y + sizeBlock * jy, y + sizeBlock * jy};
            if (i % 3 == 0) {
                jx = 1;
                jy++;
            } else {
                jx++;
            }
            Polygon poly = new Polygon(arrayX, arrayY, 4);
            g.setColor(colors1[i-1]);
            g.fillPolygon(poly);
            g.setColor(Color.BLACK);
            g.drawPolygon(poly);
        }
        int[] arrayX1;
        int[] arrayY1;
        int xx = x;
        int yy = y;
        int ii = 1;
        for (int i = 1; i <= 9; i++) {
            arrayX1 = new int[]{xx, xx + sizeBlock, xx + sizeBlock + sizeBlock / 4, xx + sizeBlock / 4};
            xx += sizeBlock / 4;
            arrayY1 = new int[]{yy, yy, yy - sizeBlock / 4, yy - sizeBlock / 4};
            yy -= sizeBlock / 4;
            if (i % 3 == 0) {
                xx = x + sizeBlock * ii;
                yy = y;
                ii++;
            }
            Polygon poly = new Polygon(arrayX1, arrayY1, 4);
            g.setColor(colors2[i-1]);
            g.fillPolygon(poly);
            g.setColor(Color.BLACK);
            g.drawPolygon(poly);
        }


        int mx = x+3*sizeBlock;
        int my = y+3*sizeBlock;
        int mi = 1;
        int[] arrayX2;
        int[] arrayY2;

        for (int i = 1; i <= 9; i++) {
            arrayX2 = new int[]{mx, mx+sizeBlock/4, mx+sizeBlock/4, mx};
            arrayY2 = new int[]{my,my-sizeBlock/4, my-(sizeBlock+sizeBlock/4), my-sizeBlock};
            my-=sizeBlock;
            if (i % 3 == 0) {
                mx = x+3*sizeBlock;
                mx+=(sizeBlock/4)*mi;

                my=y+3*sizeBlock;
                my-=(sizeBlock/4)*mi;

                mi++;
            }
            Polygon poly = new Polygon(arrayX2, arrayY2, 4);
            g.setColor(colors3[i-1]);
            g.fillPolygon(poly);
            g.setColor(Color.BLACK);
            g.drawPolygon(poly);
        }
    }
}
