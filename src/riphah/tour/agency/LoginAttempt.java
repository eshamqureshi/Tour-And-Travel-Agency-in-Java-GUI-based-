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
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginAttempt implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private String dateTime;

    public LoginAttempt(String username, String password, String dateTime) {
        this.username = username;
        this.password = password;
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Username: " + username +
                "          Password: " + password +
                "          DateTime: " + dateTime +
                "\n\n";
    }
}