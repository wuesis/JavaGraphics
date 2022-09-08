package Monito;


import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class Monito {

    public static void main(String[] args) {

        Runnable initFrame = new Runnable() {
            @Override
            public void run() {
                new GUI();
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
