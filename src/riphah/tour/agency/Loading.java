/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riphah.tour.agency;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


/**
 *
 * @author Qureshi Sab
 */
public class Loading extends JFrame implements Runnable {

	private JPanel contentPane;
	private JProgressBar progressBar;
	Connection conn;
        String username;
	int s;
	Thread th;

	public static void main(String[] args) {
            new Loading("").setVisible(true);
	}

	public void setUploading() {
            setVisible(false);
            th.start();
	}

	public void run() {
            try {
                for (int i = 0; i < 200; i++) {
                    s = s + 1;
                    int m = progressBar.getMaximum();
                    int v = progressBar.getValue();
                    if (v < m) {
                        progressBar.setValue(progressBar.getValue() + 1);
                    } else {
                        i = 201;
                        setVisible(false);
                        new Home(username).setVisible(true);
                    }
                    Thread.sleep(50);
                }
            } catch (Exception e) {
		e.printStackTrace();
            }
	}

	public Loading(String username) {
            this.username = username;
            th = new Thread((Runnable) this);

            setBounds(500, 250, 600, 400);
            contentPane = new JPanel();
            contentPane.setBackground(Color.LIGHT_GRAY);  /// outer 
            setContentPane(contentPane);
            contentPane.setLayout(null);
            
       

            JLabel lbllibraryManagement = new JLabel("Riphah Tour and Travel Agency ");
            lbllibraryManagement.setForeground (Color.blue);
            lbllibraryManagement.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
            lbllibraryManagement.setBounds(50, 46, 700, 35);
            contentPane.add(lbllibraryManagement);
	
            progressBar = new JProgressBar();
            progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
            progressBar.setStringPainted(true);
            progressBar.setBounds(130, 130, 300, 25);
            contentPane.add(progressBar);

            JLabel lblNewLabel_2 = new JLabel("     Please Wait....");
            lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
            lblNewLabel_2.setForeground(new Color(160, 82, 45));
            lblNewLabel_2.setBounds(200, 165, 150, 30);
            contentPane.add(lblNewLabel_2);

            JPanel panel = new JPanel();
            panel.setBackground(Color.LIGHT_GRAY);
            panel.setBounds(0, 280, 600, 350);
            contentPane.add(panel);
            
            
            
           ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icons/loading.jpeg")); // create image class obj then class loder func have method get system resourse
        Image i1 = c1.getImage().getScaledInstance(700, 120,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        
        
        JLabel l6 = new JLabel(i2);
         l6.setBounds(250, 250, 148, 20); // setting picc
        panel.add(l6);
            
            
              
            setUndecorated(true);
            setUploading();
	}
}