package clint;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author mo-isam
 */
public class Read_Wirte extends Thread {

    private DataInputStream in;
    private DataOutputStream out;
    static int c = 0;
    int id = 0;
    public String line = "";

    public Read_Wirte(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
        c++;
        id = c;
        this.start();
    }

    @Override
    public void run() {

        while (!Over.over) {

            try {
                line = in.readUTF();
                System.out.println("Client " + id + " says: " + line);
                out.writeUTF(line);
                out.flush();
                if (line.equals("Over")) {
                    new Over().Over();
                    System.out.println(Over.over);
                }
            } catch (IOException i) {
                System.out.println(i + "@22@@@@@@@@2");
            }
        }
    }
}
