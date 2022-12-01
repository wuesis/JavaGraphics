package Animacion3D;

import java.awt.*;
import java.awt.image.BufferedImage;

import static java.lang.Math.*;
import static java.lang.Math.round;

public class Graphic {

    private BufferedImage buffer;
    private Graphics g = null;
    private int width, height, counter;

    Graphic(int width, int height) {
        this.width = width;
        counter = 0;
        this.height = height;
        this.buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(x, y, c.getRGB());
    }

    public void drawBuffer() {
        g.drawImage(buffer, 0, 0, null);
    }

    public void setGraphics(Graphics g) {
        this.buffer = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
        this.g = g;
    }

    private int rotate(int eje1, int eje2, float angle, boolean type) {
        double sinAngle = sin(angle);
        double cosAngle = cos(angle);
        int answer = 0;
        if (type)
            answer = (int) (eje1 * cosAngle + eje2 * sinAngle);
        else
            answer = (int) (eje1 * cosAngle - eje2 * sinAngle);
        return answer;
    }

    public void line3D(int x0, int y0, int z0, int x1, int y1, int z1) {
        Color color = Color.green;
        int Xp = 20;
        int Yp = 40;
        int Zp = 90;
        int dx = 0;
        int dy = 0;
        int pasos = 0;
        float xinc = 0;
        float yinc = 0;
        float x = 0;
        float y = 0;

        x0 = x0 + Xp * (z0 / Zp);
        x1 = x1 + Xp * (z1 / Zp);
        y0 = y0 + Yp * (z0 / Zp);
        y1 = y1 + Yp * (z1 / Zp);

        x0 = Math.abs(x0);
        y0 = Math.abs(y0);
        x1 = Math.abs(x1);
        y1 = Math.abs(y1);

        dx = x1 - x0;
        dy = y1 - y0;
        if (abs(dx) > abs(dy))
            pasos = abs(dx);
        else
            pasos = abs(dy);
        xinc = dx / (float) pasos;
        yinc = dy / (float) pasos;
        x = x0;
        y = y0;

        for (int i = 1; i <= pasos; i++) {
            putPixel(round(x), round(y), color);
            y += yinc;
            x += xinc;

        }
    }

    public void drawCurve(int posX, int posY, int posZ, int[] x, int[] y, int[] z, Color c, float angle) {


        for (int i = 0; i < x.length - 1; i++) {
            // int realX = this.rotate(x[i], z[i], angle, false);
            // int realY = y[i];
            // int realZ = this.rotate(z[i], x[i], angle, true);
            // int realX2 = this.rotate(x[i+1], z[i+1], angle, false);
            // int realY2 = y[i+1];
            // int realZ2 = this.rotate(z[i+1], x[i+1], angle, true);

            int realX = x[i];
            int realY = this.rotate(y[i], z[i], angle, false);
            int realZ = this.rotate(z[i], y[i], angle, true);
            int realX2 = x[i + 1];
            int realY2 = this.rotate(y[i + 1], z[i + 1], angle, false);
            int realZ2 = this.rotate(z[i + 1], y[i + 1], angle, true);

            //int realX = this.rotate(x[i], y[i], angle, false);
            //int realY = this.rotate(y[i], x[i], angle, true);
            //int realZ = z[i];
            //int realX2 = this.rotate(x[i+1], y[i+1], angle, false);
            //int realY2 = this.rotate(y[i+1], x[i+1], angle, true);
            //int realZ2 = z[i+1];

            this.line3D(posX + realX, posY + realY, posZ + realZ, posX + realX2, posY + realY2, posZ + realZ2);
        }
    }

    public void drawCurvexz(int posX, int posY, int posZ, int[] x, int[] y, int[] z, Color c, float angle) {

        for (int i = 0; i < x.length - 1; i++) {

            int realX = this.rotate(x[i], z[i], angle, false);
             int realY = y[i];
             int realZ = this.rotate(z[i], x[i], angle, true);
             int realX2 = this.rotate(x[i+1], z[i+1], angle, false);
             int realY2 = y[i+1];
             int realZ2 = this.rotate(z[i+1], x[i+1], angle, true);

            this.line3D(posX + realX, posY + realY, posZ + realZ, posX + realX2, posY + realY2, posZ + realZ2);
        }
    }
}