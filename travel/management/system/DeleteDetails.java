/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class DeleteDetails extends JFrame implements ActionListener{
    JButton back;
    String username;
    DeleteDetails(String username)  {
        this.username = username;
        setBounds(450,180,870,625);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        
        JLabel lblusername = new JLabel("USERNAME");
        lblusername.setBounds(30,50,150,25);
        lblusername.setForeground(Color.WHITE);
        add(lblusername);
        
        JLabel labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30,110,150,25);
        lblid.setForeground(Color.WHITE);
        add(lblid);
        
        JLabel labelid = new JLabel();
        labelid.setBounds(220,110,150,25);
        add(labelid);
        
        JLabel lblnumber = new JLabel("NUMBER");
        lblnumber.setBounds(30,170,150,25);
        lblnumber.setForeground(Color.WHITE);
        add(lblnumber);
        
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220,170,150,25);
        add(labelnumber);
        
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(30,230,150,25);
        lblname.setForeground(Color.WHITE);
        add(lblname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(220,230,150,25);
        add(labelname);
        
        
        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(30,290,150,25);
        lblgender.setForeground(Color.WHITE);
        add(lblgender);
        
        JLabel labelgender = new JLabel();
        labelgender.setBounds(220,290,150,25);
        add(labelgender);
        
        JLabel lblcountry = new JLabel("COUNTRY");
        lblcountry.setBounds(500,50,150,25);
        lblcountry.setForeground(Color.WHITE);
        add(lblcountry);
        
        JLabel labelcountry = new JLabel();
        labelcountry.setBounds(690,50,150,25);
        add(labelcountry);
        
        JLabel lbladdress = new JLabel("ADDRESS");
        lbladdress.setBounds(500,110,150,25);
        lbladdress.setForeground(Color.WHITE);
        add(lbladdress);
        
        JLabel labeladdress = new JLabel();
        labeladdress.setBounds(690,110,150,25);
        add(labeladdress);
        
        JLabel lblphone = new JLabel("PHONE");
        lblphone.setBounds(500,170,150,25);
        lblphone.setForeground(Color.WHITE);
        add(lblphone);
        
        JLabel labelphone = new JLabel();
        labelphone.setBounds(690,170,150,25);
        add(labelphone);
        
        JLabel lblemail = new JLabel("E-MAIL");
        lblemail.setBounds(500,230,150,25);
        lblemail.setForeground(Color.WHITE);
        add(lblemail);
        
        JLabel labelemail = new JLabel();
        labelemail.setBounds(690,230,150,25);
        add(labelemail);
        
        back = new JButton("DELETE");
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.setBounds(350, 350, 100, 25);
        back.addActionListener(this);
        add(back);
        
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20, 400, 600, 200);
        add(image);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(600, 400, 600, 200); // Corrected bounds for the second image
        add(image2);
        
        try {
            Conn conn = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelusername.setForeground(Color.WHITE);
                labelid.setText(rs.getString("id"));
                labelid.setForeground(Color.WHITE);
                labelnumber.setText(rs.getString("number"));
                labelnumber.setForeground(Color.WHITE);
                labelname.setText(rs.getString("name"));
                labelname.setForeground(Color.WHITE);
                labelgender.setText(rs.getString("gender"));
                labelgender.setForeground(Color.WHITE);
                labelcountry.setText(rs.getString("country"));
                labelcountry.setForeground(Color.WHITE);
                labeladdress.setText(rs.getString("address"));
                labeladdress.setForeground(Color.WHITE);
                labelphone.setText(rs.getString("phone"));
                labelphone.setForeground(Color.WHITE);
                labelemail.setText(rs.getString("email"));
                labelemail.setForeground(Color.WHITE);
                
            }
                    
        } catch (Exception e) {
            
        }
        
        
        
       setLocationRelativeTo(null); 
        
        setVisible(true);
        
    }
    public void actionPerformed (ActionEvent ae) {
        try {
            Conn c = new Conn();
            c.s.executeUpdate("delete from account where username = '"+username+"'");
            c.s.executeUpdate("delete from customer where username = '"+username+"'");
            c.s.executeUpdate("delete from bookpackage where username = '"+username+"'");
            c.s.executeUpdate("delete from bookhotel where username = '"+username+"'");
            
            JOptionPane.showMessageDialog(null, "DATA DELETED SUCCESSFULLY");
            
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
            
    
    public static void main(String[] args) {
        new DeleteDetails("abu");
    }
    
    
}


