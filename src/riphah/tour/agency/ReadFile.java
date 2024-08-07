/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riphah.tour.agency;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

/**
 *
 * @author Qureshi Sab
 */public class ReadFile extends JFrame  {

    private JTextArea textArea;

    public ReadFile() {
        setTitle("Login Attempts");
        setBounds(450, 250, 700, 400);
        setBackground(new Color(210, 210, 210));
        

        // Adding a JLabel for the red line
        JLabel titleLabel = new JLabel("Failed Login Attempts Data");
        titleLabel.setBounds(220, 20, 550, 30);
        titleLabel.setForeground(Color.RED);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        add(titleLabel);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteFile(); // Delete the file
            }
        });
        add(deleteButton);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the frame
            }
        });
        add(closeButton);

        setLayout(null);

        scrollPane.setBounds(70, 60, 550, 250);
        deleteButton.setBounds(190, 320, 120, 30);
        closeButton.setBounds(330, 320, 120, 30);

        readLoginAttempts();
    }

     private void readLoginAttempts() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("login_attempts.bin"))) {
            while (true) {
                try {
                    LoginAttempt loginAttempt = (LoginAttempt) objectInputStream.readObject();
                    textArea.append(loginAttempt.toString());
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            textArea.setText("File does not exist or cannot be read.");
        }
    }


    private void deleteFile() {
        File file = new File("login_attempts.bin");
        if (file.exists()) {
            if (file.delete()) {
                textArea.setText("File deleted successfully.");
            } else {
                textArea.setText("Error deleting the file.");
            }
        } else {
            textArea.setText("File does not exist.");
        }
    }

    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        readFile.setVisible(true);
    }
}