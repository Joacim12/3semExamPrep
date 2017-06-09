package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author joaci
 */
public class Main {

    public static BlockingQueue<Long> s1;
    public static BlockingQueue<Long> s2;
    private static boolean running = true;

    public Main() {
        s1 = new ArrayBlockingQueue<>(11);
        Long[] initArray = {42l, 43l, 42l, 42l, 42l, 41l, 42l, 43l, 42l, 43l, 42l};
        s1.addAll(Arrays.asList(initArray));
        s2 = new ArrayBlockingQueue<>(11);
    }

    public static void main(String[] args) throws InterruptedException  {
            new Main().startProducers(8);
    }

    public void startProducers(Integer amount) throws InterruptedException  {        
        ArrayList<MyProducer> liste = new ArrayList();
        for (int i = 0; i < amount; i++) {
            MyProducer myProducer = new MyProducer();
            liste.add(myProducer);
            myProducer.start();
        }        
        new MyConsumer().start();    
        
        for (MyProducer myProducer : liste) {
            myProducer.join();
        }        
        running = false;                 
    }

    public static boolean getRunning() {
        return running;
    }
}