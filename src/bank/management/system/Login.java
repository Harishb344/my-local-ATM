/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Login extends JFrame implements ActionListener{
    JButton login,clear,signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login()
    {
       setTitle("Automated Teller Machine");
       setLayout(null);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
       Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel label=new JLabel(i3);
       label.setBounds(70,10,100,100);
       add(label);
       JLabel text=new JLabel("Welcome to ATM");
       text.setFont(new Font("Osward",Font.BOLD,40));
       text.setBounds(200,40,350,40);
       
       add(text);
         JLabel cardno=new JLabel("Card No:");
       cardno.setFont(new Font("Osward",Font.BOLD,40));
       cardno.setBounds(120,150,400,40);
       
       add(cardno);
       cardTextField=new JTextField();
       cardTextField.setBounds(300,150,230,30);
       cardTextField.setFont(new Font("Arial",Font.BOLD,15));
       add(cardTextField);
       
         JLabel pin=new JLabel("Pin:");
       pin.setFont(new Font("Osward",Font.BOLD,40));
       
       pin.setBounds(120,220,250,30);
       
       add(pin);
       
        pinTextField=new JPasswordField();
       pinTextField.setBounds(300,220,230,30);
       pinTextField.setFont(new Font("Arial",Font.BOLD,15));
       add(pinTextField);
       
       login=new JButton("SIGN IN");
       login.setBounds(300,300,100,30);
       login.setBackground(Color.BLACK);
       login.setForeground(Color.WHITE);
       login.addActionListener(this);
       add(login);
       
         clear=new JButton("Clear");
       clear.setBounds(430,300,100,30);
       clear.setBackground(Color.BLACK);
       clear.setForeground(Color.WHITE);
       clear.addActionListener(this);

       add(clear);
       
          signup=new JButton("SIGN UP");
       signup.setBounds(300,350,230,30);
       signup.setBackground(Color.BLACK);
       signup.setForeground(Color.WHITE);
       signup.addActionListener(this);

       add(signup);
       getContentPane().setBackground(Color.WHITE);
       
  
//       
      
       setSize(800,480);
       setVisible(true);
       setLocation(350,200);
    
               
    }
     public static void main(String args[])
    {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clear)
        {
            cardTextField.setText(" ");
            pinTextField.setText(" ");
        }else if(e.getSource()== login)
        {
          Conne co=new Conne();
          String cardnumber=cardTextField.getText();
          String pinnumber=pinTextField.getText();
          String query="select * from login where cardnumber= '"+cardnumber+"' and pinnumber= '"+pinnumber+"'";
            try {
                ResultSet rs=co.st.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            } catch (SQLException ex) {
               System.out.println(ex);
            }
        
        
        }else if(e.getSource()== signup)
        {
         setVisible(false);
         new Signup1().setVisible(true);
        }
        
}
   
}
