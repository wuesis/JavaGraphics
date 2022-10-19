package LineaRectaBresenham;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class LineaRectaBresenham {

    public static void main(String[] args) {

        Runnable initialFram = new Runnable() {
            @Override
            public void run() {
                new GUI(args);
            }
        };

        try {
            SwingUtilities.invokeAndWait(initialFram);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
