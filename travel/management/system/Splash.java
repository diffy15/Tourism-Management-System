package travel.management.system;

import java.awt.*;
import javax.swing.*;

public class Splash {
    public static void main(String[] args) {
        SplashFrame f1 = new SplashFrame();
        f1.setVisible(true);

        // Center the splash frame on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - f1.getWidth()) / 2;
        int y = (screenSize.height - f1.getHeight()) / 2;
        f1.setLocation(x, y);

        int i;
        int width = 1;
        int height = 1;
        for (i = 2; i <= 600; i += 10, width += 7) {
            f1.setLocation((screenSize.width - (width + i)) / 2, (screenSize.height - i) / 2);
            f1.setSize(width + i, i);
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class SplashFrame extends JFrame implements Runnable {
    Thread t1;

    SplashFrame() {
        setLayout(new FlowLayout());
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icons/splas.jpg"));
        Image i1 = c1.getImage().getScaledInstance(1030, 750, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);

        JLabel l1 = new JLabel(i2);
        add(l1);
        setUndecorated(true);
        t1 = new Thread(this);
        t1.start();
    }

    public void run() {
        try {
            Thread.sleep(7000);
            this.setVisible(false);

            Login l = new Login();
            l.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
