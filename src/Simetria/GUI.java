package Simetria;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static java.lang.Math.round;

public class GUI extends JFrame {


    private BufferedImage buffer;
    private Graphics graPixel;
    int xc,yc, radius;

    public GUI(String[] args) {
        super("Simetria");
        xc = Integer.parseInt(args[0]);
        yc = Integer.parseInt(args[1]);
        radius = Integer.parseInt(args[2]);
        setSize(500, 500);
        setVisible(true);
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        graPixel = (Graphics2D) buffer.createGraphics();
        putPixel(xc, yc, Color.green);
    }

    @Override
    public void paint(Graphics g) {
        drawCircle();
    }

    private void drawCircle() {
        for (int t = 0; t < 45; t++) {
            double x1 = xc + radius * Math.sin(t);
            double y1 = xc + radius * Math.cos(t);

            double a = -x1;
            double a1 = -y1;


            putPixel((int) round(x1), (int) round(y1), Color.BLACK);
            putPixel((int) round(y1), (int) round(x1), Color.BLACK);

            putPixel((int) round(a), (int) round(a1), Color.ORANGE);
            putPixel((int) round(a1), (int) round(a), Color.ORANGE);

            putPixel((int) round(x1), (int) round(a1), Color.BLUE);
            putPixel((int) round(a1), (int) round(x1), Color.BLUE);

            putPixel((int) round(a1), (int) round(y1), Color.GREEN);
            putPixel((int) round(y1), (int) round(a1), Color.GREEN);
        }
    }

    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }
}
