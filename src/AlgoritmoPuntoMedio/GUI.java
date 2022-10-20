package AlgoritmoPuntoMedio;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GUI extends JFrame {

    private BufferedImage buffer;
    private Graphics graPixel;
    int x0, x1, y0, y1, xend, dx, dy, p, incE, incNE;

    public GUI(String[] args) {
        super("PuntoMedio");
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
        p = 2 * dy - dx;
        incE = 2 * dy;
        incNE = 2 * (dy - dx);
    }

    @Override
    public void paint(Graphics g) {
        drawLine();
    }

    private void drawLine() {
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
            putPixel(x, y, Color.black);
            x = x + 1;
            if (p <= 0) {
                p = p + incE;
            } else {
                y = y + 1;
                p = p + incNE;
            }
        }
    }

    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }

}
