package server;

import entity.Turnstile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joacim
 */
public class ClientConnection extends Thread {

    private Socket socket = null;

    ClientConnection(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            handleConnection();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void handleConnection() throws IOException {
        InputStream input = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String firstContact = reader.readLine();
        if (firstContact.equals("TURNSTILE")) {
            String name = reader.readLine();
            String count = reader.readLine();
            Turnstile t = new Turnstile(name,Integer.parseInt(count));
            System.out.println(t);
            TurnstileServer.incrementCount(t);
        } else if(firstContact.equals("TOTAL")){
            writeAmount(TurnstileServer.getTotalCount()+"");
        }
    }
    
    private void writeAmount(String string) throws IOException {
        OutputStream output = socket.getOutputStream();
        PrintWriter out = new PrintWriter(output, true);
        out.println(string);
    }
}
