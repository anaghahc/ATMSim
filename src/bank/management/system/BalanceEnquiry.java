package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
/**
 *
 * @author hcana
 */
public class BalanceEnquiry extends JFrame implements ActionListener{
    
    String pinNumber;
    JButton back;
    
    BalanceEnquiry(String pinNumber){
        this.pinNumber = pinNumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850, 670, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,850,670);
        add(image);
        
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
                JLabel text = new JLabel("Your Account Balance is Rs "+balance);
                text.setForeground(Color.WHITE);
                text.setBounds(170,250,400,30);
                text.setFont(new Font("System", Font.BOLD, 14));
                image.add(text);
            }
            catch(Exception e){
                System.out.println(e);
            }
        
        back = new JButton("Back");
        back.setBounds(335,418,140,20);
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
    }
    
    public static void main (String args[]){
        new BalanceEnquiry("");
    }
}
