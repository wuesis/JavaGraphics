package Animacion3D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;

import static java.lang.Thread.sleep;

public class GUI extends JFrame implements Runnable, KeyListener {

    private FileReader facesReader, verticesReader;
    private BufferedReader verticesbuffer, facesBuffer;
    private ImageIcon backgroundImage;
    private Graphic graphic;
    public float angle, speed;
    public double division;
    private int[] curveX, curveY, curveZ;

    private String[] auxiliarArray, coordenadasAndroid, conexionesAndroid;

    private int coordenadasXAndroid[], coordenadasYAndroid[], coordenadasZAndroid[];
    private int vertices, faces, xC = 300, yC = 300, zC = 30;

    public GUI() {
        setSize(new Dimension(800, 600));
        setPreferredSize(new Dimension(1500, 1500));
        setVisible(true);
        setFocusable(true);
        addKeyListener(this);
        division = 100;
        speed = (float) 0.09;
        faces = 0;
        vertices = 0;

        backgroundImage = new ImageIcon("src/Animacion3D/Imagenes/wallpapper.png");
        auxiliarArray = new String[4];
        coordenadasAndroid = new String[49934];
        conexionesAndroid = new String[49408];
        coordenadasXAndroid = new int[49934];
        coordenadasYAndroid = new int[49934];
        coordenadasZAndroid = new int[49934];

        addKeyListener(this);
        graphic = new Graphic(700, 600);
        angle = 90;

        curveX = new int[2];
        curveY = new int[2];
        curveZ = new int[2];

        getModelData();
        setModelData();

        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(backgroundImage.getImage(), 0, 0, null);
        graphic.setGraphics(g);
        crearAndroid();
        graphic.drawBuffer();
    }

    public void getModelData() {

        try {
            vertices = 0;
            verticesReader = new FileReader("src/Animacion3D/Modelos/android.obj");
            verticesbuffer = new BufferedReader(verticesReader);
            String Cursor;
            while ((Cursor = verticesbuffer.readLine()) != null) {
                if (Cursor.startsWith("v")) {
                    coordenadasAndroid[vertices] = Cursor;
                    vertices++;
                }
            }
            System.out.println(vertices);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            faces = 0;
            facesReader = new FileReader("src/Animacion3D/Modelos/android.obj");
            facesBuffer = new BufferedReader(facesReader);
            String Cursor;
            while ((Cursor = facesBuffer.readLine()) != null) {
                if (Cursor.startsWith("f")) {
                    conexionesAndroid[faces] = Cursor;
                    faces++;
                }
            }
            System.out.println(faces);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setModelData() {
        for (int i = 0; i < vertices; i++) {
            auxiliarArray = coordenadasAndroid[i].split("\\s+");
            double conversion;
            //Los datos estan acomodados siempre por v y las tres coordenadas, los cuatro datos separados por un espacio y acomodados como v, eje x, eje y, eje z
            conversion = Double.parseDouble(auxiliarArray[1]) * division;
            coordenadasXAndroid[i] = (int) conversion;
            //Al separarlos por espacios, el primer dato siempre sera v pero no nos interesa por lo que
            conversion = Double.parseDouble(auxiliarArray[2]) * division;
            coordenadasYAndroid[i] = (int) conversion;
            //Solo necesitamos los datos almacenados en auxiliar en las posiciones 1, 2 y 3
            conversion = Double.parseDouble(auxiliarArray[3]) * division;
            //Cada uno representa una coordenada en un eje por lo que los guardamos en el eje donde corresponden
            coordenadasZAndroid[i] = (int) conversion;
            System.out.println("coordenas " + coordenadasXAndroid[i] + "  " + coordenadasYAndroid[i] + "  " + coordenadasZAndroid[i]);
        }

        for (int i = 0; i < faces; i++) {
            //Al menos en mi archivo las conexiones estan divididas en 3 y cada conexion tiene 3 numeros separados por una diagonal "/"
            //Separamos las conexiones por espacios, el primer dato en el arreglo es f por lo que no nos interesa
            String auxiliar[] = conexionesAndroid[i].split("\\s+");
            //El arreglo original queda sobreescrito en su posicion actual con solo los datos de las conexiones que se deben hacer
            conexionesAndroid[i] = "" + auxiliar[1] + "," + auxiliar[2] + "," + auxiliar[3] + "," + auxiliar[4];
            System.out.println(conexionesAndroid[i] + "    " + i);
        }

    }

    public void crearAndroid() {
        String conexion[] = new String[4];
        int enlace[] = new int[4];

        for (int i = 0; i < faces; i++) {
            conexion = conexionesAndroid[i].split(",");
            enlace[0] = Integer.parseInt(conexion[0]) - 1;
            enlace[1] = Integer.parseInt(conexion[1]) - 1;
            enlace[2] = Integer.parseInt(conexion[2]) - 1;
            enlace[3] = Integer.parseInt(conexion[3]) - 1;
            for (int j = 0; j < enlace.length - 1; j++) {
                curveX[0] = coordenadasXAndroid[enlace[j]];
                curveY[0] = coordenadasYAndroid[enlace[j]];
                curveZ[0] = coordenadasZAndroid[enlace[j]];
                curveX[1] = coordenadasXAndroid[enlace[j + 1]];
                curveY[1] = coordenadasYAndroid[enlace[j + 1]];
                curveZ[1] = coordenadasZAndroid[enlace[j + 1]];

                this.curvitaPrrna(graphic);
            }
        }
    }

    public void curvitaPrrna(Graphic obj) {
        obj.drawCurve(xC, yC, zC, this.curveX, this.curveY, this.curveZ, Color.GREEN, this.angle);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        switch (code) {
            case KeyEvent.VK_S:
                speed -= 0.01;
                break;
            case KeyEvent.VK_W:
                speed += 0.01;
                break;
            case KeyEvent.VK_A:
                division = division - 5;
                setModelData();
                break;
            case KeyEvent.VK_D:
                division = division + 5;
                setModelData();
                break;
            case KeyEvent.VK_P:
                speed = 0;
                break;
            case KeyEvent.VK_LEFT:
                xC = xC - 5;
                break;
            case KeyEvent.VK_RIGHT:
                xC = xC + 5;
                break;
            case KeyEvent.VK_UP:
                yC = yC - 5;
                break;
            case KeyEvent.VK_DOWN:
                yC = yC + 5;
                break;
            default:
                System.out.println("Codigo   " + code);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void run() {
        boolean xAxisTrasladate = false, yAxisTrasladate = false;
        while (true) {
            angle += speed;
            xAxisTrasladate = xC == 200 ? true : xC == 500 ? false : xAxisTrasladate;
            xC = speed == 0 ? xC : xAxisTrasladate ? xC + 10 : xC - 10;

            try {
                sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            repaint();
        }
    }
}
