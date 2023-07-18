package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author hcana
 */
public class Transactions extends JFrame implements ActionListener{
    
    String pinNumber;
    
    JButton deposit, withdrawal, pin, mini, fastcash, balance, exit;
    
    Transactions(String pinNumber){
        
        this.pinNumber = pinNumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850, 670, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,850,670);
        add(image);
        
        JLabel text = new JLabel("Please select you transaction");
        text.setBounds(210, 235, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 14));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(160,337,140,25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawal = new JButton("Cash Withdrawal");
        withdrawal.setBounds(335,337,140,25);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(160,364,140,25);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        mini = new JButton("Mini Statement");
        mini.setBounds(335,364,140,25);
        mini.addActionListener(this);
        image.add(mini);
        
        pin = new JButton("Pin Change");
        pin.setBounds(160,391,140,25);
        pin.addActionListener(this);
        image.add(pin);
        
        balance = new JButton("Balance Enquiry");
        balance.setBounds(335,391,140,25);
        balance.addActionListener(this);
        image.add(balance);
        
        exit = new JButton("Exit");
        exit.setBounds(335,418,140,25);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(850, 670);
        setLocation(250, 5);
        setUndecorated(true);
        setVisible(true);
        
    }    
    
    public void actionPerformed(ActionEvent ae){
        //deposit, withdrawal, pin, mini, fastcash, exit
        if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == withdrawal){
            setVisible(false);
            new Withdrawal(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == pin){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == mini){
            
            new MiniStatement(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == balance){
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == exit){
            System.exit(0);
        }
    }
    
    
    public static void main (String args[]){
        new Transactions("");
    }
    
}
