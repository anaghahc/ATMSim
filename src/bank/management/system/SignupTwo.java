package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author hcana
 */
public class SignupTwo extends JFrame implements ActionListener{
    
    String formno;
    JComboBox religionBox, categoryBox, incomeBox, qualificationBox, occupationBox;
    JTextField panTextField, aadharTextField;
    JRadioButton seniors, nonSeniors, exists, nonExists;
    JButton next;
    
    SignupTwo(String formno){
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 100, 30);
        add(religion);
        
        String religions[] = {"Hindu","Muslim","Sikh","Christian","Other"};        
        religionBox = new JComboBox(religions);
        religionBox.setFont(new Font("Raleway", Font.BOLD, 14));
        religionBox.setBounds(300, 140, 400, 30);
        religionBox.setBackground(Color.WHITE);
        add(religionBox);
        
        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);
        
        String categories[] = {"General","OBC","SC","ST","Other"};        
        categoryBox = new JComboBox(categories);
        categoryBox.setFont(new Font("Raleway", Font.BOLD, 14));
        categoryBox.setBounds(300, 190, 400, 30);
        categoryBox.setBackground(Color.WHITE);
        add(categoryBox);
        
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income); 
        
        String incomes[] = {"Nil","< 1,50,000","< 2,50,000","< 5,00,000","< 10,00,000", ">= 10,00,000"};        
        incomeBox = new JComboBox(incomes);
        incomeBox.setFont(new Font("Raleway", Font.BOLD, 14));
        incomeBox.setBounds(300, 240, 400, 30);
        incomeBox.setBackground(Color.WHITE);
        add(incomeBox);
        
        JLabel educational = new JLabel("Educational:");
        educational.setFont(new Font("Raleway", Font.BOLD, 20));
        educational.setBounds(100, 290, 200, 30);
        add(educational);  
        
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100, 315, 200, 30);
        add(qualification); 
        
        String qualifications[] = {"Non-Graduate","Graduate","Post-Graduation","Doctrate","Others"};        
        qualificationBox = new JComboBox(qualifications);
        qualificationBox.setFont(new Font("Raleway", Font.BOLD, 14));
        qualificationBox.setBounds(300, 310, 400, 30);
        qualificationBox.setBackground(Color.WHITE);
        add(qualificationBox);
        
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 390, 200, 30);
        add(occupation); 
        
        String occupations[] = {"Salaried","Self-Employed","Bussiness","Student","Retired","Others"};        
        occupationBox = new JComboBox(occupations);
        occupationBox.setFont(new Font("Raleway", Font.BOLD, 14));
        occupationBox.setBounds(300, 390, 400, 30);
        occupationBox.setBackground(Color.WHITE);
        add(occupationBox);
        
        JLabel pan = new JLabel("PAN:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 440, 200, 30);
        add(pan); 
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 440, 400, 30);
        add(panTextField);
        
        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 490, 200, 30);
        add(aadhar); 
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 490, 400, 30);
        add(aadharTextField);
        
        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        senior.setBounds(100, 540, 200, 30);
        add(senior);
        
        seniors = new JRadioButton("Yes");
        seniors.setBounds(300, 540, 80, 30);
        seniors.setBackground(Color.WHITE);
        add(seniors);
        nonSeniors = new JRadioButton("No");
        nonSeniors.setBounds(450, 540, 80, 30);
        nonSeniors.setBackground(Color.WHITE);
        add(nonSeniors);
        
        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(seniors);
        seniorGroup.add(nonSeniors);
        
        JLabel existing = new JLabel("Exisitng Account:");
        existing.setFont(new Font("Raleway", Font.BOLD, 20));
        existing.setBounds(100, 590, 200, 30);
        add(existing);
        
        exists = new JRadioButton("Yes");
        exists.setBounds(300, 590, 80, 30);
        exists.setBackground(Color.WHITE);
        add(exists);
        nonExists = new JRadioButton("No");
        nonExists.setBounds(450, 590, 80, 30);
        nonExists.setBackground(Color.WHITE);
        add(nonExists);
        
        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(exists);
        existingGroup.add(nonExists);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(720,590,80,30);
        next.addActionListener(this);
        add(next);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 670);
        setLocation(250, 5);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e){
        String religion = (String)religionBox.getSelectedItem();
        String category = (String)categoryBox.getSelectedItem();
        String education = (String)qualificationBox.getSelectedItem();
        String income = (String)incomeBox.getSelectedItem();
        String occupation = (String)occupationBox.getSelectedItem();
        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();         
        String senior = "";
        if(seniors.isSelected()){
            senior = "Yes";
        }
        else if(nonSeniors.isSelected()){
            senior = "No";
        }        
        String existing = "";
        if(exists.isSelected()){
            existing = "Yes";
        }
        else if(nonExists.isSelected()){
            existing = "No";
        }
        
        try{
            if(religion.equals("")){
                JOptionPane.showMessageDialog(null, "Select Religion");
            }
            else if(category.equals("")){
                JOptionPane.showMessageDialog(null, "Select Category");
            }
            else if(education.equals("")){
                JOptionPane.showMessageDialog(null, "Select Educational Qualification");
            }
            else if(income.equals("")){
                JOptionPane.showMessageDialog(null, "Select Income");
            }
            else if(occupation.equals("")){
                JOptionPane.showMessageDialog(null, "Select Occupation");
            }
            else if(pan.equals("")){
                JOptionPane.showMessageDialog(null, "PAN is Required");
            }
            else if(aadhar.equals("")){
                JOptionPane.showMessageDialog(null, "AAdhar Number is Required");
            }
            else if(senior.equals("")){
                JOptionPane.showMessageDialog(null, "Senior Citizen Status is Required");
            }
            else if(existing.equals("")){
                JOptionPane.showMessageDialog(null, "Existing Account Status is Required");
            }
            else{
                Conn c = new Conn();
                String query = "INSERT INTO signuptwo VALUES ('"+formno+"', '"+religion+"', '"+category+"', '"+education+"', '"+income+"', '"+occupation+"', '"+pan+"', '"+aadhar+"', '"+senior+"', '"+existing+"')";
                c.s.executeUpdate(query); //execute query              
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public static void main (String args[]){
        new SignupTwo("");
    }
}
