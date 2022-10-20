package GrosorLine;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GUI extends JFrame {


    private BufferedImage buffer;
    private Graphics graPixel;
    int x0, x1, y0, y1, LAnc, dx, dy;


    public GUI(String[] args) {
        super("GrosorLinea");
        x0 = Integer.parseInt(args[0]);
        y0 = Integer.parseInt(args[1]);
        x1 = Integer.parseInt(args[2]);
        y1 = Integer.parseInt(args[3]);
        LAnc = Integer.parseInt(args[4]);
        setSize(500, 500);
        setVisible(true);
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        graPixel = (Graphics2D) buffer.createGraphics();
        dx = (x1 - x0);
        dy = (y1 - y0);

    }

    @Override
    public void paint(Graphics g) {
        drawLine();
    }

    public void drawLine() {

        int steps;
        double incrementoX, incrementoY, x, y;
        steps = Math.abs(dx) > Math.abs(dy) ? Math.abs(dx) : Math.abs(dy);
        incrementoX = (double) dx / steps;
        incrementoY = (double) dy / steps;
        x = x0;
        y = y0;

        for (int i = 0; i < steps; i++) {
            x = x + incrementoX;
            y = y + incrementoY;
            if (Math.abs(dx) <= Math.abs(dy))
                grosorx((int) x, LAnc, Color.BLACK);
            else
                grosory((int) y, LAnc, Color.BLACK);
        }
    }
    public void grosorx(int x, int grosor, Color color) {
        for (int j = 0; j < 1; j++) {
            int x1 = x + j;
            putPixel(x1, x, color);
        }

        for (int j = 0; j < (grosor / 2); j++) {
            int x1 = x - j;
            putPixel(x1, x, color);
        }
    }
    public void grosory(int y, int grosor, Color color) {
        for (int i = 0; i < grosor; i++) {
            int yG = y + i;
            putPixel(yG, y, color);
        }

        for (int i = 0; i < (grosor); i++) {
            int yG = y - i;
            putPixel(yG, y, color);
        }
    }

    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }

}
