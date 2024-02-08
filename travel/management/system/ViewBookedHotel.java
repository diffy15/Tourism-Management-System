package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewBookedHotel extends JFrame implements ActionListener {
    JButton back;

    ViewBookedHotel(String username) {
        setBounds(400, 200, 1000, 600);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

        JLabel text = new JLabel("VIEW BOOKED HOTEL DETAILS");
        text.setFont(new Font("Times New Roman", Font.BOLD, 20));
        text.setForeground(Color.WHITE);
        text.setBounds(60, 0, 400, 30);
        add(text);

        JLabel lblusername = new JLabel("USERNAME");
        lblusername.setBounds(30, 50, 150, 25);
        lblusername.setForeground(Color.WHITE);
        add(lblusername);

        JLabel labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        JLabel lblpackage = new JLabel("HOTEL NAME");
        lblpackage.setBounds(30, 90, 150, 25);
        lblpackage.setForeground(Color.WHITE);
        add(lblpackage);

        JLabel labelpackage = new JLabel();
        labelpackage.setBounds(220, 90, 150, 25);
        add(labelpackage);

        JLabel lblpersons = new JLabel("TOTAL PERSONS");
        lblpersons.setBounds(30, 130, 150, 25);
        lblpersons.setForeground(Color.WHITE);
        add(lblpersons);

        JLabel labelpersons = new JLabel();
        labelpersons.setBounds(220, 130, 150, 25);
        add(labelpersons);
        
        JLabel lbldays = new JLabel("TOTAL DAYS");
        lbldays.setBounds(30, 170, 150, 25);
        lbldays.setForeground(Color.WHITE);
        add(lbldays);

        JLabel labeldays = new JLabel();
        labeldays.setBounds(220, 170, 150, 25);
        add(labeldays);
        
        JLabel lblac = new JLabel("AC/Non-AC");
        lblac.setBounds(30, 210, 150, 25);
        lblac.setForeground(Color.WHITE);
        add(lblac);

        JLabel labelac = new JLabel();
        labelac.setBounds(220, 210, 150, 25);
        add(labelac);
        
        JLabel lblfood = new JLabel("FOOD INCLUDED?");
        lblfood.setBounds(30, 250, 150, 25);
        lblfood.setForeground(Color.WHITE);
        add(lblfood);

        JLabel labelfood = new JLabel();
        labelfood.setBounds(220, 250, 150, 25);
        add(labelfood);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30, 290, 150, 25);
        lblid.setForeground(Color.WHITE);
        add(lblid);

        JLabel labelid = new JLabel();
        labelid.setBounds(220, 290, 150, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("NUMBER");
        lblnumber.setBounds(30, 330, 150, 25);
        lblnumber.setForeground(Color.WHITE);
        add(lblnumber);

        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220, 330, 150, 25);
        add(labelnumber);

        JLabel lblphone = new JLabel("PHONE");
        lblphone.setBounds(30, 370, 150, 25);
        lblphone.setForeground(Color.WHITE);
        add(lblphone);

        JLabel labelphone = new JLabel();
        labelphone.setBounds(220, 370, 150, 25);
        add(labelphone);

        JLabel lblprice = new JLabel("TOTAL COST");
        lblprice.setBounds(30, 410, 150, 25);
        lblprice.setForeground(Color.WHITE);
        add(lblprice);

        JLabel labelprice = new JLabel();
        labelprice.setBounds(220, 410, 150, 25);
        add(labelprice);

        back = new JButton("BACK");
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.setBounds(130, 460, 100, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/BookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 20, 500, 400);
        add(image);

        try {
             Conn conn = new Conn();
             String query = "select * from bookhotel where username = '" + username + "'";
             ResultSet rs = conn.s.executeQuery(query);
             while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelusername.setForeground(Color.WHITE);
                labelid.setText(rs.getString("id"));
                labelid.setForeground(Color.WHITE);
                labelnumber.setText(rs.getString("number"));
                labelnumber.setForeground(Color.WHITE);
                labelpackage.setText(rs.getString("name"));
                labelpackage.setForeground(Color.WHITE);
                labelprice.setText(rs.getString("price"));
                labelprice.setForeground(Color.WHITE);
                labelphone.setText(rs.getString("phone"));
                labelphone.setForeground(Color.WHITE);
                labelpersons.setText(rs.getString("persons"));
                labelpersons.setForeground(Color.WHITE);
                labelfood.setText(rs.getString("food"));
                labelfood.setForeground(Color.WHITE);
                labeldays.setText(rs.getString("days")); // Check the column name in your database
                labeldays.setForeground(Color.WHITE);
                labelac.setText(rs.getString("ac")); // Check the column name in your database
                labelac.setForeground(Color.WHITE);
                

            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        setLocationRelativeTo(null);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new ViewBookedHotel("abu");
    }
}
