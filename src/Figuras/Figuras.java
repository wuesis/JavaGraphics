package Figuras;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class Figuras {

    public static void main(String[] args) {

        Runnable initialFrom = new Runnable() {
            @Override
            public void run() {
                new GUI(args);
            }
        };

        try {
            SwingUtilities.invokeAndWait(initialFrom);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
