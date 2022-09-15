package Jframe;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;

public class GUI extends JFrame {

    public GUI() {


        super("Hola mundo!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 150);
        setVisible(true);


        setLayout(new BorderLayout());
        add(new JPanel(), BorderLayout.EAST);
        add(new JPanel(), BorderLayout.WEST);
        add(new JPanel(), BorderLayout.NORTH);
        add(new JPanel(), BorderLayout.SOUTH);
        add(new JLabel("Hola mundo"), BorderLayout.CENTER);

    }
}
