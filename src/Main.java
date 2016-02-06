
import javax.swing.*;
import java.awt.*;

/**
 * Created by akic on 5.2.2016.
 */
public class Main extends JFrame {
    public static int count = 0;
    public static void main(String args[]) {

        DisplayMode dm = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
        Main m = new Main();
        System.out.println(count++);
        m.run(dm);

    }

    private GameWindow gw;
    private Image bg;
    private boolean loaded;
    Char playa = new Char("Playa", 0, 50, 50, 50, 50);

    private void run(DisplayMode dm) {
        setBackground(Color.BLACK);
        setForeground(Color.LIGHT_GRAY);
        setFont(new Font("Arial", Font.PLAIN, 24));
        loaded = false;

        gw = new GameWindow();
        try {
            gw.setFullScreen(dm, this);
            loadpics();
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                System.out.println(e);
            }
        } finally {
            gw.restoreWindow();
        }
    }

    // Load pictures
    public void loadpics() {
        bg = new ImageIcon("/home/akic/IdeaProjects/Game/src/images/bg.png").getImage();
        loaded = true;
        repaint();
    }

    public void paint(Graphics g) {
        if(g instanceof Graphics2D) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }
        if(loaded) {
            g.setColor(Color.GREEN);
            g.drawImage(bg, 0, 0, null);
            g.fillRect(playa.x, playa.y, playa.w, playa.h);
            g.setColor(Color.RED);
            g.fillRect(playa.getCX(), playa.getCY(), playa.w, playa.h);
        }
    }


}
