/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riphah.tour.agency;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    
    
    public void req()
    {
        String serverAddress = "localhost";
        int portNumber = 54321;

        try (
            // Create a socket and connect to the server
            Socket socket = new Socket(serverAddress, portNumber);
            // Create input and output streams for communication with the server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            // Hardcoded message to send to the server
            String messageToSend = "Please Confirm the Booking";

            // Send the hardcoded message to the server
            out.println(messageToSend);

            // Receive and print the server's response
            System.out.println("Server: " + in.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
