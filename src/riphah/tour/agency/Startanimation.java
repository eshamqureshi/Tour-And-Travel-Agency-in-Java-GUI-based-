/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riphah.tour.agency;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Qureshi Sab
 */
public class Startanimation extends JFrame implements Runnable{
    
    
    Thread t1;
    Startanimation(){
        setLayout(new FlowLayout());
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icons/start.jpg"));
        Image i1 = c1.getImage().getScaledInstance(1030, 750,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        
        JLabel l1 = new JLabel(i2);
        add(l1);
        setUndecorated(true);
        t1 = new Thread(this);
        t1.start();
    }
    public void run(){
        try{
            Thread.sleep(7000);
            this.setVisible(false);
            
            Login l = new Login();
          l.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

public static void main(String[] args)
     {
        Startanimation f1 = new Startanimation();
        f1.setVisible(true);
        int i;
        int x=1;
        for(i=2; i<=600; i+=10, x+=7){
            f1.setLocation(900 - ((i+x)/2), 500 - (i/2));
            f1.setSize(i+x,i);
            try{
                Thread.sleep(10);
            }catch(Exception e){}
        }
        
    }
}
    

