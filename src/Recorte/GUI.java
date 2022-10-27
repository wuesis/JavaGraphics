package Recorte;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GUI extends JFrame {

    private BufferedImage buffer;
    private int[][] Lados = new int[4][2];




    public GUI() {
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        setSize(300, 300);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        recortep(50, 50, 250, 250);
    }

    public void Línea_DDA(int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;

        int steps = Math.max(Math.abs(dx), Math.abs(dy));
        double incX = (double) dx / steps;
        double incY = (double) dy / steps;

        float x = x1;
        float y = y1;
        putPixel(Math.round(x), Math.round(y), Color.BLACK);
        for (int k = 1; k <= steps; k++) {
            x += incX;
            y += incY;
            putPixel(Math.round(x), Math.round(y), Color.BLACK);
        }
    }

    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }


    public void recortep(int x0, int y0, int x1, int y1) {
        Línea_DDA(x0, y0, x0, y1);
        Línea_DDA(x0, y0, x1, y0);
        Línea_DDA(x0, y1, x1, y1);
        Línea_DDA(x1, y0, x1, y1);

        Lados[0][0] = x0;
        Lados[0][1] = y0;
        Lados[1][0] = x1;
        Lados[1][1] = y1;


        // Recortes
        recorte(20, 150, 90, 220);
        recorte(70, 70, 100, 120);
        recorte(70, 20, 130, 75);
        recorte(220, 50, 250, 100);
        recorte(240, 185, 180, 250);
        recorte(280, 25, 100, 130);
        recorte(140, 35, 220, 100);
        recorte(10, 85, 190, 200);
        recorte(140, 205, 70, 10);
    }


    public void recorte(int x0, int y0, int x1, int y1) {
        boolean[] c1 = new boolean[4], c2 = new boolean[4];
        int b1 = Optenercomb(x0, y0, c1);
        int b2 = Optenercomb(x1, y1, c2);
        int Union = b1 & b2;
        boolean totalTrivialVisible = (b1 == b2) & b1 == Union;
        if (totalTrivialVisible) {
            if (Union == 0)
                Línea_DDA(x0, y0, x1, y1);
        } else {
            if (b1 == 0) {
                int aux = x0;
                x0 = x1;
                x1 = aux;
                aux = y0;
                y0 = y1;
                y1 = aux;
                boolean[] auxC = c1;
                c1 = c2;
                c2 = auxC;
            }
            x0 = Checkx(x0, c1);
            x1 = Checkx(x1, c2);
            y0 = Checky(y0, c1);
            y1 = Checky(y1, c2);
            Línea_DDA(x0, y0, x1, y1);
        }
    }


    private int Checkx(int xn, boolean[] code) {
        int x = xn;
        if (code[0])
            x = Lados[0][0];
        if (code[1])
            x = Lados[1][0];
        return x;
    }

    private int Checky(int y, boolean[] code) {
        if (code[2])
            y = Lados[0][1];
        if (code[3])
            y = Lados[1][1];
        return y;
    }


    public int Optenercomb(int x, int y, boolean[] bin) {
        String Check = "0000";     //expolicado en clase
        bin[0] = x < Lados[0][0];
        bin[1] = x > Lados[1][0];
        bin[2] = y < Lados[0][1];
        bin[3] = y > Lados[1][1];
        for (boolean bit : bin) {
            Check = Check + (bit ? "1" : "0");
        }
        return Integer.parseInt(Check, 2);
    }
}
