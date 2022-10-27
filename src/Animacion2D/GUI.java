package Animacion2D;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;


import static java.lang.Math.abs;
import static java.lang.Math.round;

public class GUI extends JFrame implements Runnable {

    private BufferedImage boddyCatBuffer, backgroundBuffer, stellaBufferInitial, stellaBufferFinal, headBufferInitial, headBufferSecond, headBufferFinal;

    private BufferedImage feetBuffer_1;

    public Graphics graphics;

    public Random random;

    public boolean filling = false;
    Runnable backGroundRunable = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i <= 599; i++)
                for (int j = 0; j < 999; j++)
                    putPixel(j, i, backgroundBuffer, new Color(0x003366));
            graphics.drawImage(backgroundBuffer, 0, 0, GUI.this);
        }
    };
    Runnable StellaRunable = new Runnable() {
        @Override
        public void run() {
            try {
                //Rojo
                drawRecFill(0, 10, 74, 44, stellaBufferInitial, new Color(0xFF2D0E));
                drawRecFill(75, 0, 224, 34, stellaBufferInitial, new Color(0xFF2D0E));
                drawRecFill(225, 10, 374, 44, stellaBufferInitial, new Color(0xFF2D0E));
                drawRecFill(375, 0, 474, 34, stellaBufferInitial, new Color(0xFF2D0E));
                //Naranja
                drawRecFill(0, 45, 74, 79, stellaBufferInitial, new Color(0xFFA804));
                drawRecFill(75, 35, 224, 69, stellaBufferInitial, new Color(0xFFA804));
                drawRecFill(225, 45, 374, 79, stellaBufferInitial, new Color(0xFFA804));
                drawRecFill(375, 35, 474, 69, stellaBufferInitial, new Color(0xFFA804));
                //Amarillo
                drawRecFill(0, 80, 74, 114, stellaBufferInitial, new Color(0xFFFF00));
                drawRecFill(75, 70, 224, 104, stellaBufferInitial, new Color(0xFFFF00));
                drawRecFill(225, 80, 374, 114, stellaBufferInitial, new Color(0xFFFF00));
                drawRecFill(375, 70, 474, 104, stellaBufferInitial, new Color(0xFFFF00));
                //Verde
                drawRecFill(0, 115, 74, 149, stellaBufferInitial, new Color(0x5CFF01));
                drawRecFill(75, 105, 224, 139, stellaBufferInitial, new Color(0x5CFF01));
                drawRecFill(225, 115, 374, 149, stellaBufferInitial, new Color(0x5CFF01));
                drawRecFill(375, 105, 474, 139, stellaBufferInitial, new Color(0x5CFF01));

                //Azul
                drawRecFill(0, 150, 74, 184, stellaBufferInitial, new Color(0x37ADFF));
                drawRecFill(75, 140, 224, 174, stellaBufferInitial, new Color(0x37ADFF));
                drawRecFill(225, 150, 374, 184, stellaBufferInitial, new Color(0x37ADFF));
                drawRecFill(375, 140, 474, 174, stellaBufferInitial, new Color(0x37ADFF));
                //Naranja
                drawRecFill(0, 185, 74, 219, stellaBufferInitial, new Color(0xC74FFD));
                drawRecFill(75, 175, 224, 209, stellaBufferInitial, new Color(0xC74FFD));
                drawRecFill(225, 185, 374, 219, stellaBufferInitial, new Color(0xC74FFD));
                drawRecFill(375, 175, 474, 209, stellaBufferInitial, new Color(0xC74FFD));

                //Rellenar fondo
                drawRecFill(0, 0, 74, 9, stellaBufferInitial, new Color(0x003366));
                drawRecFill(225, 0, 374, 9, stellaBufferInitial, new Color(0x003366));
                drawRecFill(75, 210, 224, 219, stellaBufferInitial, new Color(0x003366));
                drawRecFill(375, 210, 474, 219, stellaBufferInitial, new Color(0x003366));

                drawRecFill(440, 110, 474, 119, stellaBufferInitial, new Color(0xB7A5A5));
                drawRecFill(380, 100, 474, 109, stellaBufferInitial, new Color(0xB2A5A5));

                drawRecFill(380, 70, 419, 99, stellaBufferInitial, new Color(0xB7A5A5));


                drawRecFill(380, 60, 419, 69, stellaBufferInitial, new Color(0x000000));
                drawRecFill(420, 70, 429, 99, stellaBufferInitial, new Color(0x000000));
                drawRecFill(420, 90, 474, 99, stellaBufferInitial, new Color(0x010000));
                drawRecFill(370, 70, 379, 99, stellaBufferInitial, new Color(0x010000));

                drawRecFill(390, 110, 439, 119, stellaBufferInitial, new Color(0x010000));
                drawRecFill(380, 100, 389, 109, stellaBufferInitial, new Color(0x010000));
                drawRecFill(440, 120, 474, 129, stellaBufferInitial, new Color(0x010000));




                System.out.println("Estala inicial creada :D!");
            } catch (Exception e) {
                System.out.println(e);
            }

            try {
                //Rojo
                drawRecFill(0, 0, 74, 34, stellaBufferFinal, new Color(0xFF2D0E));
                drawRecFill(75, 10, 224, 44, stellaBufferFinal, new Color(0xFF2D0E));
                drawRecFill(225, 0, 374, 34, stellaBufferFinal, new Color(0xFF2D0E));
                drawRecFill(375, 10, 474, 44, stellaBufferFinal, new Color(0xFF2D0E));
                //Naranja
                drawRecFill(0, 35, 74, 69, stellaBufferFinal, new Color(0xFFA804));
                drawRecFill(75, 45, 224, 79, stellaBufferFinal, new Color(0xFFA804));
                drawRecFill(225, 35, 374, 69, stellaBufferFinal, new Color(0xFFA804));
                drawRecFill(375, 45, 474, 79, stellaBufferFinal, new Color(0xFFA804));
//                //Amarillo
                drawRecFill(0, 70, 74, 104, stellaBufferFinal, new Color(0xFFFF00));
                drawRecFill(75, 80, 224, 114, stellaBufferFinal, new Color(0xFFFF00));
                drawRecFill(225, 70, 374, 104, stellaBufferFinal, new Color(0xFFFF00));
                drawRecFill(375, 80, 474, 114, stellaBufferFinal, new Color(0xFFFF00));
//                //Verde
                drawRecFill(0, 105, 74, 139, stellaBufferFinal, new Color(0x5CFF01));
                drawRecFill(75, 115, 224, 149, stellaBufferFinal, new Color(0x5CFF01));
                drawRecFill(225, 105, 374, 139, stellaBufferFinal, new Color(0x5CFF01));
                drawRecFill(375, 115, 474, 149, stellaBufferFinal, new Color(0x5CFF01));
//
//                //Azul
                drawRecFill(0, 140, 74, 174, stellaBufferFinal, new Color(0x37ADFF));
                drawRecFill(75, 150, 224, 184, stellaBufferFinal, new Color(0x37ADFF));
                drawRecFill(225, 140, 374, 174, stellaBufferFinal, new Color(0x37ADFF));
                drawRecFill(375, 150, 474, 184, stellaBufferFinal, new Color(0x37ADFF));
//                //Naranja
                drawRecFill(0, 175, 74, 209, stellaBufferFinal, new Color(0xC74FFD));
                drawRecFill(75, 185, 224, 219, stellaBufferFinal, new Color(0xC74FFD));
                drawRecFill(225, 175, 374, 209, stellaBufferFinal, new Color(0xC74FFD));
                drawRecFill(375, 185, 474, 219, stellaBufferFinal, new Color(0xC74FFD));
//
//                //Rellenar fondo

                drawRecFill(0, 210, 74, 219, stellaBufferFinal, new Color(0x003366));
                drawRecFill(75, 0, 224, 9, stellaBufferFinal, new Color(0x003366));
                drawRecFill(225, 210, 374, 219, stellaBufferFinal, new Color(0x003366));
                drawRecFill(375, 0, 474, 9, stellaBufferFinal, new Color(0x003366));


                drawRecFill(440, 110, 474, 119, stellaBufferFinal, new Color(0xB7A5A5));
                drawRecFill(380, 100, 474, 109, stellaBufferFinal, new Color(0xB2A5A5));

                drawRecFill(380, 70, 419, 99, stellaBufferFinal, new Color(0xB7A5A5));


                drawRecFill(380, 60, 419, 69, stellaBufferFinal, new Color(0x000000));
                drawRecFill(420, 70, 429, 99, stellaBufferFinal, new Color(0x000000));
                drawRecFill(420, 90, 474, 99, stellaBufferFinal, new Color(0x010000));
                drawRecFill(370, 70, 379, 99, stellaBufferFinal, new Color(0x010000));

                drawRecFill(390, 110, 439, 119, stellaBufferFinal, new Color(0x010000));
                drawRecFill(380, 100, 389, 109, stellaBufferFinal, new Color(0x010000));
                drawRecFill(440, 120, 474, 129, stellaBufferFinal, new Color(0x010000));


                System.out.println("Estala Final creada :D!");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    };

    Runnable bodyCatRunable = new Runnable() {
        @Override
        public void run() {

            try {
                drawRecFill(0, 0, 399, 219, boddyCatBuffer, new Color(0x000000));
                drawRecFill(10, 20, 389, 199, boddyCatBuffer, new Color(0xFFD3A2));
                drawRecFill(20, 10, 379, 20, boddyCatBuffer, new Color(0xFFD3A2));
                drawRecFill(20, 200, 379, 209, boddyCatBuffer, new Color(0xFFD3A2));

                drawRecFill(40, 30, 359, 199, boddyCatBuffer, new Color(0xFFA8FF));
                drawRecFill(30, 40, 40, 189, boddyCatBuffer, new Color(0xFFA8FF));
                drawRecFill(20, 50, 30, 179, boddyCatBuffer, new Color(0xFFA8FF));
                drawRecFill(369, 50, 379, 179, boddyCatBuffer, new Color(0xFFA8FF));
                drawRecFill(359, 40, 369, 189, boddyCatBuffer, new Color(0xFFA8FF));

                //cookie pinky points  40 50 359 179
                drawRecFill(45, 55, 65, 75, boddyCatBuffer, new Color(0xFE54B5));
                drawRecFill(30, 135, 50, 155, boddyCatBuffer, new Color(0xFE54B5));
                drawRecFill(85, 165, 105, 185, boddyCatBuffer, new Color(0xFE54B5));
                drawRecFill(115, 105, 135, 125, boddyCatBuffer, new Color(0xFE54B5));
                drawRecFill(155, 145, 175, 165, boddyCatBuffer, new Color(0xFE54B5));

                drawRecFill(170, 40, 190, 60, boddyCatBuffer, new Color(0xFE54B5));

                drawRecFill(205, 95, 225, 115, boddyCatBuffer, new Color(0xFE54B5));
                drawRecFill(215, 160, 235, 180, boddyCatBuffer, new Color(0xFE54B5));

                drawRecFill(295, 50, 315, 70, boddyCatBuffer, new Color(0xFE54B5));

                //Borde redondeados derechos ( izquierdos no van en este buffer)
                drawRecFill(379, 0, 399, 9, boddyCatBuffer, new Color(0x003366));
                drawRecFill(390, 10, 399, 19, boddyCatBuffer, new Color(0x003366));
                drawRecFill(380, 210, 399, 219, boddyCatBuffer, new Color(0x013366));
                drawRecFill(390, 200, 399, 209, boddyCatBuffer, new Color(0x013368));


            } catch (Exception e) {
                System.out.println(e);
            }
        }
    };

    Runnable headRunable = new Runnable() {
        @Override
        public void run() {
//            Primera cara
            try {
                drawRecFill(10, 60, 149, 99, headBufferInitial, new Color(0xA8A7A9));
                drawRecFill(20, 100, 139, 109, headBufferInitial, new Color(0xA8A7A9));
                drawRecFill(30, 110, 129, 119, headBufferInitial, new Color(0xA8A7A9));
                drawRecFill(20, 50, 139, 60, headBufferInitial, new Color(0xA8A7A9));

                drawRecFill(20, 40, 59, 50, headBufferInitial, new Color(0xA8A7A9));
                drawRecFill(20, 30, 49, 40, headBufferInitial, new Color(0xA8A7A9));
                drawRecFill(20, 20, 39, 30, headBufferInitial, new Color(0xA8A7A9));


                drawRecFill(100, 40, 139, 50, headBufferInitial, new Color(0xA8A7A9));
                drawRecFill(110, 30, 139, 40, headBufferInitial, new Color(0xA8A7A9));
                drawRecFill(120, 20, 139, 30, headBufferInitial, new Color(0xA8A7A9));


                drawRecFill(60, 100, 109, 109, headBufferInitial, new Color(0x0C0B0E));
                drawRecFill(60, 90, 69, 99, headBufferInitial, new Color(0x0A0A0C));
                drawRecFill(80, 90, 89, 99, headBufferInitial, new Color(0x0A0A0C));
                drawRecFill(100, 90, 109, 99, headBufferInitial, new Color(0x0A0A0C));


                drawRecFill(20, 80, 39, 99, headBufferInitial, new Color(0xFFA6A6));
                drawRecFill(40, 60, 59, 79, headBufferInitial, new Color(0x000000));
                drawRecFill(40, 60, 49, 69, headBufferInitial, new Color(0xFFFFFF));

                drawRecFill(119, 80, 139, 99, headBufferInitial, new Color(0xFFA6A6));
                drawRecFill(110, 60, 129, 79, headBufferInitial, new Color(0x000000));
                drawRecFill(110, 60, 119, 69, headBufferInitial, new Color(0xFFFFFF));


                drawRecFill(80, 0, 89, 39, headBufferInitial, new Color(0xFFD3A2));
                drawRecFill(60, 0, 79, 39, headBufferInitial, new Color(0xFFA8FF));
                drawRecFill(50, 0, 59, 29, headBufferInitial, new Color(0xFFA8FF));
                drawRecFill(40, 0, 49, 19, headBufferInitial, new Color(0xFFA8FF));
                drawRecFill(0, 0, 39, 9, headBufferInitial, new Color(0xFFA8FF));
                drawRecFill(0, 0, 39, 9, headBufferInitial, new Color(0xFFA8FF));
                drawRecFill(0, 0, 9, 49, headBufferInitial, new Color(0xFFA9FF));


                drawRecFill(110, 0, 119, 19, headBufferInitial, new Color(0x003366));
                drawRecFill(100, 0, 109, 29, headBufferInitial, new Color(0x003366));
                drawRecFill(110, 0, 159, 9, headBufferInitial, new Color(0x003367));
                drawRecFill(150, 0, 159, 49, headBufferInitial, new Color(0x003567));


                drawRecFill(150, 100, 159, 129, headBufferInitial, new Color(0x003567));
                drawRecFill(140, 110, 149, 129, headBufferInitial, new Color(0x003567));
                drawRecFill(130, 120, 139, 129, headBufferInitial, new Color(0x003567));

                drawRecFill(0, 110, 19, 119, headBufferInitial, new Color(0xFFD3A2));
                drawRecFill(0, 100, 9, 109, headBufferInitial, new Color(0xFFA8FF));
            } catch (Exception e) {
                System.out.println(e);
            }
//            Segunda cara
            try {
                drawRecFill(10, 60, 149, 99, headBufferSecond, new Color(0xA8A7A9));
                drawRecFill(20, 100, 139, 109, headBufferSecond, new Color(0xA8A7A9));
                drawRecFill(30, 110, 129, 119, headBufferSecond, new Color(0xA8A7A9));
                drawRecFill(20, 50, 139, 60, headBufferSecond, new Color(0xA8A7A9));

                drawRecFill(20, 40, 59, 50, headBufferSecond, new Color(0xA8A7A9));
                drawRecFill(20, 30, 49, 40, headBufferSecond, new Color(0xA8A7A9));
                drawRecFill(20, 20, 39, 30, headBufferSecond, new Color(0xA8A7A9));


                drawRecFill(100, 40, 139, 50, headBufferSecond, new Color(0xA8A7A9));
                drawRecFill(110, 30, 139, 40, headBufferSecond, new Color(0xA8A7A9));
                drawRecFill(120, 20, 139, 30, headBufferSecond, new Color(0xA8A7A9));


                drawRecFill(60, 100, 109, 109, headBufferSecond, new Color(0x0C0B0E));
                drawRecFill(60, 90, 69, 99, headBufferSecond, new Color(0x0A0A0C));
                drawRecFill(80, 90, 89, 99, headBufferSecond, new Color(0x0A0A0C));
                drawRecFill(100, 90, 109, 99, headBufferSecond, new Color(0x0A0A0C));


                drawRecFill(20, 80, 39, 99, headBufferSecond, new Color(0xFFA6A6));
                drawRecFill(40, 60, 59, 79, headBufferSecond, new Color(0x000000));
                drawRecFill(40, 60, 49, 69, headBufferSecond, new Color(0xFFFFFF));

                drawRecFill(119, 80, 139, 99, headBufferSecond, new Color(0xFFA6A6));
                drawRecFill(110, 60, 129, 79, headBufferSecond, new Color(0x000000));
                drawRecFill(110, 60, 119, 69, headBufferSecond, new Color(0xFFFFFF));


                drawRecFill(130, 0, 139, 9, headBufferSecond, new Color(0xFFD3A2));
                drawRecFill(50, 0, 109, 29, headBufferSecond, new Color(0xFFA8FF));
                drawRecFill(0, 0, 49, 9, headBufferSecond, new Color(0xFFA8FF));
                drawRecFill(40, 10, 49, 19, headBufferSecond, new Color(0xFFAAFF));

                drawRecFill(110, 0, 129, 9, headBufferSecond, new Color(0xFFA8FF));
                drawRecFill(110, 10, 119, 19, headBufferSecond, new Color(0xFFAAFF));
                drawRecFill(60, 30, 99, 39, headBufferSecond, new Color(0xFFABFF));

                drawRecFill(0, 0, 9, 49, headBufferSecond, new Color(0xFFAAFF));

                drawRecFill(150, 0, 159, 49, headBufferSecond, new Color(0x003466));


                drawRecFill(140, 110, 159, 129, headBufferSecond, new Color(0x003466));

                drawRecFill(140, 110, 159, 129, headBufferSecond, new Color(0x003466));
                drawRecFill(150, 100, 159, 109, headBufferSecond, new Color(0x003466));

                drawRecFill(130, 120, 159, 129, headBufferSecond, new Color(0x003468));


                drawRecFill(0, 110, 19, 119, headBufferSecond, new Color(0xFFD3A2));
                drawRecFill(0, 100, 9, 109, headBufferSecond, new Color(0xFFABFF));
            } catch (Exception e) {
                System.out.println(e);
            }
//            Tercera cara
            try {
                drawRecFill(10, 60, 149, 99, headBufferFinal, new Color(0xA8A7A9));
                drawRecFill(20, 100, 139, 109, headBufferFinal, new Color(0xA8A7A9));
                drawRecFill(30, 110, 129, 119, headBufferFinal, new Color(0xA8A7A9));
                drawRecFill(20, 50, 139, 60, headBufferFinal, new Color(0xA8A7A9));

                drawRecFill(20, 40, 59, 50, headBufferFinal, new Color(0xA8A7A9));
                drawRecFill(20, 30, 49, 40, headBufferFinal, new Color(0xA8A7A9));
                drawRecFill(20, 20, 39, 30, headBufferFinal, new Color(0xA8A7A9));


                drawRecFill(100, 40, 139, 50, headBufferFinal, new Color(0xA8A7A9));
                drawRecFill(110, 30, 139, 40, headBufferFinal, new Color(0xA8A7A9));
                drawRecFill(120, 20, 139, 30, headBufferFinal, new Color(0xA8A7A9));


                drawRecFill(60, 100, 109, 109, headBufferFinal, new Color(0x0C0B0E));
                drawRecFill(60, 90, 69, 99, headBufferFinal, new Color(0x0A0A0C));
                drawRecFill(80, 90, 89, 99, headBufferFinal, new Color(0x0A0A0C));
                drawRecFill(100, 90, 109, 99, headBufferFinal, new Color(0x0A0A0C));


                drawRecFill(20, 80, 39, 99, headBufferFinal, new Color(0xFFA6A6));
                drawRecFill(40, 60, 59, 79, headBufferFinal, new Color(0x000000));
                drawRecFill(40, 60, 49, 69, headBufferFinal, new Color(0xFFFFFF));

                drawRecFill(119, 80, 139, 99, headBufferFinal, new Color(0xFFA6A6));
                drawRecFill(110, 60, 129, 79, headBufferFinal, new Color(0x000000));
                drawRecFill(110, 60, 119, 69, headBufferFinal, new Color(0xFFFFFF));


                drawRecFill(130, 0, 139, 9, headBufferFinal, new Color(0xFFD3A2));
                drawRecFill(50, 0, 109, 29, headBufferFinal, new Color(0xFFA8FF));
                drawRecFill(0, 0, 49, 9, headBufferFinal, new Color(0xFFA8FF));
                drawRecFill(40, 10, 49, 19, headBufferFinal, new Color(0xFFAAFF));

                drawRecFill(110, 0, 129, 9, headBufferFinal, new Color(0xFFA8FF));
                drawRecFill(110, 10, 119, 19, headBufferFinal, new Color(0xFFAAFF));
                drawRecFill(60, 30, 99, 39, headBufferFinal, new Color(0xFFABFF));

                drawRecFill(0, 0, 9, 49, headBufferFinal, new Color(0xFFAAFF));

                drawRecFill(150, 0, 159, 49, headBufferFinal, new Color(0x003466));


                drawRecFill(140, 110, 159, 129, headBufferFinal, new Color(0x003466));

                drawRecFill(140, 110, 149, 129, headBufferFinal, new Color(0x000000));
                drawRecFill(150, 100, 159, 109, headBufferFinal, new Color(0x003466));
                drawRecFill(130, 120, 139, 129, headBufferFinal, new Color(0xFFD3A2));


                drawRecFill(0, 110, 19, 119, headBufferFinal, new Color(0xFFABFF));
                drawRecFill(0, 100, 9, 109, headBufferFinal, new Color(0xFFABFF));
                drawRecFill(0, 120, 19, 129, headBufferFinal, new Color(0xFFABFF));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    };

    Runnable feetsRunable = new Runnable() {
        @Override
        public void run() {
            try {
                drawRecFill(0, 0, 439, 39, feetBuffer_1, new Color(0xE53737));
                drawRecFill(360, 20, 439, 39, feetBuffer_1, new Color(0x030303));
                drawRecFill(380, 20, 419, 29, feetBuffer_1, new Color(0xB2A5A5));

                drawRecFill(260, 20, 339, 39, feetBuffer_1, new Color(0x030503));
                drawRecFill(280, 20, 319, 29, feetBuffer_1, new Color(0xB2A5A5));

                drawRecFill(70, 20, 139, 39, feetBuffer_1, new Color(0x000000));
                drawRecFill(80, 20, 119, 29, feetBuffer_1, new Color(0xB2A5A5));

                drawRecFill(0, 0, 60, 39, feetBuffer_1, new Color(0x030503));
                drawRecFill(0, 0, 10, 9, feetBuffer_1, new Color(0xC74FFD));
                drawRecFill(10, 10, 49, 29, feetBuffer_1, new Color(0xB2A7A5));

                drawRecFill(60, 10, 69, 39, feetBuffer_1, new Color(0x003366));
                drawRecFill(140, 10, 259, 39, feetBuffer_1, new Color(0x003366));
                drawRecFill(140, 10, 259, 39, feetBuffer_1, new Color(0x003366));
                drawRecFill(340, 10, 359, 39, feetBuffer_1, new Color(0x003366));
                drawRecFill(420, 0, 439, 19, feetBuffer_1, new Color(0x003366));

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    };



    public GUI() {
        super("Animacion2D");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setVisible(true);
        setResizable(false);
        random = new Random();
        graphics = this.getGraphics();
        backgroundBuffer = new BufferedImage(1000, 600, BufferedImage.TYPE_INT_RGB);
        stellaBufferFinal = new BufferedImage(475, 220, BufferedImage.TYPE_INT_RGB);
        stellaBufferInitial = new BufferedImage(475, 220, BufferedImage.TYPE_INT_RGB);
        boddyCatBuffer = new BufferedImage(400, 220, BufferedImage.TYPE_INT_RGB);
        headBufferInitial = new BufferedImage(160, 130, BufferedImage.TYPE_INT_RGB);
        headBufferSecond = new BufferedImage(160, 130, BufferedImage.TYPE_INT_RGB);
        headBufferFinal = new BufferedImage(160, 130, BufferedImage.TYPE_INT_RGB);
        feetBuffer_1 = new BufferedImage(440, 40, BufferedImage.TYPE_INT_RGB);
        new Thread(this::run, "Background").start();
    }

    @Override
    public void paint(Graphics g) {
        this.getGraphics().drawImage(backgroundBuffer, 0, 0, this);
        this.getGraphics().drawImage(stellaBufferFinal, 7, 200, this);
        this.getGraphics().drawImage(stellaBufferInitial, 7, 200, this);
        this.getGraphics().drawImage(boddyCatBuffer, 475, 200, this);

    }

    public synchronized void canFillFigure(int x0, int y0, Color color, BufferedImage buffer) {

        while (filling) {
            try {
                System.out.println("Se esta usando el rellenado");
                wait();

            } catch (InterruptedException error) {
                System.out.println("Error " + error);
            }
        }
        floodFill(x0 + 1, y0 + 1, color, buffer);
        filling = false;
        notifyAll();

    }


    public void putPixel(int x, int y, BufferedImage buffer, Color color) {
        buffer.setRGB(x, y, color.getRGB());
    }

    public void drawRec(int x0, int y0, int x1, int y1, BufferedImage buffer, Color color) {
        Línea_DDA(x0, y0, x1, y0, buffer, color);
        Línea_DDA(x0, y1, x1, y1, buffer, color);
        Línea_DDA(x1, y0, x1, y1, buffer, color);
        Línea_DDA(x0, y0, x0, y1, buffer, color);
    }

    public void drawRecFill(int x0, int y0, int x1, int y1, BufferedImage buffer, Color color) {

        Línea_DDA(x0, y0, x1, y0, buffer, color);
        Línea_DDA(x0, y1, x1, y1, buffer, color);
        Línea_DDA(x1, y0, x1, y1, buffer, color);
        Línea_DDA(x0, y0, x0, y1, buffer, color);
        //175 - 17
        canFillFigure(x0, y0, color, buffer);

    }

    public void Línea_DDA(int x0, int y0, int x1, int y1, BufferedImage buffer, Color color) {
        int x = x0, xinc, yinc, dx, dy, steps;
        double y = y0;

        dx = x1 - x0;
        dy = y1 - y0;

        if (abs(dx) > abs(dy)) {
            steps = abs(dx);

        } else {
            steps = abs(dy);
        }

        xinc = dx / steps;
        yinc = dy / steps;

        putPixel(round(x), (int) round(y), buffer, color);

        for (int k = 1; k <= steps; k++) {
            x = (x + xinc);
            y = y + yinc;
            putPixel(round(x), (int) round(y), buffer, color);
        }
    }


    public void floodFill(int x, int y, Color newColor, BufferedImage buffer) {

        if (newColor.getRGB() != buffer.getRGB(x, y)) {
            putPixel(x, y, buffer, newColor);
            if (buffer.getRGB(x + 1, y) != newColor.getRGB())
                floodFill(x + 1, y, newColor, buffer);
//            if (buffer.getRGB(x - 1, y) != newColor.getRGB())
//                floodFill(x - 1, y, newColor, buffer);
            if (buffer.getRGB(x, y + 1) != newColor.getRGB())
                floodFill(x, y + 1, newColor, buffer);
//            if (buffer.getRGB(x, y - 1) == newColor.getRGB())
//                floodFill(x, y - 1, newColor, buffer);
        }
    }


    @Override
    public void run() {
        boolean stella = true;
        short head = 0;

        Thread threadBackground = new Thread(backGroundRunable, "Fondo");
        threadBackground.start();
        Thread stellaInitial = new Thread(StellaRunable, "StelaInitial");
        stellaInitial.start();
        Thread bodyCat = new Thread(bodyCatRunable, "BodyCat");
        bodyCat.start();
        Thread headCatInitial = new Thread(headRunable, "HeadCatInitial");
        headCatInitial.start();
        Thread feets = new Thread(feetsRunable, "Feets");
        feets.start();



        while (true) {
            try {
                graphics.drawImage(backgroundBuffer, 0, 0, this);

                if (stella) {
                    graphics.drawImage(stellaBufferInitial, 7, 200, this);
                    stella = false;
                } else {
                    graphics.drawImage(stellaBufferFinal, 7, 200, this);
                    stella = true;
                }


                graphics.drawImage(feetBuffer_1, 450, 400, this);
                graphics.drawImage(boddyCatBuffer, 475, 200, this);
                switch (head) {
                    case 0:
                        graphics.drawImage(headBufferInitial, 775, 290, GUI.this);
                        head++;
                        break;
                    case 1:
                        graphics.drawImage(headBufferSecond, 725, 290, GUI.this);
                        head++;
                        break;
                    case 2:
                        graphics.drawImage(headBufferFinal, 725, 240, this);
                        head = 0;
                        break;
                }


                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

        }

    }
}
