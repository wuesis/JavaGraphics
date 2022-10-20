package CircunferenciaBresenham;

import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GUI extends JFrame {

    private BufferedImage buffer;
    private Graphics graPixel;
    int tx, ty, radius, d;

    public GUI(String[] args) {
        super("Simetria");
        tx = Integer.parseInt(args[0]);
        ty = Integer.parseInt(args[1]);
        radius = Integer.parseInt(args[2]);
        setSize(500, 500);
        setVisible(true);
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        graPixel = (Graphics2D) buffer.createGraphics();
        putPixel(tx, ty, Color.green);
        y = radius;
        x = 0;
        pk = 1 - radius;
    }

    @Override
    public void paint(Graphics g) {
        drawCircle();
    }

    private void drawCircle() {
        while (tx <= ty) {
            putPixel(x + tx, y + ty, color);
            putPixel(x + tx, y - ty, color);
            putPixel(x - tx, y + ty, color);
            putPixel(x - tx, y - ty, color);
            putPixel(x + ty, y + tx, color);
            putPixel(x + ty, y - tx, color);
            putPixel(x - ty, y + tx, color);
            putPixel(x - ty, y - tx, color);

            if (d < 0) {
                d += 4 * tx + 6;
            } else {
                d += 4 * (tx - ty) + 10;
                ty--;
            }
            tx++;
        }
    }

    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }
}
