package clint;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author mo-isam
 */
public class write extends Thread {

    private DataOutputStream out;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public String line = "";

    public write(DataOutputStream out) {
        this.out = out;
        this.start();

    }

    @Override
    public void run() {
        System.out.println("hello");

        while (!Over.over) {
           
            try {
                line = br.readLine();
                out.writeUTF(line);
                out.flush();

            } catch (IOException i) {
                System.out.println(i);System.out.println(Over.over);
            }
        }
        try {
            out.close();
            br.close();
            
        } catch (IOException ex) {
            Logger.getLogger(write.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}
