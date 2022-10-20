package CircunferenciaBresenham;

import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GUI extends JFrame {

    private BufferedImage buffer;
    private Graphics graPixel;
    int x, y, radius, d, tx, ty;

    public GUI(String[] args) {
        super("CircunferenciaBresenham");
        x = Integer.parseInt(args[0]);
        y = Integer.parseInt(args[1]);
        radius = Integer.parseInt(args[2]);
        setSize(800, 600);
        setVisible(true);
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        graPixel = (Graphics2D) buffer.createGraphics();
        tx = 0;
        ty = radius;
    }

    @Override
    public void paint(Graphics g) {
        drawCircle();
    }

    private void drawCircle() {

        for (; tx <= ty; tx++) {
            putPixel(x + tx, y + ty, Color.black);
            putPixel(x + tx, y - ty, Color.red);
            putPixel(x - tx, y + ty, Color.blue);
            putPixel(x - tx, y - ty, Color.pink);
            putPixel(x + ty, y + tx, Color.orange);
            putPixel(x + ty, y - tx, Color.pink);
            putPixel(x - ty, y + tx, Color.MAGENTA);
            putPixel(x - ty, y - tx, Color.cyan);

            if (d < 0) {
                d += 4 * tx + 6;
            } else {
                d += 4 * (tx - ty) + 10;
                ty--;
            }
        }
    }

    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }
}
