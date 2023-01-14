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

public class Transactions extends JFrame implements ActionListener {
    JButton deposit,withdrawl,fastCash,miniStatement,balanceEnquiry,exit,pinchange;
     String pinnumber;
    Transactions(String pinnumber)
    { 
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(getClass().getClassLoader().getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
     
        JLabel text=new JLabel("Please Select your Transaction");
        text.setBounds(275,300,250,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,12));
        
        image.add(text);
        
         deposit=new JButton("Deposit");
        deposit.setBounds(260,335,90,20);
        deposit.setFont(new Font("System",Font.BOLD,10));
        deposit.addActionListener(this);
        image.add(deposit);
        
            
         withdrawl=new JButton("Withdrawl");
        withdrawl.setBounds(370,335,90,20);
        withdrawl.setFont(new Font("System",Font.BOLD,10));
          withdrawl.addActionListener(this);
        image.add(withdrawl);
        
          fastCash=new JButton("FastCash");
        fastCash.setBounds(260,360,90,20);
        fastCash.setFont(new Font("System",Font.BOLD,10));
          fastCash.addActionListener(this);
        image.add(fastCash);
        
        
          miniStatement=new JButton("minSTMT");
        miniStatement.setBounds(370,360,90,20);
        miniStatement.setFont(new Font("System",Font.BOLD,10));
          miniStatement.addActionListener(this);
        image.add(miniStatement);
        
            
         pinchange=new JButton("ChangePin");
        pinchange.setBounds(260,385,90,20);
        pinchange.setFont(new Font("System",Font.BOLD,10));
        pinchange.addActionListener(this);
        image.add(pinchange);
        
          balanceEnquiry=new JButton("Balance");
        balanceEnquiry.setBounds(370,385,90,20);
        balanceEnquiry.setFont(new Font("System",Font.BOLD,10));
          balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);
        
         exit=new JButton("Exit");
        exit.setBounds(315,412,90,20);
        exit.setFont(new Font("System",Font.BOLD,10));
          exit.addActionListener(this);
        image.add(exit);
           
       
       
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);       
    }
   

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==exit)
        {
            System.exit(0);
        }else if(ae.getSource()==deposit)
        {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()== withdrawl)
        {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
            
        }
        else if(ae.getSource()==fastCash)
        {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==pinchange)
        {
         setVisible(false);
         new PinChange(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==balanceEnquiry)
        {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==miniStatement)
        {
            
            new MiniStatement(pinnumber).setVisible(true);
        }
              
            
    }
     public static void main(String args[])
    {
        new Transactions("");
    }
}