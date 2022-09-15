package Reloj;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Calendar;
import java.util.Random;

public class GUI extends JFrame implements Runnable {

    private BufferedImage buff;
    private int audio, segundos;
    private Image buffer;
    Random random;
    URL audioSrc;

    AudioInputStream inputStream;

    Clip clip;

    public GUI() {
        super("Paseme en paralelas por favor :( ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(540, 560);
        setResizable(false);
        setVisible(true);
        random = new Random();
        new Thread(this::run, "Reloj").start();
    }

    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        var fondo = new ImageIcon(getClass().getResource("Imagenes/FondoReloj.png")).getImage();


        g2.drawImage(fondo, 10, 30, 520, 520, this);

        Calendar now = Calendar.getInstance();
        segundos = now.get(Calendar.SECOND);

        var gradosSegundosCalculados = 360 / 60 * now.get(Calendar.SECOND);
//        System.out.println(gradosSegundosCalculados);
        g2.rotate(Math.toRadians(gradosSegundosCalculados), getWidth() / 2, getHeight() / 2);
        var segunderoImage = new ImageIcon(getClass().getResource("Imagenes/Segundero.png")).getImage();
        g2.drawImage(segunderoImage, 250, 126, 35, 160, this);
        g2.rotate(Math.toRadians(gradosSegundosCalculados * -1), getWidth() / 2, getHeight() / 2);

        var gradosMinutosCalculados = 360 / 60 * now.get(Calendar.MINUTE);
//        System.out.println(gradosMinutosCalculados);
        g2.rotate(Math.toRadians(gradosMinutosCalculados), getWidth() / 2, getHeight() / 2);
        var minuteroImage = new ImageIcon(getClass().getResource("Imagenes/Minutero.png")).getImage();
        g2.drawImage(minuteroImage, 240, 155, 60, 130, this);
        g2.rotate(Math.toRadians(gradosMinutosCalculados * -1), getWidth() / 2, getHeight() / 2);

        var gradosHorasCalculados = 360 / 12 * now.get(Calendar.HOUR);
//        System.out.println(gradosHorasCalculados);
        g2.rotate(Math.toRadians(gradosHorasCalculados), getWidth() / 2, getHeight() / 2);
        var horasImage = new ImageIcon(getClass().getResource("Imagenes/Horas.png")).getImage();
        g2.drawImage(horasImage, 243, 180, 60, 100, this);

        g2.setColor(Color.red);
        g2.fillOval(getWidth() / 2, getHeight() / 2, 5, 5);


        System.out.println(" Hora : " + now.get(Calendar.HOUR_OF_DAY) + " Minutos: " + now.get(Calendar.MINUTE) + " Segundos: " + now.get(Calendar.SECOND));
    }


    public void CalularPosiciones(Graphics g) {

        var imagenFondo = new ImageIcon(getClass().getResource("Imagenes/FondoReloj.png")).getImage();
        g.setClip(0, 0, getWidth(), getHeight());
        g.setColor(Color.white);
        g.fillOval(getWidth() / 2, getHeight() / 2, 10, 10);

    }

    public void run() {
        while (true) {

            audio = random.nextInt(9) + 1;
            try {
                audioSrc = getClass().getResource("Audios/Reloj_" + audio + ".wav");
                inputStream = AudioSystem.getAudioInputStream(audioSrc);
                clip = AudioSystem.getClip();
                clip.open(inputStream);
                clip.start();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            repaint();

            if (segundos == 59) {
                try {
                    audio = random.nextInt(2) + 1;
                    audioSrc = getClass().getResource("Audios/fiftyNineSeconds_" + audio + ".wav");
                    inputStream = AudioSystem.getAudioInputStream(audioSrc);
                    clip = AudioSystem.getClip();
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
}
