package clint;

/**
 * @author mo-isam
 */
public class Over {

    static boolean over;

    public static synchronized void Over() {
        over = true;
    }

}
