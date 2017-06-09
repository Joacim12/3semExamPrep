package main;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joaci
 */
public class MyConsumer extends Thread {

    private long result;
    private long sum;

    @Override
    public void run() {
        // Run until all producers are done
        while (Main.getRunning()) {
            try {
                result = Main.s2.take();
                System.out.println(result);
                sum += result;
            } catch (InterruptedException ex) {
                Logger.getLogger(MyConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            System.out.println("Resultat af fib calc: " + sum);
    }
}
