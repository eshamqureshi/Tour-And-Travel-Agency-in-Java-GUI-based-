
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package riphah.tour.agency;

/**
 *
 * @author Qureshi Sab
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server 
{
    public static void main(String[] args) {
        int portNumber = 54321;
 while(true)
{
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            System.out.println("Server is waiting for client connection on port " + portNumber);

            
            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams for communication with the client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read messages from the client and print them
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Client: " + inputLine);
                // Send a response back to the client
                out.println("Booking Confirmed.... ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }}
}

    

