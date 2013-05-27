package com.github.oxidedevelopment.privatenotebook.utils;

import com.github.oxidedevelopment.privatenotebook.PrivateNotebook;
import com.github.oxidedevelopment.privatenotebook.SavedFile;
import com.github.oxidedevelopment.privatenotebook.status.StatusCode;

import javax.swing.*;
import java.io.*;

/**
 * Created by: Justin
 * Date: 5/22/13
 * Time: 4:08 PM
 */
public class NotebookDirectory {

    public File notebookDirectory;
    public File savePath;
    String separator;

    public NotebookDirectory(File notebookDirectory, boolean setup) {
        this.notebookDirectory = notebookDirectory;
        if(!setup)
            setupDirectoryTree();

        savePath = new File(notebookDirectory.getAbsolutePath() + System.getProperty("file.separator") + "saves");
        separator = System.getProperty("file.separator");
    }

    private void setupDirectoryTree() {
        File saves = new File(savePath.getAbsolutePath());
        saves.mkdir();
    }

    public String[] openSave(){
        String[] empty = {"", ""};
        JFileChooser dlg = new JFileChooser(savePath);
        if(dlg.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            try {
                ObjectInputStream reader = new ObjectInputStream(new FileInputStream(dlg.getSelectedFile()));
                Object read = reader.readObject();
                if(read instanceof SavedFile){
                    //Load file
                    //But first some verification :P
                    SavedFile savedFile = (SavedFile) read;
                    if(!savedFile.getPw().equals(PrivateNotebook.saltedPW)){
                        JOptionPane.showMessageDialog(null, "Password mismatch", "Error",JOptionPane.ERROR_MESSAGE);
                        return empty;
                    }

                    String[] data = {savedFile.getTitle(), savedFile.getBody()};
                    return data;
                }else
                    JOptionPane.showMessageDialog(null, "Invalid file!", "Error", JOptionPane.ERROR_MESSAGE);

                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        return empty;
    }

    public int saveFile(String name, String title, String text, String md5_password){
        try {
            ObjectOutputStream writer = new ObjectOutputStream(
                    new FileOutputStream(savePath.getAbsolutePath() +
                                         separator +
                                         name));
            SavedFile savedFile = new SavedFile(md5_password, title, text);
            writer.writeObject(savedFile);
            writer.close();
            return StatusCode.SUCCESS;
        } catch (IOException e) {
            e.printStackTrace();
            return StatusCode.ERROR;
        }
    }
}
