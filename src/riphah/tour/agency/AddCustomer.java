/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riphah.tour.agency;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import java.util.Arrays;

public class AddCustomer<T> extends JFrame {
    private Connection conn = null;
    private PreparedStatement pst = null;
    private JPanel contentPane;
    private JTextField t1, t2, t3, t5, t6, t7, t8;
    private JComboBox<String> comboBox;
    private JRadioButton r1, r2;

    public AddCustomer(T username) throws SQLException {
        setBounds(400, 160, 850, 550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
                
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer1.jpg"));
        Image i3 = i1.getImage().getScaledInstance(450, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(450, 50, 450, 420);
        add(l1);
		
		JLabel lblName = new JLabel("ADD NEW CUSTOMER");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(300, 11, 260, 53);
		contentPane.add(lblName);
                
                JLabel l3 = new JLabel("Username :");
		l3.setBounds(35, 70, 200, 14);
		contentPane.add(l3);
                
                t7 = new JTextField();
		t7.setBounds(271, 70, 150, 20);
		contentPane.add(t7);
		t7.setColumns(10);
                
                JLabel lblId = new JLabel("ID :");
		lblId.setBounds(35, 110, 200, 14);
		contentPane.add(lblId);
                
                comboBox = new JComboBox(new String[] {"Passport", "CNIC", "Voter Id", "Driving license"});
		comboBox.setBounds(271, 110, 150, 20);
		contentPane.add(comboBox);
                
                JLabel l2 = new JLabel("Cell No :");
		l2.setBounds(35, 150, 200, 14);
		contentPane.add(l2);
                
                t1 = new JTextField();
		t1.setBounds(271, 150, 150, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JLabel lblName_1 = new JLabel("Name :");
		lblName_1.setBounds(35, 190, 200, 14);
		contentPane.add(lblName_1);
		
		t2 = new JTextField();
		t2.setBounds(271, 190, 150, 20);
		contentPane.add(t2);
		t2.setColumns(10);

                
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(35, 230, 200, 14);
		contentPane.add(lblGender);
                
                r1 = new JRadioButton("Male");
                r1.setFont(new Font("Raleway", Font.BOLD, 14));
                r1.setBackground(new Color (210,210,210));
                r1.setBounds(271, 230, 80, 12);
                add(r1);
                
                r2 = new JRadioButton("Female");
                r2.setFont(new Font("Raleway", Font.BOLD, 14));
                r2.setBackground(new Color (210,210,210));
                r2.setBounds(350, 230, 100, 12);
		add(r2);
                
                ButtonGroup genderGroup = new ButtonGroup();
                genderGroup.add(r1);
                genderGroup.add(r2);

               // radio = r1.isSelected() ? "Male" : "Female";
		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setBounds(35, 270, 200, 14);
		contentPane.add(lblCountry);
                
                t3 = new JTextField();
		t3.setBounds(271, 270, 150, 20);
		contentPane.add(t3);
		t3.setColumns(10);
		
		JLabel lblReserveRoomNumber = new JLabel("Permanent Address :");
		lblReserveRoomNumber.setBounds(35, 310, 200, 14);
		contentPane.add(lblReserveRoomNumber);
                
                t5 = new JTextField();
		t5.setBounds(271, 310, 150, 20);
		contentPane.add(t5);
		t5.setColumns(10);
           	
		JLabel lblCheckInStatus = new JLabel("Phone :");
		lblCheckInStatus.setBounds(35, 350, 200, 14);
		contentPane.add(lblCheckInStatus);
                
                t6 = new JTextField();
		t6.setBounds(271, 350, 150, 20);
		contentPane.add(t6);
		t6.setColumns(10);
		
		JLabel lblDeposite = new JLabel("Email :");
		lblDeposite.setBounds(35, 390, 200, 14);
		contentPane.add(lblDeposite);
		
		t8 = new JTextField();
		t8.setBounds(271, 390, 150, 20);
		contentPane.add(t8);
		t8.setColumns(10);
		
		
                try{
                    connect c = new connect();
                    ResultSet rs = c.s.executeQuery("select * from account where username = '"+username+"'");
                    while(rs.next()){
                        t7.setText(rs.getString("username"));  
                        t2.setText(rs.getString("name"));
                    }
                }catch(Exception e){ }
		
		

		 JButton btnNewButton = new JButton("Add");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                connect c = new connect();
                String radio = null;

                if (r1.isSelected()) {
                    radio = "Male";
                } else if (r2.isSelected()) {
                    radio = "Female";
                }

                try {
                    T s9 = username;
                    String s1 = comboBox.getSelectedItem().toString();
                    String s2 = t1.getText();
                    String s3 = t2.getText();
                    String s4 = radio;
                    String s5 = t3.getText();
                    String s7 = t5.getText();
                    String s8 = t6.getText();
                    String s10 = t8.getText();

                    // Example of using Customer with nested generics
                    Integer[] idArray = {1, 2, 3}; // Replace Integer with actual type for ID
                    java.util.List<String> nameList = Arrays.asList("John", "Doe"); // Replace String with actual type for name
                    Double additionalInfo = 10.5; // Replace Double with actual type for additional info

                    Customer<Integer[], java.util.List<String>, Double> customer = new Customer<Integer[], java.util.List<String>, Double>(idArray, nameList, additionalInfo);


                    String q1 = "insert into customer values('" + s9 + "','" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s7 + "','" + s8 + "','" + s10 + "')";
                    c.s.executeUpdate(q1);

                    JOptionPane.showMessageDialog(null, "Customer Added Successfully");
                    setVisible(false);
                } catch (SQLException e1) {
                    System.out.println(e1.getMessage());
                } catch (NumberFormatException s) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid Number");
                }
            }
        });

		btnNewButton.setBounds(100, 430, 120, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            setVisible(false);
			}
		}); 
		btnExit.setBounds(260, 430, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
                getContentPane().setBackground(new Color (210,210,210));
	}
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddCustomer<String> frame = new AddCustomer<>("exampleUsername");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
    



