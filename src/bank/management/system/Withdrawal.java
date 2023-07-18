package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

/**
 *
 * @author hcana
 */
public class Withdrawal extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton withdrawal, back;
    String pinNumber;
    
    Withdrawal(String pinNumber){
        
        this.pinNumber = pinNumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850, 670, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,850,670);
        add(image);
        
        JLabel text = new JLabel("Enter the amount to be withdrawn");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 14));
        text.setBounds(210, 235, 400, 35);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 18));
        amount.setBounds(157, 285, 320, 25);
        image.add(amount);
        
        withdrawal = new JButton("Withdraw");
        withdrawal.setBounds(335,391,140,25);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        
        back = new JButton("Back");
        back.setBounds(335,418,140,25);
        back.addActionListener(this);
        image.add(back);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 670);
        setLocation(250, 5);
        setUndecorated(true);
        setVisible(true);   
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdrawal){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Enter amount");
            }
            else{
                
                try{
                    Conn conn = new Conn();   
                    ResultSet rs = conn.s.executeQuery("Select * from bank where pin = '"+pinNumber+"'");
                    int balance = 0;
                    while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance = balance + Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance = balance - Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(balance<Integer.parseInt(number)){
                    JOptionPane.showMessageDialog(null,"Insufficient balance");
                }
                else{   
                    String query = "INSERT INTO bank VALUES ('"+pinNumber+"','"+date+"','Withdraw', '"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+number+" Withdrawn");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Withdrawal("");
    }   
    
}
