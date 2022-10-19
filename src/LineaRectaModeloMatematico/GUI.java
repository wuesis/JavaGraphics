package LineaRectaModeloMatematico;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static java.lang.Math.round;

public class GUI extends JFrame {
    private BufferedImage buffer;
    private Graphics graPixel;
    double  M, B;
    int x0, x1, y0, y1;

    public GUI(String[] args) {
        super("LineaRectaMM");
        x0 = Integer.parseInt(args[0]);
        y0 = Integer.parseInt(args[1]);
        x1 = Integer.parseInt(args[2]);
        y1 = Integer.parseInt(args[3]);
        setSize(500, 500);
        setVisible(true);
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        graPixel = (Graphics2D) buffer.createGraphics();
        M = (double) (y1 - y0) / (double) (x1 - x0);
        B = y0 - M * x0;
    }

    @Override
    public void paint(Graphics g) {
        drawLine();
    }

    private void drawLine(){
        float y = 0;
        for (int i = (int) x0; i <= x1; i++) {
            y = (float) (M * i + B);
            putPixel(i, round(y) , Color.red);
        }
    }

    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }

}
