import javax.swing.*;
import java.awt.*;

/**
 * Created by akic on 5.2.2016.
 */
public class GameWindow extends JPanel {

    private GraphicsDevice vc;

    public GameWindow() {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        vc = env.getDefaultScreenDevice();
    }

    public void setFullScreen(DisplayMode dm, JFrame window) {
        window.setUndecorated(true);
        window.setResizable(false);

        vc.setFullScreenWindow(window);

        if(dm != null && vc.isDisplayChangeSupported()) {
            try {
                vc.setDisplayMode(dm);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public Window getFullScreenWindow() {
        return vc.getFullScreenWindow();
    }

    public void restoreWindow() {
        Window w = vc.getFullScreenWindow();
        if(w != null) {
            w.dispose();
        }
        vc.setFullScreenWindow(null);
    }

}
