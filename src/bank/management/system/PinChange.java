package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author hcana
 */
public class PinChange extends JFrame implements ActionListener{
    
    JButton back, change;
    JPasswordField pin, repin;
    String pinNumber;
    
    PinChange(String pinNumber){
        
        this.pinNumber = pinNumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850, 670, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,850,670);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(250, 235, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 14));
        image.add(text);
        
        JLabel pinText = new JLabel("Enter New PIN: ");
        pinText.setBounds(165, 270, 180, 25);
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System", Font.BOLD, 14));
        image.add(pinText);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(300, 270, 180, 25);
        image.add(pin);
        
        JLabel repinText = new JLabel("Re-Enter New PIN: ");
        repinText.setBounds(165, 300, 180, 25);
        repinText.setForeground(Color.WHITE);
        repinText.setFont(new Font("System", Font.BOLD, 14));
        image.add(repinText);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(300, 300, 180, 25);
        image.add(repin);
        
        change = new JButton("Change");
        change.setBounds(335,391,140,25);
        change.addActionListener(this);
        image.add(change);
        
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
        if(ae.getSource() == change){
            String pi = pin.getText();
            String rpi = repin.getText();
            if(pi.equals("")){
                JOptionPane.showMessageDialog(null,"Enter PIN");
                return;                
            }
            if(rpi.equals("")){
                JOptionPane.showMessageDialog(null,"Renter PIN");
                return;                
            }            
            if(!pi.equals(rpi)){
                JOptionPane.showMessageDialog(null,"Entered PIN does not Match");
                return;
            }            
            else{                
                Conn conn = new Conn();
                try{
                    String query1 = "update bank set pin = '"+rpi+"' where pin = '"+pinNumber+"'";
                    String query2 = "update login set pin = '"+rpi+"' where pin = '"+pinNumber+"'";
                    String query3 = "update signupthree set pin = '"+rpi+"' where pin = '"+pinNumber+"'";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    conn.s.executeUpdate(query3);
                    JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
                    
                    setVisible(false);
                    new Transactions(rpi).setVisible(true);
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
    
    public static void main (String args[]){
        new PinChange("");
    }
}
