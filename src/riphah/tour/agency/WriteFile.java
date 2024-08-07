package riphah.tour.agency;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteFile {

    private static final String FILE_NAME = "login_attempts.bin";

    public static void writeLoginAttempt(String username, String password) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME, true))) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String dateTime = dateFormat.format(date);

            LoginAttempt loginAttempt = new LoginAttempt(username, password, dateTime);
            objectOutputStream.writeObject(loginAttempt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
}
