package DiagramaPastel;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;



public class GUI extends JFrame {

    private int Proportion;
    private int Suma;

    ArrayList<Integer> Valores = new ArrayList<Integer>();

    public GUI(String [] args){

        super("Diagrama de pastel.");
        for (String item:args) {
            Valores.add(Integer.parseInt(item));
        }

        this.Suma = Valores.stream().mapToInt(e->e).sum();
        this.Proportion = 360/Suma;

        setSize(500,350);
        setVisible(true);
    }

    public void paint(Graphics graphics){

        int sumaDeAngulos=0;
        boolean Flag = true;
        for (int valor: Valores) {

            int anguloActual = (valor*360)/Suma;
            Flag = Flag== true? false: true;
            if (Flag)
                graphics.setColor(Color.GREEN);
            else
                graphics.setColor(Color.RED);

            graphics.fillArc(250,150,100,100,sumaDeAngulos,anguloActual);



            sumaDeAngulos += anguloActual;
        }
    }

}
