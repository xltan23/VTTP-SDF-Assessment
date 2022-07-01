package vttp.task02.client;

import java.io.IOException;
import java.net.Socket;

public class ClientMain {
    public static void main(String[] args) throws IOException {
        //task02.chuklee.com 80
        
        // Pre-assigned host and port (No arguments needed to process)
        String host = "task02.chuklee.com";
        int port = 80;

        System.out.printf("Connected to %s on port %d\n", host, port);

        Socket sock = new Socket(host, port);
        System.out.printf("Connected\n");
        Session sess = new Session(sock);
        sess.start();

    }
}
