/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riphah.tour.agency;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Qureshi Sab
 */
public class transaction extends JFrame{
    transaction(){
        JEditorPane j = new JEditorPane();
        j.setEditable(false);   

        try {
            j.setPage("https://www.jazzcash.com.pk/jazzcash-business-app/");
        }catch (Exception e) {
             
            j.setContentType("text/html");
            j.setText("<html>"
                    + "<h1>"
                    + "Could not load"
                    + "</h1>"
                    + "<p>Try to reconnect to the internet and reload</p></html"
                    + "");
        } 

        JScrollPane scrollPane = new JScrollPane(j);     
        
        getContentPane().add(scrollPane);
        setPreferredSize(new Dimension(800,600));
        
        JButton back=new JButton("Back");
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        back.setBounds(610, 20, 80, 40);
        j.add(back);
        
        setSize(800,600);
        setLocation(500,180);
        setVisible(true);
    }
    public static void main(String[] args){
        new transaction().setVisible(true);
    }
}
