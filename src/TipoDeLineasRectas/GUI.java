package TipoDeLineasRectas;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GUI extends JFrame {


    private BufferedImage buffer;
    private Graphics graPixel;
    int x0, x1, y0, y1, dx, dy;

    public GUI(String[] args) {
        super("TipoDeLineasRectas");
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

        int xend = 0;
        int dy = 0;
        int dx = 0;
        int p, j, i, k = 0;

        int xconst = 0;
        int yconst = 0;


        i = 2 * dy;
        j = 2 * (dy - dx);
        p = (2 * dy) - (dx);

        int[] mascara = {0, 0, 1, 1, 1, 0, 0};
        this.putPixel(x0, y0, Color.BLUE);

        if (x0 > x1) {
            xconst = x1;
            yconst = y1;
            xend = x0;
        } else {
            xconst = x0;
            yconst = y0;
            xend = x1;
        }


        while (xconst <= xend) {
            if (mascara[k] == 1) {
                putPixel(xconst, yconst, Color.BLACK);
            }
            k++;

            if (k >= mascara.length) {
                k = 0;
            }

            xconst = xconst + 1;
            if (p < 0) {
                p = p + i;
            } else {
                yconst = yconst + 1;
                p = p + j;
            }
        }

    }

    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }

}
