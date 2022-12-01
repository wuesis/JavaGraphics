package Proyeccion;

public class main implements Runnable {

    private GUI window;

    public static void main(String[] args) {
        new main().start();
    }

    void start() {
        window = new GUI();
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        boolean exit = false;
        while (!exit) {
            try  {
                if(window.GetChange() == true) {
                    window.repaint();
                    window.SetChange(false);
                }
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
                exit = true;
            }
        }
    }
}
