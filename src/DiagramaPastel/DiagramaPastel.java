package DiagramaPastel;



import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class DiagramaPastel {

    public static void main(String[] args) {

        String Valores [] = {"10","30","20","20"};


        Runnable initFrame = new Runnable() {
            @Override
            public void run() {
                new GUI(Valores);
            }
        };

        try {
            SwingUtilities.invokeAndWait(initFrame);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
