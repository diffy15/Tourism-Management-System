package travel.management.system;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, password;
    JTextField tfUsername;
    JPasswordField tfPassword;
    JCheckBox showPassword;

    Login() {
        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(30, 30, 30)); // Dark background color
        p1.setBounds(0, 0, 400, 400);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 120, 200, 200);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(60, 20, 100, 25);
        lblUsername.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        lblUsername.setForeground(Color.BLACK);
        p2.add(lblUsername);

        tfUsername = new JTextField();
        tfUsername.setBounds(60, 60, 300, 30);
        tfUsername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(60, 110, 100, 25);
        lblPassword.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        lblPassword.setForeground(Color.BLACK);
        p2.add(lblPassword);

        tfPassword = new JPasswordField();
        tfPassword.setBounds(60, 150, 300, 30);
        tfPassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfPassword);

        showPassword = new JCheckBox("Show Password");
        showPassword.setBounds(60, 180, 150, 20);
        showPassword.setForeground(Color.BLACK);
        p2.add(showPassword);

        login = new JButton("Login");
        login.setBounds(60, 220, 130, 30);
        login.setBackground(new Color(133, 193, 233));
        login.setForeground(Color.BLACK);
        login.setBorder(new LineBorder(new Color(133, 193, 233)));
        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("Signup");
        signup.setBounds(130, 260, 130, 30);
        signup.setBackground(new Color(133, 193, 233));
        signup.setForeground(Color.BLACK);
        signup.setBorder(new LineBorder(new Color(133, 193, 233)));
        signup.addActionListener(this);
        p2.add(signup);

        password = new JButton("Forget Password");
        password.setBounds(230, 220, 150, 30);
        password.setBackground(new Color(133, 193, 233));
        password.setForeground(Color.BLACK);
        password.setBorder(new LineBorder(new Color(133, 193, 233)));
        password.addActionListener(this);
        p2.add(password);

        JLabel text = new JLabel("Trouble in Login...");
        text.setBounds(300, 260, 150, 20);
        text.setForeground(Color.BLUE);
        p2.add(text);

        // Event listener for the "Show Password" checkbox
        showPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (showPassword.isSelected()) {
                    tfPassword.setEchoChar((char) 0);
                } else {
                    tfPassword.setEchoChar('\u2022'); // Use the default bullet character for password masking
                }
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            try {
                String username = tfUsername.getText();
                String password = new String(tfPassword.getPassword());

                String query = "select * from account where username = '" + username + "' AND password = '" + password + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Loading(username);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup();
        } else {
            setVisible(false);
            new ForgetPassword();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
