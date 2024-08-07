package riphah.tour.agency;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class BookHotel extends JFrame {
    private JPanel contentPane;
    JTextField t1, t2;
    Choice userChoice, hotelChoice, acChoice, foodChoice;
    JLabel l2, l3, l4, l5;
    private connect c;
private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BookHotel frame = new BookHotel("");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public BookHotel(String username) {
        setBounds(280, 140, 1100, 600);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookhotel.png"));
        Image i3 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(450, 100, 700, 300);
        add(la1);

        JLabel lblName = new JLabel("BOOK HOTEL");
        lblName.setFont(new Font("Yu Mincho", Font.BOLD, 20));
        lblName.setBounds(490, 11, 300, 53);
        contentPane.add(lblName);

        JLabel la2 = new JLabel("Select User:");
        la2.setBounds(35, 70, 200, 14);
        contentPane.add(la2);

        userChoice = new Choice();
        c = new connect();
        try {
            ResultSet rs = c.s.executeQuery("select username from customer");
            while (rs.next()) {
                userChoice.add(rs.getString("username"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        userChoice.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                try {
                    String selectedUsername = userChoice.getSelectedItem();
                    ResultSet rs = c.s.executeQuery("select Name, number, Email from customer where username = '"
                            + selectedUsername + "'");
                    if (rs.next()) {
                        l2.setText(rs.getString("name"));
                        l3.setText(rs.getString("number"));
                        l4.setText(rs.getString("email"));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        userChoice.setBounds(271, 70, 150, 20);
        contentPane.add(userChoice);

        JLabel lblId = new JLabel("Select Hotel :");
        lblId.setBounds(35, 110, 200, 14);
        contentPane.add(lblId);

        hotelChoice = new Choice();
        connect c = new connect();
        try {
            ResultSet rs = c.s.executeQuery("select * from hotels");
            while (rs.next()) {
                hotelChoice.add(rs.getString("Hotel_name"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        hotelChoice.setBounds(271, 110, 150, 30);
        add(hotelChoice);

        JLabel la3 = new JLabel("Total Persons");
        la3.setBounds(35, 150, 200, 14);
        contentPane.add(la3);

        t1 = new JTextField();
        t1.setText("0");
        t1.setBounds(271, 150, 150, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        JLabel la4 = new JLabel("Number of Days");
        la4.setBounds(35, 190, 200, 14);
        contentPane.add(la4);

        t2 = new JTextField();
        t2.setText("0");
        t2.setBounds(271, 190, 150, 20);
        contentPane.add(t2);
        t2.setColumns(10);

        JLabel la5 = new JLabel("AC / Non-AC");
        la5.setBounds(35, 230, 200, 14);
        contentPane.add(la5);

        acChoice = new Choice();
        acChoice.add("AC");
        acChoice.add("Non-AC");
        acChoice.setBounds(271, 230, 150, 30);
        add(acChoice);

        JLabel la6 = new JLabel("Food Included :");
        la6.setBounds(35, 270, 200, 14);
        contentPane.add(la6);

        foodChoice = new Choice();
        foodChoice.add("Yes");
        foodChoice.add("No");
        foodChoice.setBounds(271, 270, 150, 30);
        add(foodChoice);

        JLabel lbl1 = new JLabel("Name :");
        lbl1.setBounds(35, 310, 200, 14);
        contentPane.add(lbl1);

        l2 = new JLabel();
        l2.setBounds(271, 310, 200, 14);
        contentPane.add(l2);

        JLabel lbl2 = new JLabel("Number :");
        lbl2.setBounds(35, 350, 200, 14);
        contentPane.add(lbl2);

        l3 = new JLabel();
        l3.setBounds(271, 350, 200, 14);
        contentPane.add(l3);

        JLabel lbl3 = new JLabel("Email :");
        lbl3.setBounds(35, 390, 200, 14);
        contentPane.add(lbl3);

        l4 = new JLabel();
        l4.setBounds(271, 390, 200, 14);
        contentPane.add(l4);

        JLabel lblDeposite = new JLabel("Total Price :");
        lblDeposite.setBounds(35, 430, 200, 14);
        contentPane.add(lblDeposite);

        l5 = new JLabel();
        l5.setBounds(271, 430, 200, 14);
        l5.setForeground(Color.RED);
        contentPane.add(l5);

        JButton b1 = new JButton("Check Price");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                connect c = new connect();

                try {
                    String selectedHotel = hotelChoice.getSelectedItem();
                    String q1 = "select * from hotels where Hotel_name = '" + selectedHotel + "'";
                    ResultSet rs = c.s.executeQuery(q1);
                    if (rs.next()) {

                        int cost = Integer.parseInt(rs.getString("cost_per_day"));
                        int food = Integer.parseInt(rs.getString("food_charges"));
                        int ac = Integer.parseInt(rs.getString("ac_charges"));

                        int persons = Integer.parseInt(t1.getText());
                        int days = Integer.parseInt(t2.getText());

                        String acprice = acChoice.getSelectedItem();
                        String foodprice = foodChoice.getSelectedItem();

                        if (persons * days > 0) {
                            int total = 0;
                            total += acprice.equals("AC") ? ac : 1;
                            total += foodprice.equals("Yes") ? food : 1;
                            total += cost;
                            total = total * persons * days;
                            l5.setText("Rs " + total);
                        }

                    }

                } catch (Exception ee) {
                    System.out.println(ee.getMessage());
                }
            }
        });
        b1.setBounds(50, 470, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        JButton btnNewButton = new JButton("Book");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                connect c = new connect();
            Client clint = new Client();
            clint.req();
                try {
                   String selectedHotel = hotelChoice.getSelectedItem();
                    
                   
                    String insertQuery = "INSERT INTO bookHotel (username, name, number, Email, selected_hotel, total_person, "
        + "number_of_days, AC_non, food, Total_price) VALUES ('" + userChoice.getSelectedItem() + "', '"
        + l2.getText() + "', '" + l3.getText() + "', '" + l4.getText() + "', '" + selectedHotel + "', '"
        + t1.getText() + "', '" + t2.getText() + "', '" + acChoice.getSelectedItem() + "', '"
        + foodChoice.getSelectedItem() + "', '" + l5.getText() + "')";
                    c.s.executeUpdate(insertQuery);
                    
                   

                    JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                    setVisible(false);
                } catch (Exception ee) {
                    System.out.println(ee.getMessage());
                }

            }
        });
        btnNewButton.setBounds(200, 470, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnExit.setBounds(350, 470, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(new Color(210, 210, 210));
    }
}
