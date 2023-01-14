/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back;
    String pinnumber;
     BalanceEnquiry(String pinnumber)
     {  
         setLayout(null);
         this.pinnumber=pinnumber;
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel image=new JLabel(i3);
         image.setBounds(0,0,900,900);
         add(image);
               
        back=new JButton("Back");
        back.setBounds(370,420,100,20);
        back.addActionListener(this);
        image.add(back);
       
        Conne cst=new Conne();
        int balance=0;
         try
         {
             ResultSet rs=cst.st.executeQuery("select * from bank where pin= '"+pinnumber+"'");
             
             while(rs.next())//help to iterate rows
             {
                 if(rs.getString("type").equals("Deposit"))
                 {
                     balance+=Integer.parseInt(rs.getString("amount"));
                     
                 }
                 else
                 {
                     balance-=Integer.parseInt(rs.getString("amount"));
                 }
             }
         }catch(Exception e)
         {
             System.out.println(e);
         }
         JLabel text=new JLabel("Your Current Account balance is Rs "+balance);
         text.setBounds(270,300,300,35);
         text.setFont(new Font("System",Font.BOLD,10));
         text.setForeground(Color.WHITE);
         image.add(text);
      
         setSize(900,900)  ;
       setLocation(300,0);
       setUndecorated(true);
       setVisible(true);
       
     }
     public static void main(String args[])
     {
         new BalanceEnquiry("");
     }

    @Override
    public void actionPerformed(ActionEvent e) {
       setVisible(false);
       new Transactions(pinnumber).setVisible(true);
    }
    
    
}
