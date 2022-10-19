package LineaRectaBresenham;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static java.lang.Math.abs;
import static java.lang.Math.round;

public class GUI extends JFrame {

    private BufferedImage buffer;
    private Graphics graPixel;
    int x0, x1, y0, y1, xfinal, dx, dy, xk, yk;

    public GUI(String[] args) {
        super("LineaRectaBresenham");
        x0 = Integer.parseInt(args[0]);
        y0 = Integer.parseInt(args[1]);
        x1 = Integer.parseInt(args[2]);
        y1 = Integer.parseInt(args[3]);
        setSize(500, 500);
        setVisible(true);
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        graPixel = (Graphics2D) buffer.createGraphics();
        dx = Math.abs(x1 - x0);
        dy = Math.abs(y1 - y0);
    }

    @Override
    public void paint(Graphics g) {
        drawLine();
    }

    private void drawLine() {

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
                p = p + 2 * (dy - dx);;
            }
        }
    }

    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }
}
