package CircunferenciaPolar;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static java.lang.Math.round;

public class GUI extends JFrame {

    private BufferedImage buffer;
    private Graphics graPixel;
    int centro, radius;

    public GUI(String[] args) {
        super("CircunferenciaPolar");
        centro = Integer.parseInt(args[0]);
        radius = Integer.parseInt(args[1]);

        setSize(500, 500);
        setVisible(true);
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        graPixel = (Graphics2D) buffer.createGraphics();
        putPixel(centro, centro, Color.green);
    }

    @Override
    public void paint(Graphics g) {
        drawCircle();
    }

    private void drawCircle() {
        for (int t = 0; t < 360; t++) {
            double x1 = centro + radius * Math.sin(t);
            double y1 = centro + radius * Math.cos(t);
            putPixel((int) round(x1), (int) round(y1), Color.BLACK);
        }
    }

    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }
}
