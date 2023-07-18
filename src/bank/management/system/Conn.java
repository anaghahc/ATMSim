package bank.management.system;

import java.sql.*;
/**
 *
 * @author hcana
 */
public class Conn {
    
    //register the driver
    //create connection
    //create statement
    //execute query
    //close connection
    
    
    Connection c;
    Statement s;
    public Conn(){        
        
        try{
            //Class.forName(com.mysql.cj.jdbc.Driver); //register the driver
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Amma0205*"); //create connection
            s = c.createStatement(); //create statement
            
        }
        catch (Exception e){
            System.out.println(e);
        }
    }    
    
}
