/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Withdrawl extends JFrame implements ActionListener {
    JTextField amount;
    JButton withdraw,back;
    String pinnumber;
    Withdrawl(String pinnumber)
    {
       this.pinnumber=pinnumber;
      ImageIcon i1=new ImageIcon(getClass().getClassLoader().getSystemResource("icons/atm.jpg"));
      Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
      ImageIcon i3=new ImageIcon(i2);
      JLabel image=new JLabel(i3);
      image.setBounds(0,0,900,900);
      add(image);
      
      JLabel text=new JLabel("Enter the amount you want to withdraw ");
      text.setBackground(Color.BLACK);
      text.setForeground(Color.GREEN);
      text.setFont(new Font("System",Font.BOLD,12));
      text.setBounds(260,275,250,35);
      image.add(text);
      
       amount=new JTextField();
      amount.setFont(new Font("Raleway",Font.BOLD,22));
      amount.setBounds(255,310,215,20);
      image.add(amount);
      
       withdraw=new JButton("withdraw");
      withdraw.setBounds(366,355,100,30);
      withdraw.addActionListener(this);
      image.add(withdraw);
      
       back=new JButton("Back");
      back.setBounds(366,385,100,30);
      back.addActionListener(this);
      image.add(back);
      
      
     setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    public static void main(String args[])
    {
        new Withdrawl("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==withdraw)
        {
            String number=amount.getText();
            Date date=new Date();
            if(number.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
                
            }
            else
            {
                Conne ct=new Conne();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
                
                try {
                    ct.st.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs" + number +" Withdraw Successfully");
                } catch (SQLException ex) {
                    Logger.getLogger(Deposit.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println(e);
                    new Transactions(pinnumber).setVisible(true);
                }
                
                        
            }
        }else if(e.getSource()==back)
        {
          setVisible(false);
          new Transactions(pinnumber).setVisible(true);
          
        }
      
    }
            
    
}
