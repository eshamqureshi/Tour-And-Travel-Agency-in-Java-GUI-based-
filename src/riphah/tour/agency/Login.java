/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riphah.tour.agency;

/**
 *
 * @author Qureshi Sab
 */


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class  Login extends JFrame implements ActionListener{

	private JPanel panel;
	private JTextField textField;
	private JPasswordField passwordField;
        private JButton b1,b2,b3;


	public Login() {
            
	setBackground(new Color(255, 255, 204));	
        setBounds(500, 250, 700, 400);
		
        panel = new JPanel();
	panel.setBackground(Color.WHITE);
	setContentPane(panel);                  //whole panal
	panel.setLayout(null);  // because creating own layout

	JLabel l1 = new JLabel("Username : ");
	l1.setBounds(124, 89, 95, 24);
	panel.add(l1);

	JLabel l2 = new JLabel("Password : ");
	l2.setBounds(124, 124, 95, 24);
	panel.add(l2);
        
        JLabel loginLabel = new JLabel("LOGIN");
        loginLabel.setForeground(new Color(0, 102, 204)); // Set the color you prefer
        loginLabel.setFont(new Font("Tahoma", Font.BOLD, 24)); // Set the font and size
        loginLabel.setBounds(210, 30, 150, 30); // Adjust the bounds accordingly
        panel.add(loginLabel);

	textField = new JTextField();
	textField.setBounds(210, 93, 157, 20);
	panel.add(textField);
	
	passwordField = new JPasswordField();
	passwordField.setBounds(210, 128, 157, 20);
	panel.add(passwordField);
        
        
        setBackground(new Color(255, 255, 204));
        setBounds(450, 250, 700, 400);

        
	
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icons/loginp.jpg")); // create image class obj then class loder func have method get system resourse
        Image i1 = c1.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        
        
        JLabel l6 = new JLabel(i2);
        l6.setBounds(0, 0,50, 50); // setting picc
        add(l6);
        
        
	b1 = new JButton("Login");
	b1.addActionListener(this);
                
	b1.setForeground(new Color(46, 139, 87));
	b1.setBackground(new Color(176, 224, 230));
	b1.setBounds(149, 181, 113, 25);
	panel.add(b1);
		
        b2 = new JButton("SignUp");
	b2.addActionListener(this);
	
	b2.setForeground(new Color(139, 69, 19));
	b2.setBackground(new Color(255, 235, 205));
	b2.setBounds(289, 181, 113, 25);
	panel.add(b2);

	b3 = new JButton("Forgot Password");
	b3.addActionListener(this);
	
        b3.setForeground(new Color(205, 92, 92));
	b3.setBackground(new Color(253, 245, 230));
	b3.setBounds(199, 231, 179, 25);
	panel.add(b3);

	JLabel l5 = new JLabel("Trouble in Login?");
	l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
	l5.setForeground(new Color(255, 0, 0));
	l5.setBounds(70, 235, 110, 20);
	panel.add(l5);

        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(131, 193, 230 ));
        panel2.setBounds(25, 0, 450, 340);               // color of signin panal
        panel.add(panel2);
        int xOffset = 80; // You can change this value based on your preference

        l1.setBounds(124 + xOffset, 89, 95, 24);
        l2.setBounds(124 + xOffset, 124, 95, 24);
        loginLabel.setBounds(210 + xOffset, 30, 150, 30);
        textField.setBounds(210 + xOffset, 93, 157, 20);
        passwordField.setBounds(210 + xOffset, 128, 157, 20);
        b1.setBounds(149 + xOffset, 181, 113, 25);
        b2.setBounds(289 + xOffset, 181, 113, 25);
        b3.setBounds(199 + xOffset, 231, 179, 25);
        l5.setBounds(70 + xOffset, 235, 110, 20);
        panel2.setBounds(25 + xOffset, 0, 450, 340);
        
	}
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == b1){
                Boolean status = false;
		try {
                    connect con = new connect();
                    String sql = "select * from account where username=? and password=?";
                    PreparedStatement st = con.c.prepareStatement(sql);

                    st.setString(1, textField.getText());
                    st.setString(2, passwordField.getText());

                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        this.setVisible(false);
                        new Loading(textField.getText()).setVisible(true);
                    } else
                    {
			JOptionPane.showMessageDialog(null, "Invalid Login or Password!");
                    WriteFile.writeLoginAttempt(textField.getText(), passwordField.getText());}
                       
		} catch (Exception e2) {
                    e2.printStackTrace();
		}
            }
            if(ae.getSource() == b2){
                setVisible(false);
		Signup su = new Signup();
		su.setVisible(true);
            }   
            if(ae.getSource() == b3){
                setVisible(false);
		ForgotPassword forgot = new ForgotPassword();
		forgot.setVisible(true);
            }
        }
        
        public static void main(String[] args) {
                new Login().setVisible(true);
	}}

