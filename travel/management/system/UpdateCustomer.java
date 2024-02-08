package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCustomer extends JFrame implements ActionListener {

    JLabel labelusername, labelname;
    JComboBox<String> comboid; // Added String parameter to JComboBox
    JTextField tfnumber,tfaddress,tfcountry,tfphone,tfemail,tfid,tfgender; // Fixed typo: JTextFeild to JTextField
    JRadioButton rmale, rfemale;
    JButton add, back;

    UpdateCustomer(String username) {
        setBounds(500, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
        setLocationRelativeTo(null);
        
        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50,0,300,25);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add(text);

        JLabel lblusername = new JLabel("USERNAME");
        lblusername.setBounds(30, 50, 150, 25);
        lblusername.setForeground(Color.WHITE);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        labelusername.setForeground(Color.WHITE);
        add(labelusername);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30, 90, 150, 25);
        lblid.setForeground(Color.WHITE);
        add(lblid);

        tfid = new JTextField(); // Fixed typo: JTextFeild to JTextField
        tfid.setBounds(220, 90, 150, 25);
        add(tfid);

        JLabel lblnumber = new JLabel("ID NUMBER");
        lblnumber.setBounds(30, 130, 150, 25);
        lblnumber.setForeground(Color.WHITE);
        add(lblnumber);

        tfnumber = new JTextField(); // Fixed typo: JTextFeild to JTextField
        tfnumber.setBounds(220, 130, 150, 25);
        add(tfnumber);
        
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(30, 170, 150, 25);
        lblname.setForeground(Color.WHITE);
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(220, 170, 150, 25);
        labelname.setForeground(Color.WHITE);
        add(labelname);
        
        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(30, 210, 150, 25);
        lblgender.setForeground(Color.WHITE);
        add(lblgender);
        
        tfgender = new JTextField();
        tfgender.setBounds(220, 210, 150, 25);
        add(tfgender);
        
        JLabel lblcountry = new JLabel("COUNTRY");
        lblcountry.setBounds(30, 250, 150, 25);
        lblcountry.setForeground(Color.WHITE);
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(220, 250, 150, 25);
        tfcountry.setForeground(Color.BLACK);
        add(tfcountry);
        
        JLabel lbladdress = new JLabel("ADDRESS");
        lbladdress.setBounds(30, 290, 150, 25);
        lbladdress.setForeground(Color.WHITE);
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220, 290, 150, 25);
        tfaddress.setForeground(Color.BLACK);
        add(tfaddress);
        
        JLabel lblphone = new JLabel("PHONE");
        lblphone.setBounds(30, 330, 150, 25);
        lblphone.setForeground(Color.WHITE);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 150, 25);
        tfphone.setForeground(Color.BLACK);
        add(tfphone);
        
        JLabel lblemail = new JLabel("E-MAIL");
        lblemail.setBounds(30, 370, 150, 25);
        lblemail.setForeground(Color.WHITE);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(220, 370, 150, 25);
        tfemail.setForeground(Color.BLACK);
        add(tfemail);
        
        add = new JButton("UPDATE");
        add.setBackground(Color.WHITE);
        add.setForeground(Color.BLACK);
        add.setBounds(70, 430, 100,25);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("BACK");
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.setBounds(220, 430, 100,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/updatee.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image. SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 450, 420);
        add(image);
        
        try {
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
        while (rs.next()) {
            labelusername.setText(rs.getString("username"));
            labelname.setText(rs.getString("name"));
            tfid.setText(rs.getString("id"));
            tfnumber.setText(rs.getString("number"));
            tfgender.setText(rs.getString("gender"));
            tfcountry.setText(rs.getString("country"));
            tfaddress.setText(rs.getString("address"));
            tfphone.setText(rs.getString("phone"));
            tfemail.setText(rs.getString("email"));
            
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == add) {
        String username = labelusername.getText();
        String id = tfid.getText();
        String number = tfnumber.getText();
        String name = labelname.getText();
        String gender = tfgender.getText();
        String country = tfcountry.getText();
        String address = tfaddress.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();

        try {
            Conn c = new Conn();
            // Added WHERE clause to specify the record to be updated
            String query = "UPDATE customer SET id = '" + id + "', number = '" + number + "', name = '" + name + "', gender = '" + gender + "', country = '" + country + "', address = '" + address + "', phone = '" + phone + "', email = '" + email + "' WHERE username = '" + username + "'";
            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        setVisible(false);
    }
}


    public static void main(String[] args) {
        new UpdateCustomer("abu");
    }
}
