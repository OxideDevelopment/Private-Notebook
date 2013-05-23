package com.github.oxidedevelopment.privatenotebook.utils;

import javax.swing.*;
import java.io.File;

/**
 * Created by: Justin
 * Date: 5/22/13
 * Time: 4:08 PM
 */
public class NotebookDirectory {

    File notebookDirectory;
    File savePath;

    public NotebookDirectory(File notebookDirectory, boolean setup) {
        this.notebookDirectory = notebookDirectory;
        if(!setup)
            setupDirectoryTree();

        savePath = new File(notebookDirectory.getAbsolutePath() + System.getProperty("file.separator") + "saves");
    }

    private void setupDirectoryTree() {
        File saves = new File(notebookDirectory.getAbsolutePath() + System.getProperty("file.separator") + "saves");
        saves.mkdir();
    }

    public String openSave(){
        JFileChooser dlg = new JFileChooser(savePath);
        if(dlg.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            JOptionPane.showMessageDialog(null, "Approved");
        }
        return null;
    }
}
