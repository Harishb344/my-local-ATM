/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
public class MiniStatement extends JFrame {
     MiniStatement(String pinnumber)
     {
         
         setLayout(null);
         setTitle("Mini Statement");
         setSize(400,600);
         setLocation(20,20);
         getContentPane().setBackground(Color.WHITE);
         setVisible(true);
         
         JLabel mini=new JLabel();
         add(mini);
         
         JLabel bank=new JLabel("Indian Bank");
         bank.setBounds(150,20,100,20);
         add(bank);
         
         JLabel card=new JLabel();
         card.setBounds(20,80,300,20);
         add(card);
         
         JLabel balance=new JLabel();
         balance.setBounds(20,400,300,20);
         add(balance);
          
         try
         {
             Conne conn=new Conne();
             ResultSet rs=conn.st.executeQuery("select * from login where pinnumber='"+pinnumber+"'");
            while(rs.next())
            {
             card.setText("Card Number:"+rs.getString("cardnumber").substring(0,4) + "XXXXXXXX"+ rs.getString("cardnumber").substring(12) );
            }
         }catch(Exception ae)
         {
         System.out.println(ae);
         
         }
        
         try
         {
           Conne crtr=new Conne();
           int balnc=0;
          ResultSet rst= crtr.st.executeQuery("select * from bank where pin='5541'");
          while(rst.next())
          {
             
                  mini.setText(mini.getText()+ "<html>"+ rst.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rst.getString("type")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rst.getString("amount") + "<br><br></html>" );            //add values in label by using setText
               if(rst.getString("type").equals("Deposit"))
                 {
                     balnc +=Integer.parseInt(rst.getString("amount"));
                     
                 }
                 else
                 {
                     balnc -=Integer.parseInt(rst.getString("amount"));
                 }
          }
          balance.setText("Your current account balance is Rs " + balnc);
         }catch(Exception e)
         {
             System.out.println(e);
         }
         mini.setBounds(20,140,400,200);
     
         
         
         
                 
         
     }
     public static void main(String args[])
     {
         new MiniStatement("");
     }
    
    
}
