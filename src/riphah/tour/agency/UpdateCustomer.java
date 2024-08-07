package riphah.tour.agency;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import javax.swing.*;

public class UpdateCustomer extends JFrame {

    connect c; // Declare an instance of the connect class
    Connection conn = null;
    PreparedStatement pst = null;
    private JPanel contentPane;
    Choice c1;

    private JTextField t2, t3, t4, t5, t6, t7, t8, t9;

    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UpdateCustomer frame = new UpdateCustomer("");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UpdateCustomer(String username) throws SQLException {
        c = new connect(); // Instantiate the connect class

        setBounds(380, 160, 850, 550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/customerupdate.png"));
        Image i3 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(550, 70, 200, 400);
        add(l1);

        
        JLabel lblName = new JLabel("UPDATE CUSTOMER DETAILS");
        lblName.setFont(new Font("Yu Mincho", Font.BOLD, 20));
        lblName.setBounds(270, 11, 300, 53);
        contentPane.add(lblName);

        JLabel l3 = new JLabel("Username :");
        l3.setBounds(35, 70, 200, 14);
        contentPane.add(l3);

        c1 = new Choice();
        connect c = new connect();
        try {
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                c1.add(rs.getString("username"));
            }
            rs.close();
        } catch (SQLException e) {
        }

        c1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                try {
                    String selectedUsername = c1.getSelectedItem();
                    ResultSet rs = c.s.executeQuery("select * from customer where username = '" + selectedUsername + "'");
                    if (rs.next()) {
                        t2.setText(rs.getString(2));
                        t3.setText(rs.getString(3));
                        t4.setText(rs.getString(4));
                        t5.setText(rs.getString(5));
                        t6.setText(rs.getString(6));
                        t7.setText(rs.getString(7));
                        t8.setText(rs.getString(8));
                        t9.setText(rs.getString(9));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        c1.setBounds(271, 70, 150, 20);
        contentPane.add(c1);

        t2 = new JTextField();
        t2.setBounds(271, 110, 150, 20);
        contentPane.add(t2);
        t2.setColumns(10);

        JLabel lblId = new JLabel("ID :");
        lblId.setBounds(35, 110, 200, 14);
        contentPane.add(lblId);

        t3 = new JTextField();
        t3.setBounds(271, 150, 150, 20);
        contentPane.add(t3);
        t3.setColumns(10);

        JLabel l2 = new JLabel("Number :");
        l2.setBounds(35, 150, 200, 14);
        contentPane.add(l2);

        t4 = new JTextField();
        t4.setBounds(271, 190, 150, 20);
        contentPane.add(t4);
        t4.setColumns(10);

        JLabel lblName_1 = new JLabel("Name :");
        lblName_1.setBounds(35, 190, 200, 14);
        contentPane.add(lblName_1);

        t5 = new JTextField();
        t5.setBounds(271, 230, 150, 20);
        contentPane.add(t5);
        t5.setColumns(10);

        JLabel lblGender = new JLabel("Gender :");
        lblGender.setBounds(35, 230, 200, 14);
        contentPane.add(lblGender);

        t6 = new JTextField();
        t6.setBounds(271, 270, 150, 20);
        contentPane.add(t6);
        t6.setColumns(10);

        JLabel lblCountry = new JLabel("Country :");
        lblCountry.setBounds(35, 270, 200, 14);
        contentPane.add(lblCountry);

        t7 = new JTextField();
        t7.setBounds(271, 310, 150, 20);
        contentPane.add(t7);
        t7.setColumns(10);

        JLabel lblReserveRoomNumber = new JLabel("Permanent Address :");
        lblReserveRoomNumber.setBounds(35, 310, 200, 14);
        contentPane.add(lblReserveRoomNumber);

        t8 = new JTextField();
        t8.setBounds(271, 350, 150, 20);
        contentPane.add(t8);
        t8.setColumns(10);

        JLabel lblCheckInStatus = new JLabel("Phone :");
        lblCheckInStatus.setBounds(35, 350, 200, 14);
        contentPane.add(lblCheckInStatus);

        JLabel email = new JLabel("Email :");
        email.setBounds(35, 390, 200, 14);
        contentPane.add(email);

        t9 = new JTextField();
        t9.setBounds(271, 390, 150, 20);
        contentPane.add(t9);
        t9.setColumns(10);

        JButton btnNewButton = new JButton("Update");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String s1 = c1.getSelectedItem();
                    String s2 = t2.getText();
                    String s3 = t3.getText();
                    String s4 = t4.getText();
                    String s5 = t5.getText();
                    String s6 = t6.getText();
                    String s7 = t7.getText();
                    String s8 = t8.getText();
                    String s9 = t9.getText();

                    String q1 = "UPDATE customer SET id='" + s2 + "', Number='" + s3 + "', Name='" + s4 + "', Gender='"
                            + s5 + "', Country='" + s6 + "', Address='" + s7 + "', Phone='" + s8 + "', Email='" + s9
                            + "' where username = '" + username + "'";
                    c.s.executeUpdate(q1);

                    // Use PreparedStatement for better practice
                    String updateQuery = "UPDATE customer SET id=?, Number=?, Name=?, Gender=?, Country=?, Address=?, Phone=?, Email=? WHERE username=?";
                    pst = c.c.prepareStatement(updateQuery);
                    pst.setString(1, s2);
                    pst.setString(2, s3);
                    pst.setString(3, s4);
                    pst.setString(4, s5);
                    pst.setString(5, s6);
                    pst.setString(6, s7);
                    pst.setString(7, s8);
                    pst.setString(8, s9);
                    pst.setString(9, s1);
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Customer Detail Updated Successfully");
                    setVisible(false);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (NumberFormatException s) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid Number");
                }
            }
        });

        btnNewButton.setBounds(100, 450, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnExit.setBounds(260, 450, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(new Color(210, 210, 210));
    }
}