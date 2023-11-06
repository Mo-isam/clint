package clint;

/**
 * @author mo-isam
 */
import java.net.*;
import java.io.*;

public class Client1 {
// initialize socket and input output streams

    private Socket socket ;
    private BufferedReader br;
    private DataOutputStream out ;
    private DataInputStream in ;

// constructor to put ip address and port
    public Client1 (String address, int port) {
// establish a connection
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");
// takes input from terminal
          
// sends output to the socket
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new DataOutputStream(socket.getOutputStream());
            in= new DataInputStream(socket.getInputStream());
        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException i) {
            System.out.println(i);
        }

// string to read message from input
        String line = " ";
        String line1 = " ";
// keep reading until "Over" is input
        while (!line.equals("Over")) {
            try {
                line = br.readLine();
                out.writeUTF(line);
                out.flush();
                line1 = in.readUTF();
                System.out.println("Server says: "+line1);
                

            } catch (IOException i) {
                System.out.println(i);
            }
        }
// close the connection

        try {
                     
            out.close();
            socket.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        Client client = new Client("localhost", 5000);
    }
}
