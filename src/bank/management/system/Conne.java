/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import java.sql.*;

public class Conne {
    Connection co;
        Statement st;
    public Conne()
    {
        
        
               try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            co=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Root@123");
            st=co.createStatement();
            
            
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
}
