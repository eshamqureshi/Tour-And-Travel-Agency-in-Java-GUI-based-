/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

nested generics
Template based anonymous function
multi cast delegation 
nested templetes
 */

package riphah.tour.agency;

/**
 *
 * @author Qureshi Sab
 */

import java.awt.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Home extends JFrame implements ActionListener {
    String username;
    JButton addperson;
    JButton viewperson;
    JButton about;
      JButton note,deleteperson;
       JButton bookhotels,updateperson,checkpackages,
               bookpackages,viewpackages,viewhotels,
               viewhotelsbook,destination,pay,calcilater,log;
    public static void main(String[] args) {
        new Home("").setVisible(true);
    }
    
    public Home(String username) {
        
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);// FULL SCREEN
         setLayout(null);
         
         
         
         JPanel p1 = new JPanel();
         p1.setLayout(null);
         p1.setBackground(new Color (0,0,102));
       // p1.setFont(new Font("Tahoma", Font.PLAIN, 55));
	p1.setBounds(0, 0, 1600, 65);
        add(p1);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logor.jpg"));
        Image i2 = i1.getImage().getScaledInstance(70, 70,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
	JLabel icon = new JLabel(i3);
        icon.setBounds(5,0,70,70);
        p1.add(icon);
        
        
        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        
        JLabel text = new JLabel ("Riphah Tour and Travel Agency");
	text.setBounds(580,10,800,50);
        text.setForeground( Color.white);
        text.setFont(new Font("Arial", Font.PLAIN, 40));
	p1.add(text);
        
        heading.setBackground( Color.white);
        heading.setForeground( Color.white);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
	p1.add(heading); 
        
		JPanel p2 = new JPanel();
         p2.setLayout(null);
         p2.setBackground(new Color (0,0,102));
       // p1.setFont(new Font("Tahoma", Font.PLAIN, 55));
	p2.setBounds(0, 65, 300, 900);   //left bar
        add(p2);
        
        
       addperson = new JButton("Add Person Details");
        addperson.setBounds(0, 0, 300, 50);
        addperson.setBackground(new Color(0, 0, 109));
        addperson.setForeground(Color.white);
        addperson.setFont(new Font("Tahoma", Font.PLAIN, 20));
        addperson.setMargin(new Insets(0, 0, 0, 80));// to align button text left
        addperson.addActionListener(this); // Set ActionListener here
        p2.add(addperson);
         
         
         
          updateperson = new JButton("Update Person Details");
         updateperson.setBounds(0,50,300,50);
         updateperson.setBackground(new Color (0,0,109));
         updateperson.setForeground( Color.white);
         updateperson.setFont(new Font("Tahoma", Font.PLAIN, 20));
	updateperson.setMargin(new Insets(0,0,0,60));// to aline buttion text left  
        updateperson.addActionListener(this);
         p2.add(updateperson);
         
         
          viewperson = new JButton("View Person Details");
         viewperson.setBounds(0,100,300,50);
         viewperson.setBackground(new Color (0,0,109));
         viewperson.setForeground( Color.white);
         viewperson.setFont(new Font("Tahoma", Font.PLAIN, 20));
	viewperson.setMargin(new Insets(0,0,0,77));// to aline buttion text left 
        viewperson.addActionListener(this);
         p2.add(viewperson);
         
         
            deleteperson = new JButton("Delete Person Details");
         deleteperson.setBounds(0,150,300,50);
         deleteperson.setBackground(new Color (0,0,102));
         deleteperson.setForeground( Color.white);
         deleteperson.setFont(new Font("Tahoma", Font.PLAIN, 20));
	deleteperson.setMargin(new Insets(0,0,0,60));// to aline buttion text left
        deleteperson.addActionListener(this);
         p2.add(deleteperson);
         
         
          checkpackages = new JButton("Check packages");
         checkpackages.setBounds(0,200,300,50);
         checkpackages.setBackground(new Color (0,0,102));
         checkpackages.setForeground( Color.white);
         checkpackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
	checkpackages.setMargin(new Insets(0,0,0,115));// to aline buttion text left 
        checkpackages.addActionListener(this);
         p2.add(checkpackages);
         
         
           bookpackages = new JButton("Book Packages");
         bookpackages.setBounds(0,250,300,50);
         bookpackages.setBackground(new Color (0,0,102));
         bookpackages.setForeground( Color.white);
         bookpackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
	bookpackages.setMargin(new Insets(0,0,0,120));// to aline buttion text left  
        bookpackages.addActionListener(this);
         p2.add(bookpackages);
         
           viewpackages = new JButton("View Packages");
         viewpackages.setBounds(0,300,300,50);
         viewpackages.setBackground(new Color (0,0,102));
         viewpackages.setForeground( Color.white);
         viewpackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
	viewpackages.setMargin(new Insets(0,0,0,120));// to aline buttion text left  
        viewpackages.addActionListener(this);
         p2.add(viewpackages);
         
         
          viewhotels = new JButton("View hotels");
         viewhotels.setBounds(0,350,300,50);
         viewhotels.setBackground(new Color (0,0,102));
         viewhotels.setForeground( Color.white);
         viewhotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
	viewhotels.setMargin(new Insets(0,0,0,150));// to aline buttion text left   
        viewhotels.addActionListener(this);
         p2.add(viewhotels);
         
         
          bookhotels = new JButton("Book Hotels");
         bookhotels.setBounds(0,400,300,50);
         bookhotels.setBackground(new Color (0,0,102));
         bookhotels.setForeground( Color.white);
         bookhotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
	bookhotels.setMargin(new Insets(0,0,0,150));// to aline buttion text left  
        bookhotels.addActionListener(this);
         p2.add(bookhotels);
         
         
         
          viewhotelsbook = new JButton("View Booked Hotels");
         viewhotelsbook.setBounds(0,450,300,50);
         viewhotelsbook.setBackground(new Color (0,0,102));
         viewhotelsbook.setForeground( Color.white);
         viewhotelsbook.setFont(new Font("Tahoma", Font.PLAIN, 20));
	viewhotelsbook.setMargin(new Insets(0,0,0,75));// to aline buttion text left 
        viewhotelsbook.addActionListener(this);
         p2.add(viewhotelsbook);
         
         
            destination = new JButton("Destinations");
         destination.setBounds(0,500,300,50);
         destination.setBackground(new Color (0,0,102));
         destination.setForeground( Color.white);
         destination.setFont(new Font("Tahoma", Font.PLAIN, 20));
	destination.setMargin(new Insets(0,0,0,145));// to aline buttion text left   
        destination.addActionListener(this);
         p2.add(destination);
         
         
          pay = new JButton("Payments");
         pay.setBounds(0,550,300,50);
         pay.setBackground(new Color (0,0,102));
         pay.setForeground( Color.white);
         pay.setFont(new Font("Tahoma", Font.PLAIN, 20));
	pay.setMargin(new Insets(0,0,0,165));// to aline buttion text left   
        pay.addActionListener(this);
         p2.add(pay);
         
         
          calcilater = new JButton("Calculator");
         calcilater.setBounds(0,600,300,50);
         calcilater.setBackground(new Color (0,0,102));
         calcilater.setForeground( Color.white);
         calcilater.setFont(new Font("Tahoma", Font.PLAIN, 20));
	calcilater.setMargin(new Insets(0,0,0,160));// to aline buttion text left 
        calcilater.addActionListener(this);
         p2.add(calcilater);
         
         
         
          note = new JButton("Want to Write?");
         note.setBounds(0,650,300,50);
         note.setBackground(new Color (0,0,102));
         note.setForeground( Color.white);
         note.setFont(new Font("Tahoma", Font.PLAIN, 20));
	note.setMargin(new Insets(0,0,0,115));// to aline buttion text left  
        note.addActionListener(this);
         p2.add(note);
         
          about = new JButton("About us");
         about.setBounds(0,700,300,50);
         about.setBackground(new Color (0,0,102));
         about.setForeground( Color.white);
         about.setFont(new Font("Tahoma", Font.PLAIN, 20));
	about.setMargin(new Insets(0,0,0,170));// to aline buttion text left 
        about.addActionListener(this);
        
         p2.add(about);
         
          log = new JButton("Read log file");
         log.setBounds(0,750,300,50);
         log.setBackground(new Color (0,0,102));
         log.setForeground( Color.white);
         log.setFont(new Font("Tahoma", Font.PLAIN, 20));
	log.setMargin(new Insets(0,0,0,135));// to aline buttion text left 
        log.addActionListener(this);
        
         p2.add(log);
         
         
         
         
         ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
ImageIcon i6 = new ImageIcon(i5);
JLabel image = new JLabel(i6);
image.setBounds(0, 0, 1650, 1000); 
add(image);
        
        
       // JLabel text = new JLabel ("Riphah Tour and Travel Agency");
       //  text.setBounds(600,70,1200,70);
       //  text.setForeground( Color.BLACK);
       // text.setFont(new Font("Tahoma", Font.PLAIN, 55));
	//image.add(text); 
         
         
         setVisible(true);
         
         
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addperson) {
            try {
                  new AddCustomer(username).setVisible(true); //
            } catch (SQLException e) { 
                // Handle SQLException, if needed
                e.printStackTrace();
            }
        }
        
       else if (ae.getSource() == viewperson ) {
            try{
                    new ViewCustomers().setVisible(true);//
                }catch(Exception e ){}
            }
        
    
    else if (ae.getSource() == about ) {
            try{
                    new About().setVisible(true);//
                }catch(Exception e ){}
            }
        
        else if (ae.getSource() == deleteperson ) {
            try{
                    new DeleteCustomer ().setVisible(true);
                }catch(Exception e ){}
            }
        
        else if (ae.getSource() == note ) {
            try{
                    Runtime.getRuntime().exec("notepad.exe");
                }catch(Exception e ){}
            }
        
        else if (ae.getSource() == bookhotels ) {
            try{
                    new BookHotel(username).setVisible(true);//
                }catch(Exception e ){}
            }
        
        else if (ae.getSource() == bookpackages ) {
            try{
                    new BookPackage(username).setVisible(true);//
                }catch(Exception e ){}
            }
        
        else if (ae.getSource() == deleteperson ) {
            try{
                    new DeleteCustomer().setVisible(true);//
                }catch(Exception e ){}
            }
        else if (ae.getSource() == updateperson ) {
            try{
                    new UpdateCustomer(username).setVisible(true);//
                }catch(Exception e ){}
            }
        else if (ae.getSource() == checkpackages ) {
            try{
                    new CheckPackage().setVisible(true);//
                }catch(Exception e ){}
            }
        else if (ae.getSource() == viewhotels ) {
            try{
                    new CheckHotels().setVisible(true);//
                }catch(Exception e ){}
            }
        else if (ae.getSource() == viewpackages ) {
            try{
                    new ViewPackage(username).setVisible(true);//
                }catch(Exception e ){}
            }
        
    
    else if (ae.getSource() == destination ) {
            try{
                    new Destination().setVisible(true);//
                }catch(Exception e ){}
            }
         else if (ae.getSource() == pay ) {
            try{
                    new Payment().setVisible(true);//
                }catch(Exception e ){}
         }
        
        else if (ae.getSource() == calcilater ) {
            try{
                  Runtime.getRuntime().exec("calc.exe");  
                }catch(Exception e ){}
         }
         
         
        else if (ae.getSource() == viewhotelsbook ) {
            try{
                  new ViewBookedHotel (username).setVisible(true);//
                }catch(Exception e ){}
         }
        
        else if (ae.getSource() == log ) {
            try{
                  new ReadFile ().setVisible(true);//
                }catch(Exception e ){}
         }
        }
}
    
 
  
 

   