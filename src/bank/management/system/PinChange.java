/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PinChange extends JFrame implements ActionListener  {
    JButton change,back;
    JPasswordField pin,repin;
     
     String pinnumber;
    
    PinChange(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);
        
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
      Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
      ImageIcon i3=new ImageIcon(i2);
      JLabel image=new JLabel(i3);
      image.setBounds(0,0,900,900);
      add(image);
      setSize(900,900);
      setLocation(300,0);
      setUndecorated(true);
      setVisible(true);
      
      JLabel text=new JLabel("CHANGE YOUR PIN");
      text.setForeground(Color.WHITE);
      text.setFont(new Font("System",Font.BOLD,16));
      text.setBounds(295,300,250,25);
      image.add(text);
      
         JLabel pintext=new JLabel("New PIN:");
      pintext.setForeground(Color.WHITE);
      pintext.setFont(new Font("System",Font.BOLD,16));
      pintext.setBounds(260,325,150,25);
      image.add(pintext);
      
       pin=new JPasswordField();
      pin.setFont(new Font("Raleway",Font.BOLD,12));
      pin.setBounds(330,329,130,20);
      image.add(pin);
      

JLabel repintext=new JLabel("ReEnter\nNew Pin:");
      repintext.setForeground(Color.WHITE);
      repintext.setFont(new Font("System",Font.BOLD,16));
      repintext.setBounds(260,350,200,25);
     image.add(repintext);
     
      repin=new JPasswordField();
     repin.setFont(new Font("Raleway",Font.BOLD,12));
     repin.setBounds(330,375,130,20);
     image.add(repin);
     
      change=new JButton("CHANGE");
     change.setBounds(370,400,100,20);
     change.addActionListener(this);
     image.add(change);
     
      back=new JButton("BACK");
     back.setBounds(370,425,100,20);
     back.addActionListener(this);
     image.add(back);
      
     
      
   
      
      
    }
    public static void main(String args[])
    {
        new PinChange("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==change)
        {
       try
       {
        String npin=pin.getText();
        String rpin=repin.getText();
        if(!npin.equals(rpin))
        {
            JOptionPane.showMessageDialog(null, "Entered pin doesn't match");
            return;
        }
        if(npin.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter pin");
            return;
        }
        if(rpin.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please Re Enter new Pin");
            return;
        }
        Conne crt=new Conne();
        String query1="update bank set pin='"+rpin+"' where pin='"+pinnumber+"'";
        String query2="update login set pinnumber='"+rpin+"' where pinnumber='"+pinnumber+"'";  
        String query3="update signupthree set pinnumber='"+rpin+"' where pinnumber='"+pinnumber+"'";
        
        crt.st.executeUpdate(query1);
        crt.st.executeUpdate(query2);
        crt.st.executeUpdate(query3);
        
        JOptionPane.showMessageDialog(null, "PIN changed successfully");
        setVisible(false);
        new Transactions(rpin).setVisible(true);
       }catch(Exception ae)
       {
           System.out.println(ae);
           
       }
    }
       else
       {
           setVisible(false);
       new Transactions(pinnumber).setVisible(true); 
        }
    }
}
