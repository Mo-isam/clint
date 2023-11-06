package clint;

/**
 * @author mo-isam
 */
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client extends Thread {
// initialize socket and input output streams

    private Socket socket;
    private BufferedReader br;
    private DataOutputStream out;
    private DataInputStream in;

// constructor to put ip address and port
    public Client(String address, int port) {

        try {
            socket = new Socket(address, port);
            System.out.println("Connected");
// takes input from terminal

// sends output to the socket
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException i) {
            System.out.println(i);
        }
//        here
        write w = new write(this.out);
        read r = new read(this.in);
        try {
            w.join();
            r.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("##");
        try {
//            in.close();
//            out.close();
            socket.close();
        } catch (IOException i) {
            System.out.println(i);
        }

    }

}
