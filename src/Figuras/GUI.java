package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static java.lang.Math.abs;
import static java.lang.Math.round;

public class GUI extends JFrame {


    private BufferedImage buffer;
    private Graphics graPixel;

    public GUI(String[] args) {
        super("Figuras");
        setSize(800, 600);
        setVisible(true);
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        graPixel = (Graphics2D) buffer.createGraphics();
    }

    @Override
    public void paint(Graphics g) {
        drawLineOne();
        drawLineDDA();
        drawLineBresenham();
        drawLineMiddle();
        drawCircle();
        drawRectangle();
    }

    private void drawRectangle(){
        drawLine(30,250,300,250);
        drawLine(30,250,30,350);
        drawLine(30,350,300,350);
        drawLine(300,350,300,250);
    }

    private void drawLine(int x0,int y0,int x1,int y1) {

        int steps, dx, dy, xinc, yinc;

        int x = x0;
        double y = y0;

        dx = x1 - x0;
        dy = y1 - y0;

        if (abs(dx) > abs(dy)) {
            steps = abs(dx);

        } else {
            steps = abs(dy);
        }

        xinc = dx / steps;
        yinc = dy / steps;

        putPixel((int) round(x), (int) round(y), Color.BLACK);

        for (int k = 1; k <= steps; k++) {
            x = (x + xinc);
            y = y + yinc;
            putPixel((int) round(x), (int) round(y), Color.BLACK);
        }
    }

    private void drawCircle() {
        int xc = 400, yc = 300;
        double radius = 60;

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

    private void drawLineMiddle() {

        int x0 = 330, x1 = 400, y0 = 150, y1 = 0, xend, dx, dy, p, incE, incNE;

        dx = x1 - x0;
        dy = y1 - y0;
        p = 2 * dy - dx;
        incE = 2 * dy;
        incNE = 2 * (dy - dx);

        int x, y;

        if (x0 > x1) {
            x = x1;
            y = y1;
            xend = x0;
        } else {
            x = x0;
            y = y0;
            xend = x1;
        }

        while (x <= xend) {
            putPixel(x, y, Color.cyan);
            x = x + 1;
            if (p <= 0) {
                p = p + incE;
            } else {
                y = y + 1;
                p = p + incNE;
            }
        }

    }

    private void drawLineBresenham() {

        int x0 = 220, x1 = 300, y0 = 50, y1 = 150, xfinal, dx, dy, xk, yk;

        dx = Math.abs(x1 - x0);
        dy = Math.abs(y1 - y0);

        putPixel(x0, y0, Color.black);
        int p = (2 * dy) - (dx);
        if (x0 > x1) {
            xk = x1;
            yk = y1;
            xfinal = x0;
        } else {
            xk = x0;
            yk = y0;
            xfinal = x1;
        }

        while (xk <= xfinal) {
            this.putPixel(xk, yk, Color.black);
            xk = xk + 1;
            if (p < 0) {
                p = p + 2 * dy;
            } else {
                yk = yk + 1;
                p = p + 2 * (dy - dx);
                ;
            }
        }
    }

    private void drawLineDDA() {

        int x0 = 150, x1 = 150, y0 = 50, y1 = 150, steps, dx, dy, xinc, yinc;

        dx = x1 - x0;
        dy = y1 - y0;

        if (abs(dx) > abs(dy))
            steps = abs(dx);
        else
            steps = abs(dy);

        xinc = dx / steps;
        yinc = dy / steps;

        int x = x0;
        int y = y0;

        putPixel(round(x), round(y), Color.pink);

        for (int k = 1; k <= steps; k++) {
            x = (x + xinc);
            y = y + yinc;
            putPixel(round(x), (int) round(y), Color.pink);
        }

    }

    private void drawLineOne() {
        int x0 = 30, x1 = 100, y0 = 50, y1 = 150;
        double M, B;

        M = (y1 - y0) / (x1 - x0);
        B = y0 - M * x0;
        float y = 0;
        for (int i = (int) x0; i <= x1; i++) {
            y = (float) (M * i + B);
            putPixel(i, round(y), Color.red);
        }

    }

    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }
}
