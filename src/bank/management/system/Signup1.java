/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.sql.*;



import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
        
public class Signup1 extends JFrame implements ActionListener {
    
    JTextField nameTextField,FnameTextField,dobTextField,emailTextField,addressTextField,CityTextField,stateTextField,pinTextField;
    JRadioButton male,female,married,single,other;
    JButton next;
    JDateChooser dateChooser;
    String formno;
    Signup1()
    {
        setLayout(null);
        Random rao=new Random();
        long random=(Math.abs(rao.nextLong()%9000L)+1000L);
        
        JLabel formno=new JLabel("APPLICATION FORM NO: "+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
         
        JLabel personaldetails=new JLabel("Page 1: personal details");
        personaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        personaldetails.setBounds(290,70,400,40);
        add(personaldetails);
        
          JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
         nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,20));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
        
        
        
        JLabel Fname=new JLabel("Fathers Name:");
        Fname.setFont(new Font("Raleway",Font.BOLD,20));
        Fname.setBounds(100,190,170,30);
        add(Fname);
        
       FnameTextField=new JTextField();
        FnameTextField.setFont(new Font("Raleway",Font.BOLD,20));
        FnameTextField.setBounds(300,190,400,30);
        add(FnameTextField);
        
        JLabel dob=new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,170,30);
        add(dob);
        
        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,240,400,30 );
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);
        
        
                
     
        
        
         JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
         male=new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        
         female=new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        
        
      
        
        
        
       
        
        
         JLabel email=new JLabel("Email:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        
         emailTextField=new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,20));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);
        
               
        
         JLabel mstatus=new JLabel("Marital Status:");
        mstatus.setFont(new Font("Raleway",Font.BOLD,20));
        mstatus.setBounds(100,390,200,30);
        add(mstatus);
        
        
         married=new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        
           single=new JRadioButton("Single");
        single.setBounds(450,390,100,30);
        single.setBackground(Color.WHITE);
        add(single);
        
         other=new JRadioButton("Other");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);
        
        
        ButtonGroup marritalgroup=new ButtonGroup();
        marritalgroup.add(married);
        marritalgroup.add(single);
        marritalgroup.add(other);
        
         JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
         addressTextField=new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,20));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);
        
       
        
         JLabel City=new JLabel("City:");
        City.setFont(new Font("Raleway",Font.BOLD,20));
        City.setBounds(100,490,200,30);
        add(City);
        
        CityTextField=new JTextField();
        CityTextField.setFont(new Font("Railway",Font.BOLD,20));
        CityTextField.setBounds(300,490,400,30);
        add(CityTextField);
 
        
         JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
         stateTextField=new JTextField();
        stateTextField.setFont(new Font("Railway",Font.BOLD,20));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);
        
        
        JButton next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Railway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        
         
        
        
         JLabel pincode=new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
          pinTextField=new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,20));
        pinTextField.setBounds(300,590,400,30);
        add(pinTextField);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
       
    }
   
    public static void main(String args[])
    {
        new Signup1();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
       //long to convert string
        String name=nameTextField.getText();
        String Fname=FnameTextField.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected())
        {
         gender="Male";
         
        }else if(female.isSelected())
        {
            gender="Female";
        }
        String email=emailTextField.getText();
        String marrital=null;
        if(married.isSelected())
        {
            marrital="Married";
        }
        else if (single.isSelected())
        {
            marrital="Single";
        }
        else if(other.isSelected())
        {
            marrital="Other";
        }
        String address=addressTextField.getText();
        String City=CityTextField.getText();
        String state=stateTextField.getText();
        String pin=pinTextField.getText();
        
        try
        {
            if(name.equals(""))
            {
             JOptionPane.showMessageDialog(null,"Name is required");
             }
            else
            {
                Conne c=new Conne();
                
                String query="insert into signup values('"+formno+"','"+name+"','"+Fname+"','"+dob+"','"+gender+"','"+email+"','"+marrital+"','"+address+"','"+City+"','"+state+"','"+pin+"')";
                c.st.executeUpdate(query);
               setVisible(false);
               new Signup2(formno).setVisible(true);
               
                
                
            }
        }
        catch(Exception ae)
        {
            System.out.println(ae);
        }
    }
      
        
    }


