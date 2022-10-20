package CircunferenciaPuntoMedio;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static java.lang.Math.round;

public class GUI extends JFrame {


    private BufferedImage buffer;
    private Graphics graPixel;
    int x, y, pk, xc, yc, radius;

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
        y = radius;
        x = 0;
        pk = 1 - radius;
    }

    @Override
    public void paint(Graphics g) {
        drawCircle();
    }

    private void drawCircle() {

        for (; x < y; x++) {
            if (pk < 0) {
                pk = pk + 2 * x + 3;
            } else {
                y--;
                pk = pk + 2 * (x - y) + 5;
            }
            putPixel(xc + x, yc + y, Color.black);
            putPixel(xc - x, yc + y, Color.black);
            putPixel(xc + x, yc - y, Color.black);
            putPixel(xc - x, yc - y, Color.black);
            putPixel(xc + y, yc + x, Color.black);
            putPixel(xc - y, yc + x, Color.black);
            putPixel(xc + y, yc - x, Color.black);
            putPixel(xc - y, yc - x, Color.black);
        }
    }

    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }
}
