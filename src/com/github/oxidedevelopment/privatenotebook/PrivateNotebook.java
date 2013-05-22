package com.github.oxidedevelopment.privatenotebook;

import com.github.oxidedevelopment.privatenotebook.utils.BCrypt;
import com.github.oxidedevelopment.privatenotebook.windows.PasswordHandler;

import javax.swing.*;
import java.io.*;

/**
 * Created by: Justin
 * Date: 5/21/13
 * Time: 8:30 PM
 */
public class PrivateNotebook {

    public static String workingDir;
    private static PasswordHandler pw_handle;
    public static char[] enteredPW;

    public static void main(String[] args){
        pw_handle = new PasswordHandler();

        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        //Check to see if we have our password..
        String home = System.getProperty("user.home");
        home += System.getProperty("file.separator") + ".notebook";

        workingDir = home;

        File directory = new File(home);
        if(directory.exists()){
            //Ask user for password..
            String userPassword = JOptionPane.showInputDialog("Please enter your password: ");

            //Read password from password file
            try{
                BufferedReader reader = new BufferedReader(
                        new FileReader(home +
                                       System.getProperty("file.separator") +
                                       "password"));

                //Verify password..
                String canidate = reader.readLine();
                if(BCrypt.checkpw(userPassword, canidate)){
                    enteredPW = userPassword.toCharArray();

                }else{
                    JOptionPane.showMessageDialog(null,"Invalid password.", "Error", JOptionPane.ERROR_MESSAGE);
                    main(null);
                }
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

        }else{
            directory.mkdir();
            pw_handle.createPW();

            main(null);
        }
    }
}
