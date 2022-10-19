package LineaRectaMejorada;

import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

import static java.lang.Math.abs;
import static java.lang.Math.round;

public class GUI extends JFrame {

    private BufferedImage buffer;
    private Graphics graPixel;
    int x0, x1, y0, y1, steps, dx, dy, xinc, yinc;

    public GUI(String[] args) {
        super("LineaRectaMejorada(DDA)");
        x0 = Integer.parseInt(args[0]);
        y0 = Integer.parseInt(args[1]);
        x1 = Integer.parseInt(args[2]);
        y1 = Integer.parseInt(args[3]);
        setSize(500, 500);
        setVisible(true);
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        graPixel = (Graphics2D) buffer.createGraphics();

        dx = x1 - x0;
        dy = y1 - y0;

        if (abs(dx) > abs(dy))
            steps = abs(dx);
        else
            steps = abs(dy);

        xinc = dx / steps;
        yinc = dy / steps;
    }

    @Override
    public void paint(Graphics g) {
        drawLine();
    }

    private void drawLine() {
        int x = x0;
        int y = y0;

        putPixel(round(x), round(y), Color.BLACK);

        for (int k = 1; k <= steps; k++) {
            x = (x + xinc);
            y = y + yinc;
            putPixel(round(x), (int) round(y), Color.BLACK);
        }
    }

    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }
}
