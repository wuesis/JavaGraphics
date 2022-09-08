package Jframe;

import java.lang.reflect.InvocationTargetException;
import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class JFrame {

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
