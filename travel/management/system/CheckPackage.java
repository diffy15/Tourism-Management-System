package travel.management.system;

import java.awt.*;
import javax.swing.*;

public class CheckPackage extends JFrame {
    public static void main(String[] args) {
        new CheckPackage().setVisible(true);
    }

    CheckPackage() {
        setBounds(550, 220, 900, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        String[] package1 = new String[]{"pack1.jpg", "GOLD PACKAGE", "6 days and 7 Nights",
                "Airport Assistance at Airport", "Half Day City Tour", "Welcome drinks on Arrival",
                "Daily Buffet", "Full Day 3 Island Cruise", "English Speaking Guide",
                "BOOK NOW", "Summer Special", "Rs 12,000 only"};

        String[] package2 = new String[]{"pack2.jpg", "SILVER PACKAGE", "4 days and 3 Nights",
                "Toll-Free and Entrance-Free Tickets", "Meet and Greet at Airport", "Welcome drinks on Arrival",
                "Night Safari", "Full Day 3 Island Cruise", "Cruise with Dinner", "BOOK NOW",
                "Winter Special", "Rs 25,000 only"};

        String[] package3 = new String[]{"pack3.jpg", "BRONZE PACKAGE", "6 days and 5 Nights",
                "Return Airfare", "Free Clubbing, Horse Riding & other Games", "Welcome drinks on Arrival",
                "Daily Buffet", "Stay in 5 Star Hotel", "BBQ Dinner", "BOOK NOW",
                "Winter Special", "Rs 32,000 only"};

        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel p1 = createPackage(package1);
        tabbedPane.addTab("Package 1", null, p1);

        JPanel p2 = createPackage(package2);
        tabbedPane.addTab("Package 2", null, p2);

        JPanel p3 = createPackage(package3);
        tabbedPane.addTab("Package 3", null, p3);

        add(tabbedPane, BorderLayout.CENTER);
    }

    public JPanel createPackage(String[] pack) {
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.BLACK);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/" + pack[0]));
        Image i3 = i1.getImage().getScaledInstance(550, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(400, 0, 450, 420);
        p1.add(l1);

        JLabel lblName = new JLabel(pack[1]);
        lblName.setFont(new Font("Yu Mincho", Font.BOLD, 30));
        lblName.setForeground(Color.WHITE);
        lblName.setBounds(50, 5, 350, 53);
        p1.add(lblName);

        for (int i = 2; i < pack.length; i++) {
            JLabel label = new JLabel(pack[i]);
            label.setForeground(Color.WHITE);
            label.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
            label.setBounds(35, 70 + (i - 2) * 40, 600, 30);
            p1.add(label);
        }

        return p1;
    }
}
