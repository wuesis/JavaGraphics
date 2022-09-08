package Monito;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    public GUI() {
        super("Uso de graficos");
        setSize(200,280);
        setResizable(false);
        setVisible(true);
    }

    public void paint(Graphics g){
        g.drawString("Demo grafico",60,50);

        g.drawArc(80,60,50,50,0,360);
        g.drawArc(90,70,30,30,180,180);
        g.fillOval(95,75,5,5);
        g.fillOval(110,75,15,5);

        g.drawLine(105,110,75,200);

        g.drawLine(102,120,45,160);
        g.drawLine(102,120,105,160);

        g.drawLine(75,200,45,240);
        g.drawLine(75,200,105,240);

    }
}
