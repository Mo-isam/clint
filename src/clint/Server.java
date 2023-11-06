package clint;

/**
 * @author mo-isam
 */
// A Java program for a Server
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
//initialize socket and input stream

    private Socket socket, socket1;
    private ServerSocket server, server1;
    private DataInputStream in, in1;
    private DataOutputStream out, out1;
    private BufferedReader br, br1;
// constructor with port

    public Server(int port) {
// starts server and waits for a connection
        try {
            server = new ServerSocket(port);
            server1 = new ServerSocket(++port);

            System.out.println("Server started");
// client 1
            System.out.println("Waiting for a client 1 ...");
            socket = server.accept();
            System.out.println("Client 1 accepted");
// takes input from the client socket
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(System.in));

// client 2
            System.out.println("Waiting for a client 2 ...");
            socket1 = server1.accept();
            System.out.println("Client 2 accepted");
// takes input from the client socket
            in1 = new DataInputStream(socket1.getInputStream());
            out1 = new DataOutputStream(socket1.getOutputStream());
            br1 = new BufferedReader(new InputStreamReader(System.in));

            Read_Wirte rw1 = new Read_Wirte(in, out1);
            Read_Wirte rw2 = new Read_Wirte(in1, out);

            try {
                rw1.join();
                rw2.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("Closing connection");
            server.close();
            socket.close();
            in.close();
            out.close();
            server1.close();
            socket1.close();
            in1.close();
            out1.close();

        } catch (IOException i) {
            System.out.println(i + "lllllllllllll");
        }
    }
}
