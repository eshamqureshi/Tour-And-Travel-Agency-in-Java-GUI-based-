package riphah.tour.agency;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewPackage extends JFrame {
    private JPanel contentPane;
    private Choice userChoice;
    private JLabel l1, l2, l3, l4, l5, l6, l7;
    private connect c;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewPackage frame = new ViewPackage("");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ViewPackage(String username) {
        setBounds(400, 220, 850, 450);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(450, 40, 350, 350);
        add(la1);

        JLabel lblName = new JLabel("VIEW PACKAGE DETAILS");
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblName.setBounds(88, 11, 350, 53);
        contentPane.add(lblName);

        JLabel lb3 = new JLabel("Select User:");
        lb3.setBounds(35, 70, 200, 14);
        contentPane.add(lb3);

        userChoice = new Choice();
        userChoice.setBounds(271, 70, 150, 20);
        contentPane.add(userChoice);

        c = new connect();
        try {
            ResultSet rs = c.s.executeQuery("select username from bookPackage");
            while (rs.next()) {
                userChoice.add(rs.getString("username"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        l1 = new JLabel();
        l1.setBounds(271, 70, 200, 14);
        contentPane.add(l1);

        JLabel lblId = new JLabel("Package :");
        lblId.setBounds(35, 110, 200, 14);
        contentPane.add(lblId);

        l2 = new JLabel();
        l2.setBounds(271, 110, 200, 14);
        contentPane.add(l2);

        JLabel lb2 = new JLabel("Number of Persons :");
        lb2.setBounds(35, 150, 200, 14);
        contentPane.add(lb2);

        l3 = new JLabel();
        l3.setBounds(271, 150, 200, 14);
        contentPane.add(l3);

        JLabel lblName_1 = new JLabel("Name :");
        lblName_1.setBounds(35, 190, 200, 14);
        contentPane.add(lblName_1);

        l4 = new JLabel();
        l4.setBounds(271, 190, 200, 14);
        contentPane.add(l4);

        JLabel lblGender = new JLabel("Number :");
        lblGender.setBounds(35, 230, 200, 14);
        contentPane.add(lblGender);

        l5 = new JLabel();
        l5.setBounds(271, 230, 200, 14);
        contentPane.add(l5);

        JLabel lblCountry = new JLabel("Email :");
        lblCountry.setBounds(35, 270, 200, 14);
        contentPane.add(lblCountry);

        l6 = new JLabel();
        l6.setBounds(271, 270, 200, 14);
        contentPane.add(l6);

        JLabel lblReserveRoomNumber = new JLabel("Price :");
        lblReserveRoomNumber.setBounds(35, 310, 200, 14);
        contentPane.add(lblReserveRoomNumber);

        l7 = new JLabel();
        l7.setBounds(271, 310, 200, 14);
        contentPane.add(l7);

        userChoice.addItemListener(e -> {
    try {
        String selectedUsername = userChoice.getSelectedItem();
        ResultSet rs = c.s.executeQuery("select * from bookPackage where username = '" + selectedUsername + "'");
        if (rs.next()) {
            l1.setText(rs.getString(1));
            l2.setText(rs.getString(2));
            l3.setText(rs.getString(3));
            l4.setText(rs.getString(4));
            l5.setText(rs.getString(5));
            l6.setText(rs.getString(6));
            l7.setText(rs.getString(7));
        }
        rs.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
});


        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnExit.setBounds(160, 350, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(new Color(210,210,210));
    }
}
