package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    
    String username;
    JButton addPersonalDetails, viewPersonalDetails, updatePersonalDetails,checkPackages,bookPackages;
    JButton viewPackages, viewHotels, destinations, bookHotels,viewBookedHotels,payments;
    JButton calculators, notepad,about;
    Dashboard(String username) {
        
        this.username= username;

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.BLACK);
        p1.setBounds(0, 0, 1600, 65);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dash.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);

        JLabel heading = new JLabel("DASHBOARD");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(15, 1, 0, 0)); // GridLayout with 15 rows and vertical gap of 5
        p2.setBackground(Color.BLACK);
        p2.setBounds(0, 65, 300, 600); // Adjusted the height to 1000
        add(p2);

        int buttonHeight = 50;

        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBackground(Color.BLACK);
        addPersonalDetails.setForeground(Color.WHITE);
        addPersonalDetails.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);

        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBackground(Color.BLACK);
        updatePersonalDetails.setForeground(Color.WHITE);
        updatePersonalDetails.setFont(new Font("Times New Roman", Font.PLAIN, 20)); 
        updatePersonalDetails.addActionListener(this); 
        p2.add(updatePersonalDetails);

        viewPersonalDetails = new JButton("View Details");
        viewPersonalDetails.setBackground(Color.BLACK);
        viewPersonalDetails.setForeground(Color.WHITE);
        viewPersonalDetails.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);

        JButton deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBackground(Color.BLACK);
        deletePersonalDetails.setForeground(Color.WHITE);
        deletePersonalDetails.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        p2.add(deletePersonalDetails);

        checkPackages = new JButton("Check Packages");
        checkPackages.setBackground(Color.BLACK);
        checkPackages.setForeground(Color.WHITE);
        checkPackages.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        checkPackages.addActionListener(this);
        p2.add(checkPackages);

        bookPackages = new JButton("Book Packages");
        bookPackages.setBackground(Color.BLACK);
        bookPackages.setForeground(Color.WHITE);
        bookPackages.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        bookPackages.addActionListener(this);
        p2.add(bookPackages);

        viewPackages = new JButton("View Packages");
        viewPackages.setBackground(Color.BLACK);
        viewPackages.setForeground(Color.WHITE);
        viewPackages.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        viewPackages.addActionListener(this);
        p2.add(viewPackages);

        viewHotels = new JButton("View Hotels");
        viewHotels.setBackground(Color.BLACK);
        viewHotels.setForeground(Color.WHITE);
        viewHotels.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        viewHotels.addActionListener(this);
        p2.add(viewHotels);

        bookHotels = new JButton("Book Hotels");
        bookHotels.setBackground(Color.BLACK);
        bookHotels.setForeground(Color.WHITE);
        bookHotels.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        bookHotels.addActionListener(this);
        p2.add(bookHotels);

        viewBookedHotels = new JButton("View Booked Hotels");
        viewBookedHotels.setBackground(Color.BLACK);
        viewBookedHotels.setForeground(Color.WHITE);
        viewBookedHotels.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        viewBookedHotels.addActionListener(this);
        p2.add(viewBookedHotels);

        destinations = new JButton("Destinations ");
        destinations.setBackground(Color.BLACK);
        destinations.setForeground(Color.WHITE);
        destinations.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        destinations.addActionListener(this);
        p2.add(destinations);

        payments = new JButton("Payments");
        payments.setBackground(Color.BLACK);
        payments.setForeground(Color.WHITE);
        payments.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        payments.addActionListener(this);
        p2.add(payments);

        calculators = new JButton("Calculators");
        calculators.setBackground(Color.BLACK);
        calculators.setForeground(Color.WHITE);
        calculators.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        calculators.addActionListener(this);
        p2.add(calculators);

        notepad = new JButton("Notepad");
        notepad.setBackground(Color.BLACK);
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        notepad.addActionListener(this);
        p2.add(notepad);

        about = new JButton("About");
        about.setBackground(Color.BLACK);
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        about.addActionListener(this);
        p2.add(about);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650,1000,Image.SCALE_DEFAULT );
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0,1650,1000);
        add(image);
        
        JLabel text = new JLabel("             VOYAGE VENTURES");
        text.setBounds(400, 70, 1200, 70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Times New Roman", Font.PLAIN, 55));
        image.add(text);

        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == addPersonalDetails) {
            new AddCustomer(username);
        } else if (ae. getSource() == viewPersonalDetails){
            new ViewCustomer(username);
        } else if (ae.getSource() == updatePersonalDetails){
            new UpdateCustomer(username);
        }  else if (ae.getSource() == checkPackages) {
            new CheckPackage();
        } else if (ae.getSource() == bookPackages) {
            new BookPackage(username);
        } else if (ae.getSource() == viewPackages) {
            new ViewPackage(username);
        } else if (ae. getSource() == viewHotels) {
            new CheckHotels();
        } else if (ae. getSource() == destinations) {
            new Destinations();
        } else if (ae. getSource() == bookHotels) {
            new BookHotel(username);
        } else if (ae. getSource () == viewBookedHotels) {
            new ViewBookedHotel(username);
        } else if (ae.getSource() == payments) {
            new Payment();
        } else if (ae.getSource() == calculators) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == notepad) {
            try{
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
         } else if (ae.getSource() == about) {
             new About();
         }
    }
    
    public static void main(String[] args) {
        new Dashboard("");
    }

    


}
