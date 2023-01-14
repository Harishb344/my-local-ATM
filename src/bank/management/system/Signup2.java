
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
import java.sql.*;


import java.awt.event.*;
        

public class Signup2 extends JFrame implements ActionListener {
    long random;
    JTextField pan,aadhar;
    JRadioButton syes,sno,eyes,eno;
    JButton next;
    String formno;
   
    JComboBox religion,category,income,education,occupation;
    Signup2(String formno)
    {
        this.formno=formno;
        setLayout(null);
        setTitle("New Application Account Form -PAGE2");
       
        
        JLabel additionaldetails=new JLabel("PAGE 2: Additional Details");
        additionaldetails.setFont(new Font("Raleway",Font.BOLD,38));
        additionaldetails.setBounds(140,20,600,40);
        add(additionaldetails);
         
      
        
          JLabel name=new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        String VarReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
         religion=new JComboBox(VarReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        String ValCategory[]={"Open","OBC","ST","SC","VJNT","NT-A","NT-B","NT-C","NT-D","SBC","EWS"};
         category=new JComboBox(ValCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);
         
        
        
        
        JLabel Fname=new JLabel("Category:");
        Fname.setFont(new Font("Raleway",Font.BOLD,20));
        Fname.setBounds(100,190,170,30);
        add(Fname);
      
        
        JLabel dob=new JLabel("Income:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,170,30);
        add(dob);
        
        String incomeCategory[]={"NULL","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
         income=  new JComboBox(incomeCategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
      
        
        
                
     
        
        
         JLabel gender=new JLabel("Educational");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        JLabel email=new JLabel("Qualification:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,315,200,30);
        add(email);
        
        String educationValues[]={"Non-Graduation","Graduate","Post-Graduation","PhD","Others"};
         education=new JComboBox(educationValues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);
    
        
         
               
        
         JLabel mstatus=new JLabel("Occupation:");
        mstatus.setFont(new Font("Raleway",Font.BOLD,20));
        mstatus.setBounds(100,390,200,30);
        add(mstatus);
        
        String occupationValues[]={"Salaried","Self-Employeed","Businessman","Student","Retired","Others"};
         occupation=new JComboBox(occupationValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        
        
        
          
        
       
        
         JLabel address=new JLabel("PAN Number:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
         pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(300,440,400,30);
        add(pan);
        
       
        
         JLabel City=new JLabel("Aadhar Number:");
        City.setFont(new Font("Raleway",Font.BOLD,20));
        City.setBounds(100,490,200,30);
        add(City);
        
        aadhar=new JTextField();
        aadhar.setFont(new Font("Railway",Font.BOLD,20));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
 
        
         JLabel state=new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
       syes=new JRadioButton("Yes");
       syes.setBounds(300,545,100,30);
       syes.setBackground(Color.WHITE);
       add(syes);
       
       sno=new JRadioButton("No");
       sno.setBounds(400,545,100,30);
       sno.setBackground(Color.WHITE);
       add(sno);
       
       ButtonGroup seniorcitizengroup=new ButtonGroup();
       seniorcitizengroup.add(syes);
       seniorcitizengroup.add(sno);
       
        
        
        JButton next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Railway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        
         
        
        
         JLabel pincode=new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
     eyes=new JRadioButton("Yes");
     eyes.setBounds(300,595,100,30);
     eyes.setBackground(Color.WHITE);
     add(eyes);
      
      eno=new JRadioButton("No");
      eno.setBounds(400,595,100,30);
     eyes.setBackground(Color.WHITE);
     add(eno);
      
      ButtonGroup existaccountgroup=new ButtonGroup();
     existaccountgroup.add(syes);
     existaccountgroup.add(sno);
         
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
       
    }
   
    public static void main(String args[])
    {
        new Signup2("");
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String formno=""+random;//long to convert string
        String sreligion= (String)religion.getSelectedItem();
        String scategory= (String)category.getSelectedItem();
         String sincome=(String) income.getSelectedItem();
        String seducation=(String) education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String seniorcitizen=null;
        if(syes.isSelected())
        {
         seniorcitizen="Yes";
         
        }else if(sno.isSelected())
        {
            seniorcitizen="No";
        }
       
        String existingaccount=null;
        if(eyes.isSelected())
        {
            existingaccount="Yes";
        }
        else if (eno.isSelected())
        {
            existingaccount="No";
        }
       
        String span=pan.getText();
        String saadhar=aadhar.getText();
        
        
        try
        {
            
                Conne c=new Conne();
                String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                c.st.executeUpdate(query);
                setVisible(false);
                new signup3(formno).setVisible(true);
                //signup3 Object
                
                
                
            
        }
        catch(Exception ae)
        {
            System.out.println(ae);
        }
    }
      
        
    }




