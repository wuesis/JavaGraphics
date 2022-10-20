package TipoDeLineasCircunferencia;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GUI extends JFrame {

    private BufferedImage buffer;
    private Graphics graPixel;
    int xc, yc, radius, x, y, d;
    int mascara[] = {1, 1, 1, 1, 1, 0, 0};

    public GUI(String[] args) {
        super("TipoDeLineasCircunferencia");
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
        d = 3 - 2 * radius;
    }

    @Override
    public void paint(Graphics g) {
        drawCircle();
    }

    private void drawCircle() {

        putPixel(xc + x, yc + y, Color.BLACK);
        int ContadorMascara = 0;
        for (; x < y; x++) {
            if (mascara[ContadorMascara] == 1) {
                putPixel(xc + x, yc + y, Color.BLACK);
                putPixel(xc - x, yc + y, Color.BLACK);
                putPixel(xc + x, yc - y, Color.BLACK);
                putPixel(xc - x, yc - y, Color.BLACK);
                putPixel(xc + y, yc + x, Color.BLACK);
                putPixel(xc - y, yc + x, Color.BLACK);
                putPixel(xc + y, yc - x, Color.BLACK);
                putPixel(xc - y, yc - x, Color.BLACK);
            }

            if (d < 0) {
                d += 4 * x + 6;

            } else {

                d += 4 * (x - y) + 10;
                y--;
            }

            if (mascara[ContadorMascara] == 1)
                putPixel(xc + x, yc + y, Color.BLACK);
            ContadorMascara++;
            if (ContadorMascara >= mascara.length)
                ContadorMascara = 0;
        }
    }

    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }

}
