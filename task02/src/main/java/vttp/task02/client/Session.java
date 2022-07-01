package vttp.task02.client;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;


public class Session {
    
    private Socket sock;
    private InputStream is;
    private OutputStream os;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    private List<Float> numbers = new LinkedList<>();
    private Float average;

    public Session(Socket sock) {
        this.sock = sock;
    }

    public void start() throws IOException {
        // Initialising stream with output stream first before input stream
        initializeStreams(sock);

        // Set start time for message exchange
        long start = System.currentTimeMillis();
        long end = start + 15*1000; // Set 15 seconds timeout
        
        //while (System.currentTimeMillis() < end) {
            
        
            // Receive request from server
            String request = read();
            System.out.printf("%s\n", request);
            // Data cleaning
            request = request.replaceAll(",", " ");
            // terms[0]=request id; terms[i>0]=list of string integers
            String[] terms = request.split(" ");
            for (int i = 1; i < terms.length; i++) {
                numbers.add(Float.parseFloat(terms[i]));
            }
            // Calculate average using method
            average = calculateAve(numbers);

            /* 
            Console cons = System.console();
            String input = cons.readLine("What is the average of the numbers?\n >>");
            Float f = Float.parseFloat(input);
            */

            // Write answer back to server using ObjectOutputStream
            write(terms[0]+"\n"); // Request id
            write("Tan Xian Liang\n"); // Name as per NRIC
            write("tanxianliang23@gmail.com\n"); // Valid Email
            writeF(average);
            oos.flush();
        
            // Read response from server
            Boolean response = ois.readBoolean();
            // Read error message from server
            String errMsg = read();
            if (response = true) {
                System.out.printf("SUCCESS\n");
            } else {
                System.out.printf("FAILED\n");
                System.out.printf("%s\n", errMsg);
            }
            /* 
            try {
                close();
            } catch (IOException ex) {}
                */
            //}
        close();
    }


    private void initializeStreams(Socket sock) throws IOException {
        os = sock.getOutputStream();
        oos = new ObjectOutputStream(os);
        is = sock.getInputStream();
        ois = new ObjectInputStream(is);
    }

    private void close() throws IOException {
        is.close();
        os.close();
    }

    private String read() throws IOException {
        return ois.readUTF();
    }

    private void write(String reply) throws IOException {
        oos.writeUTF(reply);
        //oos.flush();
    }

    private void writeF(Float number) throws IOException {
        oos.writeFloat(number);
        //oos.flush();
    }

    private Float calculateAve(List<Float> floats) {
        Float sum = 0f;
        for (Float f : floats) {
            sum =+ f;
        } 
        return sum/floats.size();
    }
}
