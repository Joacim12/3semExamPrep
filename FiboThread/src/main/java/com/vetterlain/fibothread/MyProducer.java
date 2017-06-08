package com.vetterlain.fibothread;

/**
 *
 * @author joaci
 */
public class MyProducer extends Thread {

    @Override
    public void run() {
        while (!(Main.s1.isEmpty())) {            
            try {
                System.out.println("calcing");
                Main.s2.put(calculateFibonacci(Main.s1.poll()));
            } catch (InterruptedException ex) {
            }            
        }
    }

    private long calculateFibonacci(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
        }
    }
}