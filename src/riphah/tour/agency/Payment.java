/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riphah.tour.agency;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author Qureshi Sab
 */
public class Payment extends JFrame{
    
    public Payment(){
        
        setLayout(null);
        setBounds(420, 150, 800, 600);
        
        JLabel label=new JLabel("Pay using JazzCash");
        label.setFont(new Font("Raleway", Font.BOLD, 40));
        label.setBounds(50, 20, 350, 45);
        add(label);
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/payment.png"));
        Image i8 = i7.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel l4 = new JLabel(i9);
        l4.setBounds(0, 150, 800, 600);
        add(l4);
        
        JButton pay = new JButton("Pay");
        pay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new transaction().setVisible(true);
            }
        });
        pay.setBounds(460, 20, 80, 40);
        add(pay);
    
        JButton back=new JButton("Back");
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        back.setBounds(550, 20, 80, 40);
        add(back);
        
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    public static void main(String[] args){
        new Payment().setVisible(true);
    }
    
}
