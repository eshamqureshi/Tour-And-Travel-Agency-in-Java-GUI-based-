package riphah.tour.agency;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import javax.swing.*;

public class BookPackage extends JFrame {
    private JPanel contentPane;
    JTextField t1;
    Choice c1, c2, c3;
    JLabel lblIdType, lblNumber, lblPhone, lblTotalPrice;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BookPackage frame = new BookPackage("");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public BookPackage(String username) {
        setBounds(260, 190, 1100, 500);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpakages.jpg"));
        Image i3 = i1.getImage().getScaledInstance(450, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(450, 70, 700, 300);
        add(la1);

        JLabel lblName = new JLabel("BOOK PACKAGE");
        lblName.setFont(new Font("Yu Mincho", Font.BOLD, 20));
        lblName.setBounds(480, 11, 300, 53);
        contentPane.add(lblName);

        JLabel la2 = new JLabel("Select User:");
        la2.setBounds(35, 70, 200, 14);
        contentPane.add(la2);

        c1 = new Choice();
        connect c = new connect();
        try {
            ResultSet rs = c.s.executeQuery("select username from customer");
            while (rs.next()) {
                c1.add(rs.getString("username"));
            }
            rs.close();
        } catch (SQLException e) {}

        c1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                try {
                    String selectedUsername = c1.getSelectedItem();
                    ResultSet rs = c.s.executeQuery("select Name, number, Email from customer where username = '" + selectedUsername + "'");
                    if (rs.next()) {
                        lblIdType.setText(rs.getString("name"));
                        lblNumber.setText(rs.getString("number"));
                        lblPhone.setText(rs.getString("email"));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        c1.setBounds(271, 70, 150, 20);
        contentPane.add(c1);

        JLabel lblId = new JLabel("Select Package :");
        lblId.setBounds(35, 110, 200, 14);
        contentPane.add(lblId);

        c2 = new Choice();
        c2.add("Gold Package");
        c2.add("Silver Package");
        c2.add("Bronze Package");
        c2.setBounds(271, 110, 150, 30);
        add(c2);
        
        JLabel lbl1 = new JLabel("Name:");
		lbl1.setBounds(35, 190, 200, 14);
		contentPane.add(lbl1);
                
               
		
		JLabel lbl2 = new JLabel("Number :");
		lbl2.setBounds(35, 230, 200, 14);
		contentPane.add(lbl2);
                
              
           	
		JLabel lbl3 = new JLabel("Email :");
		lbl3.setBounds(35, 270, 200, 14);
		contentPane.add(lbl3);
                
             


        JLabel la3 = new JLabel("Total Persons");
        la3.setBounds(35, 150, 200, 14);
        contentPane.add(la3);

        t1 = new JTextField();
        t1.setText("0");
        t1.setBounds(271, 150, 150, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        lblIdType = new JLabel();
        lblIdType.setBounds(271, 190, 200, 14);
        contentPane.add(lblIdType);

        lblNumber = new JLabel();
        lblNumber.setBounds(271, 230, 200, 14);
        contentPane.add(lblNumber);

        lblPhone = new JLabel();
        lblPhone.setBounds(271, 270, 200, 14);
        contentPane.add(lblPhone);

        JLabel lblDeposite = new JLabel("Total Price :");
        lblDeposite.setBounds(35, 310, 200, 14);
        contentPane.add(lblDeposite);

        lblTotalPrice = new JLabel();
        lblTotalPrice.setBounds(271, 310, 200, 14);
        lblTotalPrice.setForeground(Color.RED);
        contentPane.add(lblTotalPrice);

        JButton btnNewButton = new JButton("Check Price");
        
        
        btnNewButton.addActionListener(e -> {     // lambda expression
    String p = c2.getSelectedItem();
    int cost = 0;
    if (p.equals("Gold Package")) {
        cost += 32000;
    }
    if (p.equals("Silver Package")) {
        cost += 25000;
    } else if (p.equals("Bronze Package")) {
        cost += 12000;
    }

    cost *= Integer.parseInt(t1.getText());
    lblTotalPrice.setText("Rs " + cost);
});
        btnNewButton.setBounds(50, 350, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        JButton btnBook = new JButton("Book");
        
        
        btnBook.addActionListener(new ActionListener() {// Anonymous ActionListener
            public void actionPerformed(ActionEvent e) {
                connect c = new connect();
                try {
                    String selectedUsername = c1.getSelectedItem();
                    String selectedPackage = c2.getSelectedItem();
                    String totalPersons = t1.getText();
                    String name = lblIdType.getText();
                    String number = lblNumber.getText();
                    String Email = lblPhone.getText();
                    String totalPrice = lblTotalPrice.getText();

                    String q1 = "insert into bookPackage values('" + selectedUsername + "', '" + selectedPackage + "', '" + totalPersons + "', '" + name + "', '" + number + "', '" + Email+ "', '" + totalPrice + "')";
                    c.s.executeUpdate(q1);

                    JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                    setVisible(false);
                } catch (Exception ee) {
                    System.out.println(ee.getMessage());
                }
            }
        });
        btnBook.setBounds(200, 350, 120, 30);
        btnBook.setBackground(Color.BLACK);
        btnBook.setForeground(Color.WHITE);
        contentPane.add(btnBook);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnExit.setBounds(350, 350, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(new Color(210, 210, 210));
    }
}
