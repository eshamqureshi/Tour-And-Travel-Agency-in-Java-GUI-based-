/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riphah.tour.agency;
import java.sql.*;
/**
 *
 * @author Qureshi Sab
 */
public class connect {
    Connection c;
    Statement s;
    public connect(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");
            c =DriverManager.getConnection("jdbc:mysql:///tms","root","eshamhacker"); 
            
            s =c.createStatement();  
            
           
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  