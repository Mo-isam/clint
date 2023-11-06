package clint;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author mo-isam
 */
public class read extends Thread {

    private DataInputStream in;
    public String line="";

    public read(DataInputStream in) {
        this.in = in;
        this.start();
    }
    @Override
    public void run() {
        System.out.println("hi");
       while (!Over.over) {
            try {
                line = in.readUTF();
                System.out.println("clinet says: " + line);

            } catch (IOException i) {
                System.out.println(i);System.out.println(Over.over);
            }
        }
        try {
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(read.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
