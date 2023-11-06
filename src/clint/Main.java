package clint;

import java.util.Scanner;

/**
 * @author mo-isam
 */
public class Main {

    public static boolean Over = false;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String key = input.next();

        if (key.equals("s")) {
            Server s = new Server(5000);
        } else if (key.equals("1")) {
            Client client1 = new Client("localhost", 5000);
        } else {
            Client client1 = new Client("localhost", 5001);
        }
    }

}
