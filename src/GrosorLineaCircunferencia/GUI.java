package GrosorLineaCircunferencia;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GUI extends JFrame {

    private BufferedImage buffer;
    private Graphics graPixel;
    int xc, yc, radius, grosor;

    public GUI(String[] args) {
        super("GrosorLineaCircunferencia");
        xc = Integer.parseInt(args[0]);
        yc = Integer.parseInt(args[1]);
        radius = Integer.parseInt(args[2]);
        grosor = Integer.parseInt(args[2]);
        setSize(800, 600);
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
        double PI, i, angulo, x1, y1;
        PI = 3.141592;
        for (i = 0; i < 360; i += 0.1) {
            angulo = i;
            x1 = radius * Math.cos(angulo * PI / 180);
            y1 = radius * Math.sin(angulo * PI / 180);
            putPixel((int) (xc + x1), (int) (yc + y1), Color.black);

            for (int ax = 0; ax <= grosor; ax++) {
                for (int ay = 0; ay <= grosor; ay++) {
                    putPixel((int) (xc + x1 + (ax)), (int) (yc + y1 + (ax)), Color.black);
                }
            }
        }
    }

    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }

}
