package Cincunferencia;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static java.lang.Math.*;

public class GUI extends JFrame {


    private BufferedImage buffer;
    private Graphics graPixel;
    int x, y, xc, yc;
    double radius;

    public GUI(String[] args) {
        super("Circunferencia");
        xc = Integer.parseInt(args[0]);
        yc = Integer.parseInt(args[1]);
        radius = Integer.parseInt(args[2]);
        setSize(500, 500);
        setVisible(true);
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        graPixel = (Graphics2D) buffer.createGraphics();
        putPixel(xc,yc,Color.green);
    }

    @Override
    public void paint(Graphics g) {
        drawCircle();
    }

    private void drawCircle() {
        double a, b, c;
        double y1, y2;

        int xf = xc + (int) radius;
        a = Math.pow(radius, 2);
        for (int x = xc - (int) radius * (int) radius; x < xf; x++) {
            b = (double) (Math.pow((x - xc), 2));
            c = a - b;
            y1 = yc + Math.sqrt(c);
            y2 = yc - Math.sqrt(c);
            putPixel(x, (int) round(y1), Color.BLACK);
            putPixel(x, (int) round(y2), Color.BLACK);
        }

    }

    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }

}
