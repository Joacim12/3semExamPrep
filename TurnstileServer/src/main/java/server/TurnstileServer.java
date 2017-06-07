package server;

import entity.Turnstile;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author joaci
 */
public class TurnstileServer {

    private static boolean listening;
    private final int port;
    
    private static Map<String,Integer> turnstiles = new HashMap();
    
    public TurnstileServer(int port){
        this.port = port;
    }
    
    public static void main(String[] args) {
        new TurnstileServer(12000).startServer();
    }

    public void startServer(){
        listening = true;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (listening) {
                ClientConnection client = new ClientConnection(serverSocket.accept());
                client.start();
            }
        } catch (IOException ex) {
            System.out.println("IO EXCEPTION!!");
        }
    }
    
    public synchronized static void incrementCount(Turnstile turnstile){
        turnstiles.put(turnstile.getName(), turnstile.getCount());
        System.out.println(turnstiles);
        System.out.println("Total Count: " + getTotalCount());
    }
    
    public static int getTotalCount(){
        int total = 0;
        total = turnstiles.values().stream().map((value) -> value).reduce(total, Integer::sum);
        return total;
    }
    
}
