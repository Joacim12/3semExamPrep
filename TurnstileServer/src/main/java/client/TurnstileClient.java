package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 * @author joaci
 */
public class TurnstileClient {

    private final String host;
    private final int port;
    private Socket clientSocket;

    public TurnstileClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        TurnstileClient client = new TurnstileClient("localhost", 12000);
        client.open();
        client.sendMessage("TURNSTILE");
        client.sendMessage("T-1");
        client.sendMessage(1+"");
//        client.sendMessage("TOTAL"); /* Returns total spectators */ 
        client.readMessage();
    }

    public void open() throws IOException {
        clientSocket = new Socket();
        clientSocket.connect(new InetSocketAddress(host, port));
    }

    public void sendMessage(String message) throws IOException, InterruptedException {          
        OutputStream output = clientSocket.getOutputStream();
        PrintWriter writer = new PrintWriter(output,true);
        writer.println(message);       
    }

    public String readMessage() throws IOException {
        InputStream input = clientSocket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        return line;
    }
}
