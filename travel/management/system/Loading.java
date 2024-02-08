package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable {
    Thread t;
    JProgressBar bar;
    String username;

    private Loading() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void run(){
        try{
            for (int i=1; i<=101; i++) {
                int max = bar.getMaximum();
                int value = bar.getValue();
                
                if (value < max) {
                    bar.setValue(bar.getValue() + 1);
                    
                } else {
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(50);
            }
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    Loading(String username) {
        this.username =username;
        t = new Thread(this);
        
        setBounds(500, 200, 650, 400);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        
        JLabel text = new JLabel("VOYAGE VENTURES");
        text.setBounds(150, 20, 600, 40);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 35));
        add(text);
        
        bar = new JProgressBar();
        bar.setBounds(180, 100, 300, 35);
        bar.setStringPainted(true);
        add(bar);
        
        JLabel loading = new JLabel("LOADING....");
        loading.setBounds(210, 140, 200, 30);
        loading.setForeground(Color.WHITE);
        loading.setFont(new Font("Raleway", Font.BOLD, 20));
        add(loading);
        
        JLabel lblusername = new JLabel("WELCOME " + username);
        lblusername.setBounds(150, 310, 400, 40);
        lblusername.setForeground(Color.WHITE);
        lblusername.setFont(new Font("Raleway", Font.BOLD, 20));
        lblusername.setHorizontalAlignment(JLabel.CENTER);
        add(lblusername);
        
        t.start();
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Loading();
    }
}
