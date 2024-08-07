package riphah.tour.agency;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewTicket extends Frame implements ActionListener {

    Label l1, l2, l3, l4, l5, l6, l7, l8, l9;
    Label t1, t2, t3, t4, t5, t6, t7, t8, t9;
    Button b1, b2, b3, b4, b5;
    Frame f;
    private connect c;
    String[] usernames = {"Esham_x92", "Abdullah070", "Haider_444", "Ahmed_AK", "Saad_362", "Ali_23", "Ahmed_AK"};
    int i = 0;

    public ViewTicket(String username) {
        f = new Frame("Travel Management System - View Tickets");
        f.setVisible(true);
        f.setSize(410, 600);
        f.setLocation(440, 20);
        f.setLayout(null);

        l1 = new Label("Customer id");
        l1.setBounds(50, 50, 150, 30);
        f.add(l1);

        t1 = new Label();
        t1.setBounds(220, 50, 150, 30);
        f.add(t1);

        l2 = new Label("Customer Name");
        l2.setBounds(50, 90, 150, 30);
        f.add(l2);

        t2 = new Label();
        t2.setBounds(220, 90, 150, 30);
        f.add(t2);

        l3 = new Label("Destination");
        l3.setBounds(50, 130, 150, 30);
        f.add(l3);

        t3 = new Label();
        t3.setBounds(220, 130, 150, 30);
        f.add(t3);

        l4 = new Label("Flight Name");
        l4.setBounds(50, 170, 150, 30);
        f.add(l4);

        t4 = new Label();
        t4.setBounds(220, 170, 150, 30);
        f.add(t4);

        l5 = new Label("Price");
        l5.setBounds(50, 210, 150, 30);
        f.add(l5);

        t5 = new Label();
        t5.setBounds(220, 210, 150, 30);
        f.add(t5);

        l6 = new Label("Number of person");
        l6.setBounds(50, 250, 150, 30);
        f.add(l6);

        t6 = new Label();
        t6.setBounds(220, 250, 150, 30);
        f.add(t6);

        l7 = new Label("From Date");
        l7.setBounds(50, 290, 150, 30);
        f.add(l7);

        t7 = new Label();
        t7.setBounds(220, 290, 150, 30);
        f.add(t7);

        l8 = new Label("To Date");
        l8.setBounds(50, 330, 150, 30);
        f.add(l8);

        t8 = new Label();
        t8.setBounds(220, 330, 150, 30);
        f.add(t8);

        l9 = new Label("Total Price");
        l9.setBounds(50, 370, 150, 30);
        f.add(l9);

        t9 = new Label();
        t9.setBounds(220, 370, 150, 30);
        f.add(t9);

        b1 = new Button("First");
        b1.setBounds(50, 410, 100, 30);
        f.add(b1);
        b1.addActionListener(this);

        b2 = new Button("Next");
        b2.setBounds(220, 410, 100, 30);
        f.add(b2);
        b2.addActionListener(this);

        b3 = new Button("Previous");
        b3.setBounds(50, 450, 100, 30);
        f.add(b3);
        b3.addActionListener(this);

        b4 = new Button("Last");
        b4.setBounds(220, 450, 100, 30);
        f.add(b4);
        b4.addActionListener(this);

        b5 = new Button("Cancel");
        b5.setBounds(140, 490, 100, 30);
        f.add(b5);
        b5.addActionListener(this);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        c = new connect();
        try {
            ResultSet rs = c.s.executeQuery("SELECT * FROM viewticket WHERE name = '" + usernames[i] + "'");
            if (rs.next()) {
                t1.setText(rs.getString("id"));
                t2.setText(rs.getString("name"));
                t3.setText(rs.getString("destination"));
                t4.setText(rs.getString("flight_name"));
                t5.setText(rs.getString("price"));
                t6.setText(rs.getString("number_of_person"));
                t7.setText(rs.getString("from_date"));
                t8.setText(rs.getString("to_date"));
                t9.setText(rs.getString("total_price"));
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        c = new connect();

        if (ae.getSource() == b5) {
            i = 0;
            f.setVisible(false);
        }

        if (ae.getSource() == b4) {
            i = 6;
        }

        if (ae.getSource() == b1) {
            i = 0;
        }

        if (ae.getSource() == b2) {
            i++;
        }

        if (ae.getSource() == b3) {
            i--;
        }
       
    }

    public static void main(String args[]) {
        ViewTicket vt = new ViewTicket("Esham_x92");
    }
}
