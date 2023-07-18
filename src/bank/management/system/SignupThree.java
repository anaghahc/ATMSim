package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 *
 * @author hcana
 */
public class SignupThree extends JFrame implements ActionListener{
    
    String formno;    
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    
    SignupThree(String formno){
        
        this.formno = formno;
        
        setLayout(null);
        
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);
        
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 16));
        type.setBounds(100, 100, 200, 30);
        add(type);
        
        r1 = new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway", Font.PLAIN, 14));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,140,160,20);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.PLAIN, 14));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,140,200,20);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.PLAIN, 14));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,180,160,20);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.PLAIN, 14));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,180,220,20);
        add(r4);
        
        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(r1);
        groupAccount.add(r2);
        groupAccount.add(r3);
        groupAccount.add(r4);
        
        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 16));
        card.setBounds(100, 230, 200, 30);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-2023");
        number.setFont(new Font("Raleway", Font.BOLD, 16));
        number.setBounds(330, 230, 400, 30);
        add(number);
        
        JLabel cdetail = new JLabel("Your 16 Digit Card Number");
        cdetail.setFont(new Font("Raleway", Font.ITALIC, 12));
        cdetail.setBounds(100, 260, 300, 20);
        add(cdetail);
        
        JLabel pin = new JLabel("Pin");
        pin.setFont(new Font("Raleway", Font.BOLD, 16));
        pin.setBounds(100, 300, 400, 30);
        add(pin);
        
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 16));
        pnumber.setBounds(330, 300, 400, 30);
        add(pnumber);
        
        JLabel pdetail = new JLabel("Your 4 Digit Pin Number");
        pdetail.setFont(new Font("Raleway", Font.ITALIC, 12));
        pdetail.setBounds(100, 330, 300, 20);
        add(pdetail);
        
        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 16));
        services.setBounds(100, 380, 200, 30);
        add(services);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.PLAIN, 14));
        c1.setBounds(100, 430, 200, 30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.PLAIN, 14));
        c2.setBounds(350, 430, 200, 30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.PLAIN, 14));
        c3.setBounds(100, 460, 200, 30);
        add(c3);
        
        c4 = new JCheckBox("Email and SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.PLAIN, 14));
        c4.setBounds(350, 460, 200, 30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.PLAIN, 14));
        c5.setBounds(100, 490, 200, 30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.PLAIN, 14));
        c6.setBounds(350, 490, 200, 30);
        add(c6);
        
        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.PLAIN, 14));
        c7.setBounds(100, 540, 700, 30);
        add(c7);
        
        submit = new JButton("Submit");     
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 580, 100, 30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");     
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420, 580, 100, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 670);
        setLocation(250, 5);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accountType = "";
            if(r1.isSelected()){
                accountType = "Savings Account";
            }
            else if(r2.isSelected()){
                accountType = "Fixed Deposit Account";
            }
            else if(r3.isSelected()){
                accountType = "Current Account";
            }
            else if(r4.isSelected()){
                accountType = "Reccuring Deposit Account";
            }
            
            Random rand = new Random();
            String cardNumber = ""+(Math.abs((rand.nextLong() % 90000000L)) + 5040936000000000L);
            
            String pinNumber = ""+(Math.abs((rand.nextLong() % 9000L)) + 100L);
            
            String facility = "";
            if(c1.isSelected()){
                facility = facility + "ATM Card ";
            }
            if(c2.isSelected()){
                facility = facility + "Internet Banking ";
            }
            if(c3.isSelected()){
                facility = facility + "Mobile Banking ";
            }
            if(c4.isSelected()){
                facility = facility + "Email and SMS Alerts ";
            }
            if(c5.isSelected()){
                facility = facility + "Cheque Book ";
            }
            if(c6.isSelected()){
                facility = facility + "E-Statement ";
            }
            
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Select Account Type");
                }    
                else if(!c7.isSelected()){
                    JOptionPane.showMessageDialog(null, "Please accept the declaration statement");
                }
                else{                
                    Conn c = new Conn();
                    String query1 = "INSERT INTO signupthree VALUES ('"+formno+"','"+accountType+"', '"+cardNumber+"', '"+pinNumber+"', '"+facility+"')";
                    String query2 = "INSERT INTO login VALUES ('"+formno+"','"+cardNumber+"', '"+pinNumber+"')";
                    c.s.executeUpdate(query1); //execute query1
                    c.s.executeUpdate(query2); //execute query2
                    
                    JOptionPane.showMessageDialog(null,"Card Number: "+cardNumber+"\nPin: "+pinNumber);
                    
                    setVisible(false);
                    new Deposit(pinNumber).setVisible(true);
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
            
            
        }
        else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new SignupThree("");
    }
}
