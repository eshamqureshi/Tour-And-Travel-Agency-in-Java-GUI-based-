/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riphah.tour.agency;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

// Observer interface for multicast delegate
interface PageChangeObserver {
    void onPageChanged(int currentPage);
}

// Subject class that notifies observers when the page changes
class PageChangeSubject {
    private List<PageChangeObserver> observers = new ArrayList<>();

    public void addObserver(PageChangeObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(PageChangeObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(int currentPage) {
        for (PageChangeObserver observer : observers) {
            observer.onPageChanged(currentPage);
        }
    }
}

public class ViewCustomers extends JFrame {
    private static final int ROWS_PER_PAGE = 10;
    private int currentPage = 1;

    private JPanel contentPane;
    private JTable table;
    private JButton btnNext;
    private JButton btnPrevious;

    // Subject for page change events
    private PageChangeSubject pageChangeSubject = new PageChangeSubject();

    public ViewCustomers() {
        setBounds(350, 90, 900, 680);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        table = new JTable();
        table.setBackground(new Color(210, 210, 210));
        contentPane.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        btnPrevious = new JButton("Previous");
        btnPrevious.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (hasPreviousPage()) {
                    currentPage--;
                    updateTableData();
                    notifyPageChange();
                }
            }
        });
        btnPrevious.setBackground(Color.BLACK);
        btnPrevious.setForeground(Color.WHITE);
        buttonPanel.add(btnPrevious);

        btnNext = new JButton("Next");
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (hasNextPage()) {
                    currentPage++;
                    updateTableData();
                    notifyPageChange();
                }
            }
        });
        btnNext.setBackground(Color.BLACK);
        btnNext.setForeground(Color.WHITE);
        buttonPanel.add(btnNext);

        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        updateTableData();
    }

    // Method to add an observer for page change events
    public void addPageChangeObserver(PageChangeObserver observer) {
        pageChangeSubject.addObserver(observer);
    }

    // Method to remove an observer for page change events
    public void removePageChangeObserver(PageChangeObserver observer) {
        pageChangeSubject.removeObserver(observer);
    }

    // Method to notify all observers when the page changes
    private void notifyPageChange() {
        pageChangeSubject.notifyObservers(currentPage);
    }

    private boolean hasNextPage() {
        try {
            connect c = new connect();
            int rowCount = getRowCount(c);
            return (currentPage * ROWS_PER_PAGE) < rowCount;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean hasPreviousPage() {
        return currentPage > 1;
    }

    private int getRowCount(connect connection) throws SQLException {
        String countQuery = "SELECT COUNT(*) FROM customer";
        ResultSet countResult = connection.s.executeQuery(countQuery);
        if (countResult.next()) {
            return countResult.getInt(1);
        }
        return 0;
    }

    private void updateTableData() {
        int offset = (currentPage - 1) * ROWS_PER_PAGE;
        try {
            connect c = new connect();
            String displayCustomersql = "SELECT * FROM customer LIMIT " + offset + ", " + ROWS_PER_PAGE;
            ResultSet rs = c.s.executeQuery(displayCustomersql);

            int columnCount = rs.getMetaData().getColumnCount();

            DefaultTableModel model = new DefaultTableModel();
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(rs.getMetaData().getColumnName(i));
            }

            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = rs.getObject(i);
                }
                model.addRow(rowData);
            }

            table.setModel(model);

            btnNext.setEnabled(hasNextPage());
            btnPrevious.setEnabled(hasPreviousPage());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewCustomers frame = new ViewCustomers();
                    frame.setVisible(true);

                    // Example of adding an observer for page change events
                    frame.addPageChangeObserver(new PageChangeObserver() {
                        @Override
                        public void onPageChanged(int currentPage) {
                            System.out.println("Page changed to: " + currentPage);
                            // Add your logic here when the page changes
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
