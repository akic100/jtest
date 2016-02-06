import java.awt.*;
import java.util.Random;

/**
 * Created by akic on 5.2.2016.
 */
public class Game implements Runnable {

    String name;
    int time;

    public Game(String s) {
        name = s;
        time = new Random().nextInt(999);
    }

    @Override
    public void run() {
        try {
            System.out.printf("%s is sleeping for %d seconds.\n", name, time);
            Thread.sleep(time);
            System.out.printf("%s is done.\n", name);
        } catch (Exception e) {
            System.out.println(e);
        }
    }



}
