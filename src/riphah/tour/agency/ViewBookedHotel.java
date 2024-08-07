package riphah.tour.agency;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ViewBookedHotel extends JFrame {
    private JPanel contentPane;
    private Choice userChoice;
    private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
    private connect c;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewBookedHotel frame = new ViewBookedHotel("");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ViewBookedHotel(String username) {
        setBounds(380, 150, 850, 600);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/package.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(450, 50, 350, 350);
        add(la1);

        JLabel lblName = new JLabel("VIEW BOOKED HOTEL DETAILS");
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblName.setBounds(88, 11, 350, 53);
        contentPane.add(lblName);

        JLabel lb3 = new JLabel("Select User:");
        lb3.setBounds(35, 70, 200, 14);
        contentPane.add(lb3);

        userChoice = new Choice();
        c = new connect();
        try {
            ResultSet rs = c.s.executeQuery("select username from bookHotel");
            while (rs.next()) {
                userChoice.add(rs.getString("username"));
            }
            rs.close();
        } catch (SQLException e) {}

        userChoice.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                try {
                    String selectedUsername = userChoice.getSelectedItem();
                    ResultSet rs = c.s.executeQuery("select * from bookHotel where username = '" + selectedUsername + "'");
                    if (rs.next()) {
                        l1.setText(rs.getString("username"));
                        l2.setText(rs.getString("name"));
                        l3.setText(rs.getString("number"));
                        l4.setText(rs.getString("Email"));
                        l5.setText(rs.getString("selected_hotel"));
                        l6.setText(rs.getString("total_person"));
                        l7.setText(rs.getString("number_of_days"));
                        l8.setText(rs.getString("AC_non"));
                        l9.setText(rs.getString("food"));
                        l10.setText(rs.getString("Total_price"));
                    }
                    rs.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        userChoice.setBounds(271, 70, 150, 20);
        contentPane.add(userChoice);

        

        JLabel lblId = new JLabel("username :");
        lblId.setBounds(35, 110, 200, 14);
        contentPane.add(lblId);

        l1 = new JLabel();
        l1.setBounds(271, 110, 200, 14);
        contentPane.add(l1);

        JLabel lb2 = new JLabel("Name :");
        lb2.setBounds(35, 150, 200, 14);
        contentPane.add(lb2);

        l2 = new JLabel();
        l2.setBounds(271, 150, 200, 14);
        contentPane.add(l2);

        JLabel lblName_1 = new JLabel("Number :");
        lblName_1.setBounds(35, 190, 200, 14);
        contentPane.add(lblName_1);
        
        l3 = new JLabel();
        l3.setBounds(271, 190, 200, 14);
        contentPane.add(l3);
        

        JLabel lblGender = new JLabel("Email :");
        lblGender.setBounds(35, 230, 200, 14);
        contentPane.add(lblGender);

       l4 = new JLabel();
        l4.setBounds(271, 230, 200, 14);
        contentPane.add(l4);

        JLabel lblCountry = new JLabel("Hotel Name :");
        lblCountry.setBounds(35, 270, 200, 14);
        contentPane.add(lblCountry);

        l5 = new JLabel();
        l5.setBounds(271, 270, 200, 14);
        contentPane.add(l5);

        JLabel lblReserveRoomNumber = new JLabel("Number of Person :");
        lblReserveRoomNumber.setBounds(35, 310, 200, 14);
        contentPane.add(lblReserveRoomNumber);

         l6 = new JLabel();
        l6.setBounds(271, 310, 200, 14);
        contentPane.add(l6);

        JLabel lblCheckInStatus = new JLabel("Day To Stay :");
        lblCheckInStatus.setBounds(35, 350, 200, 14);
        contentPane.add(lblCheckInStatus);
        
        l7 = new JLabel();
        l7.setBounds(271, 350, 200, 14);
        contentPane.add(l7);

       

        JLabel lblDeposite = new JLabel("AC/NON-AC :");
        lblDeposite.setBounds(35, 390, 200, 14);
        contentPane.add(lblDeposite);
        
         l8 = new JLabel();
        l8.setBounds(271, 390, 200, 14);
        contentPane.add(l8);

       

        JLabel la2 = new JLabel("Food includes :");
        la2.setBounds(35, 470, 200, 14);
        contentPane.add(la2);
        
         l9 = new JLabel();
        l9.setBounds(271, 430, 200, 14);
        contentPane.add(l9);
        
          JLabel la3 = new JLabel("Cost :");
        la3.setBounds(35, 430, 200, 14);
        contentPane.add(la3);

        l10 = new JLabel();
        l10.setBounds(271, 470, 200, 14);
        contentPane.add(l10);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnExit.setBounds(160, 510, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(new Color(210,210,210));
    }
}
