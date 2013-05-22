package com.github.oxidedevelopment.privatenotebook.windows;

import com.github.oxidedevelopment.privatenotebook.PrivateNotebook;
import com.github.oxidedevelopment.privatenotebook.utils.BCrypt;

import javax.swing.*;
import java.io.*;

/**
 * Created by: Justin
 * Date: 5/21/13
 * Time: 9:13 PM
 */
public class PasswordHandler {

    public void createPW(){
        String pw = JOptionPane.showInputDialog("Enter a password: ");
        pw = BCrypt.hashpw(pw, BCrypt.gensalt());

        //Write password to disk
        try {
            String pwPath = PrivateNotebook.workingDir +
                    System.getProperty("file.separator") + "password";

            File pwFile = new File(pwPath);
            pwFile.createNewFile();

            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(pwFile));

            writer.write(pw);
            pw = null;
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean verifyPW(String pw){
        //Get password
        String pwPath = PrivateNotebook.workingDir +
                System.getProperty("file.separator") + "password";

        File pwFile = new File(pwPath);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(pwFile));
            String hashed = reader.readLine();
            reader.close();
            return BCrypt.checkpw(pw, hashed);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

}
