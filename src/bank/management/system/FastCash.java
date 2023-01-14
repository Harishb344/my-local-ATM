/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class FastCash extends JFrame implements ActionListener {
    JButton deposit,withdrawl,fastCash,miniStatement,balanceEnquiry,exit,pinchange;
     String pinnumber;
    FastCash(String pinnumber)
    { 
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(getClass().getClassLoader().getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
     
        JLabel text=new JLabel("SELECT WITHDRWAL AMOUNT");
        text.setBounds(275,300,250,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,13));
        
        image.add(text);
        
         deposit=new JButton("Rs 100");
        deposit.setBounds(260,340,100,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
            
         withdrawl=new JButton("Rs 500");
        withdrawl.setBounds(370,340,100,30);
          withdrawl.addActionListener(this);
        image.add(withdrawl);
        
          fastCash=new JButton("Rs 1000");
        fastCash.setBounds(260,375,100,30);
          fastCash.addActionListener(this);
        image.add(fastCash);
        
        
          miniStatement=new JButton("Rs 2000");
        miniStatement.setBounds(370,375,100,30);
          miniStatement.addActionListener(this);
        image.add(miniStatement);
        
            
         pinchange=new JButton("Rs 5000");
        pinchange.setBounds(260,410,100,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
          balanceEnquiry=new JButton("Rs 10000");
        balanceEnquiry.setBounds(370,410,100,30);
          balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);
        
         exit=new JButton("Back");
        exit.setBounds(370,445,100,30);
          exit.addActionListener(this);
        image.add(exit);
           
       
       
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);       
    }
    public static void main(String args[])
    {
        new FastCash("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==exit)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else 
        {
         String amount=((JButton)ae.getSource()).getText().substring(3);//gives amount like Rs 500
         Conne cst=new Conne();
         try
         {
             ResultSet rs=cst.st.executeQuery("select * from bank where pin= '"+pinnumber+"'");
             int balance=0;
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
             if(ae.getSource()!=exit && balance < Integer.parseInt(amount))
             {
                 JOptionPane.showMessageDialog(null, "Insufficient Balance");
                 return;
             }
             Date date=new Date();
             String query= "insert into bank values('"+pinnumber+"', '"+date+"','Withdrawl','"+amount+"')";
             cst.st.executeUpdate(query);
             JOptionPane.showMessageDialog(null, "Rs" + amount + "debited successfully");
             setVisible(false);
             new Transactions(pinnumber).setVisible(true);
         }catch(Exception e)
         {
          System.out.println(e);
         }
        }
    }
}