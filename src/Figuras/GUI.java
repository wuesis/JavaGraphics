package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GUI extends JFrame {


    private BufferedImage buffer;
    private Graphics graPixel;
    int x, y, pk, xc, yc, radius;

    public GUI(String[] args) {
        super("Figuras");
        xc = Integer.parseInt(args[0]);
        yc = Integer.parseInt(args[1]);
        radius = Integer.parseInt(args[2]);
        setSize(500, 500);
        setVisible(true);
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        graPixel = (Graphics2D) buffer.createGraphics();
        putPixel(xc, yc, Color.green);
        y = radius;
        x = 0;
        pk = 1 - radius;
    }

    @Override
    public void paint(Graphics g) {
        drawCircle();
    }

    private void drawCircle() {


    }

    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }
}
