package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
/**
 *
 * @author hcana
 */
public class FastCash extends JFrame implements ActionListener{
    
    String pinNumber;
    
    JButton b1, b2, b3, b4, b5, b6, back;
    
    FastCash(String pinNumber){
        
        this.pinNumber = pinNumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850, 670, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,850,670);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(210, 235, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 14));
        image.add(text);
        
        b1 = new JButton("Rs 100");
        b1.setBounds(160,337,140,25);
        b1.addActionListener(this);
        image.add(b1);
        
        b2 = new JButton("Rs 500");
        b2.setBounds(335,337,140,25);
        b2.addActionListener(this);
        image.add(b2);
        
        b3 = new JButton("Rs 1000");
        b3.setBounds(160,364,140,25);
        b3.addActionListener(this);
        image.add(b3);
        
        b4 = new JButton("Rs 2000");
        b4.setBounds(335,363,140,25);
        b4.addActionListener(this);
        image.add(b4);
        
        b5 = new JButton("Rs 5000");
        b5.setBounds(160,391,140,25);
        b5.addActionListener(this);
        image.add(b5);
        
        b6 = new JButton("Rs 10000");
        b6.setBounds(335,391,140,25);
        b6.addActionListener(this);
        image.add(b6);
        
        back = new JButton("Back");
        back.setBounds(335,418,140,25);
        back.addActionListener(this);
        image.add(back);
        
        setSize(850, 670);
        setLocation(250, 5);
        setUndecorated(true);
        setVisible(true);
        
    }    
    
    public void actionPerformed(ActionEvent ae){      
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
        else{
            Date date = new Date();
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("Select * from bank where pin = '"+pinNumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance = balance + Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance = balance - Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient balance");
                }
                else{                    
                    String query = "INSERT INTO bank VALUES ('"+pinNumber+"','"+date+"','Withdraw', '"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+amount+" Withdrawn");
                    new FastCash(pinNumber);
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    
    public static void main (String args[]){
        new FastCash("");
    }
    
}
