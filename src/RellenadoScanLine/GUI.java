package RellenadoScanLine;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GUI extends JFrame {

    private BufferedImage buffer;
    Robot rb;

    public static void main(String[] args) {
        new GUI();
    }

    public GUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        try {
            rb = new Robot();
        } catch (AWTException e) {
        }
        drawRec(50, 50, 250, 250);
    }


    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }

    Color getPixel(int x, int y) {
        Point point = this.getLocationOnScreen();
        Color c = rb.getPixelColor(point.x + x, point.y + y);
        return c;
    }

    public void drawRec(int x1, int y1, int x2, int y2) {
        Línea_DDA(x1, y1, x1, y2);
        Línea_DDA(x1, y1, x2, y1);
        Línea_DDA(x2, y1, x2, y2);
        Línea_DDA(x1, y2, x2, y2);

        int x = x1 + Math.abs(x2 - x1) / 2;
        int y = y1 + Math.abs(y1 - y2) / 2;

        fill(x, y, Color.BLACK);
    }

    public void Línea_DDA(int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;

        int steps = Math.max(Math.abs(dx), Math.abs(dy));
        double incX = (double) dx / steps;
        double incY = (double) dy / steps;

        float x = x1;
        float y = y1;
        putPixel(Math.round(x), Math.round(y), Color.BLACK);
        for (int k = 1; k <= steps; k++) {
            x += incX;
            y += incY;
            putPixel(Math.round(x), Math.round(y), Color.BLACK);
        }
    }

    void fill(int x, int y, Color fill) {
        Color Color = getPixel(x, y);
        Color Pintado;

        do {
            Pintado = getPixel(x, --y);
        } while (y >= 0 && Color.equals(Pintado));
        y++;

        int xi = x;
        int width = getSize().width;
        int height = getSize().height;
        do {
            do {
                putPixel(x, y, fill);
                Pintado = getPixel(++x, y);
            } while (x <= width && Color.equals(Pintado));
            x = xi;

            do {
                putPixel(x, y, fill);
                Pintado = getPixel(--x, y);
            } while (x >= 0 && Color.equals(Pintado));
            x = xi;
            Pintado = getPixel(x, ++y);
        } while (y <= height && Color.equals(Pintado));
    }
}
