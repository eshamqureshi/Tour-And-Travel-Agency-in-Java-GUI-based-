/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riphah.tour.agency;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.border.*;

interface SignupListener {
    void onSignup(String username, String name, String password, String securityQuestion, String answer);
}

public class Signup extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JButton b1, b2;
    private JComboBox comboBox;

    private final ArrayList<SignupListener> signupListeners = new ArrayList<>(); // Change to ArrayList

    public void addSignupListener(SignupListener listener) {
        signupListeners.add(listener);
    }

    public void removeSignupListener(SignupListener listener) {
        signupListeners.remove(listener);
    }

    private void notifySignupListeners(String username, String name, String password, String securityQuestion, String answer) {
        for (SignupListener listener : signupListeners) {
            listener.onSignup(username, name, password, securityQuestion, answer);
        }
    }

    public static void main(String[] args) {
        Signup signup = new Signup();
        signup.setVisible(true);

        // Example of adding a signup listener
        signup.addSignupListener((username, name, password, securityQuestion, answer) -> {
            // Handle the signup event, e.g., perform additional actions
            System.out.println("User signed up: " + username);
        });
    }

    public Signup() {
        setBounds(450, 250, 700, 406);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE); // for the whole pane
        contentPane.setLayout(null);

	JLabel lblUsername = new JLabel("Username :");
	lblUsername.setForeground(Color.DARK_GRAY);
	lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblUsername.setBounds(85, 86, 92, 26);
	contentPane.add(lblUsername);

	JLabel lblName = new JLabel("Name :");
	lblName.setForeground(Color.DARK_GRAY);
	lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblName.setBounds(85, 123, 92, 26);
	contentPane.add(lblName);

	JLabel lblPassword = new JLabel("Password :");
	lblPassword.setForeground(Color.DARK_GRAY);
	lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblPassword.setBounds(85, 160, 92, 26);
	contentPane.add(lblPassword);

	JLabel lblAnswer = new JLabel("Answer :");
	lblAnswer.setForeground(Color.DARK_GRAY);
	lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblAnswer.setBounds(85, 234, 92, 26);
	contentPane.add(lblAnswer);

	comboBox = new JComboBox();
	comboBox.setModel(new DefaultComboBoxModel(new String[] { "Your NickName?", "Your Lucky Number?",
			"Your child SuperHero?", "Your childhood Name ?" }));
	comboBox.setBounds(230, 202, 148, 20);
	contentPane.add(comboBox);

	JLabel lblSecurityQuestion = new JLabel("Security Question :");
	lblSecurityQuestion.setForeground(Color.DARK_GRAY);
	lblSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblSecurityQuestion.setBounds(85, 197, 140, 26);
	contentPane.add(lblSecurityQuestion);
        
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup2.png"));
        Image i1 = c1.getImage().getScaledInstance(200, 150,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);   //convert image obj to icone obj becaue lable only accept icone obj
        
        JLabel l6 = new JLabel(i2);
        l6.setBounds(460, 70, 200, 200);
        add(l6);                           //pic

        textField = new JTextField();
	textField.setBounds(230, 91, 148, 20);
	contentPane.add(textField);
	textField.setColumns(10);

	textField_1 = new JTextField();
	textField_1.setColumns(10);
	textField_1.setBounds(230, 128, 148, 20);
	contentPane.add(textField_1);

        textField_2 = new JTextField();
	textField_2.setColumns(10);
	textField_2.setBounds(230, 165, 148, 20);
	contentPane.add(textField_2);

	textField_3 = new JTextField();
	textField_3.setColumns(10);
	textField_3.setBounds(230, 239, 148, 20);
	contentPane.add(textField_3);

	b1 = new JButton("Create");
	b1.addActionListener(this);
	b1.setFont(new Font("Tahoma", Font.BOLD, 13));
	b1.setBounds(140, 289, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setFont(new Font("Tahoma", Font.BOLD, 13));
	b2.setBounds(300, 289, 100, 30);
	b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);

	JPanel panel = new JPanel();
	panel.setForeground(new Color(34, 139, 34));
	panel.setBorder(new TitledBorder(new LineBorder(new Color(131, 193, 240), 2), "Create New Account",
			TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
	panel.setBounds(25, 5, 430, 330);
        panel.setBackground(new Color(131, 193, 230));
	contentPane.add(panel);
    }
    
    public void actionPerformed(ActionEvent ae) {
        try {
            connect con = new connect();

            if (ae.getSource() == b1) {
                String sql = "insert into account(username, name, password, question, answer) values(?, ?, ?, ?, ?)";

                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, textField.getText());
                st.setString(2, textField_1.getText());
                st.setString(3, textField_2.getText());
                st.setString(4, (String) comboBox.getSelectedItem());
                st.setString(5, textField_3.getText());

                int i = st.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Account Created Successfully ");
                    // Notify listeners
                    notifySignupListeners(
                            textField.getText(),
                            textField_1.getText(),
                            textField_2.getText(),
                            (String) comboBox.getSelectedItem(),
                            textField_3.getText()
                    );
                }

                textField.setText("");
                textField_1.setText("");
                textField_2.setText("");
                textField_3.setText("");
            }
            if (ae.getSource() == b2) {
                this.setVisible(false);
                new Login().setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}