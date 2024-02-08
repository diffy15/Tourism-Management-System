package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener {
    Choice cpackage;
    JTextField tfpersons;
    String username;
    JLabel labelusername, labelid, labelnumber, labelphone, labelprice;
    JButton checkprice, bookpackage, back;

    BookPackage(String username) {
        this.username = username;
        setBounds(350, 200, 1100, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);

        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Times New Roman", Font.BOLD, 20));
        text.setForeground(Color.WHITE);
        add(text);

        JLabel lblusername = new JLabel("USERNAME");
        lblusername.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblusername.setBounds(40, 70, 100, 20);
        lblusername.setForeground(Color.WHITE);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(250, 70, 200, 20);
        labelusername.setFont(new Font("Times New Roman", Font.BOLD, 16));
        labelusername.setForeground(Color.WHITE);
        add(labelusername);

        JLabel lblselectpackage = new JLabel("SELECT PACKAGE");
        lblselectpackage.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblselectpackage.setBounds(40, 110, 150, 20);
        lblselectpackage.setForeground(Color.WHITE);
        add(lblselectpackage);

        cpackage = new Choice();
        cpackage.add("GOLD PACKAGE");
        cpackage.add("SILVER PACKAGE");
        cpackage.add("BRONZE PACKAGE");
        cpackage.setBounds(250, 110, 200, 20);
        add(cpackage);

        JLabel lblpersons = new JLabel("TOTAL PERSONS");
        lblpersons.setBounds(40, 150, 200, 25);
        lblpersons.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblpersons.setForeground(Color.WHITE);
        add(lblpersons);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 150, 200, 20);
        add(tfpersons);

        JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblid.setBounds(40, 190, 150, 20);
        lblid.setForeground(Color.WHITE);
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250, 190, 200, 25);
        labelid.setForeground(Color.WHITE);
        add(labelid);

        JLabel lblnumber = new JLabel("NUMBER");
        lblnumber.setBounds(40, 230, 150, 25);
        lblnumber.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblnumber.setForeground(Color.WHITE);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(250, 230, 200, 25);
        labelnumber.setForeground(Color.WHITE);
        add(labelnumber);

        JLabel lblphone = new JLabel("PHONE");
        lblphone.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblphone.setBounds(40, 270, 150, 20);
        lblphone.setForeground(Color.WHITE);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(250, 270, 200, 25);
        labelphone.setForeground(Color.WHITE);
        add(labelphone);

        JLabel lbltotal = new JLabel("TOTAL PRICE");
        lbltotal.setBounds(40, 310, 150, 25);
        lbltotal.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbltotal.setForeground(Color.WHITE);
        add(lbltotal);

        labelprice = new JLabel();
        labelprice.setBounds(250, 310, 200, 25);
        add(labelprice);

        try {
            Conn conn = new Conn();
            String query = "select * from customer where username = '" + username + "'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        checkprice = new JButton("CHECK PRICE");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60, 380, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("BOOK PACKAGE");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200, 380, 120, 25);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340, 380, 120, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(550, 50, 500, 300);
        add(l12);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkprice) {
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if (pack.equals("GOLD PACKAGE")) {
                cost += 12000;
            } else if (pack.equals("SILVER PACKAGE")) {
                cost += 25000;
            } else {
                cost += 32000;
            }

            int persons = Integer.parseInt(tfpersons.getText());
            cost *= persons;
            labelprice.setText("Rs " + cost);
            labelprice.setForeground(Color.WHITE);
        } else if (ae.getSource() == bookpackage) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookpackage values('" + labelusername.getText() + "', '" + cpackage.getSelectedItem() + "', '" + tfpersons.getText() + "', '" + labelid.getText() + "', '" + labelnumber.getText() + "','" + labelphone.getText() + "','" + labelprice.getText() + "')");
                JOptionPane.showMessageDialog(null, "PACKAGE BOOKED SUCCESSFULLY");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookPackage("abu");
    }
}
