package com.github.oxidedevelopment.privatenotebook.utils;

import java.io.File;

/**
 * Created by: Justin
 * Date: 5/22/13
 * Time: 4:08 PM
 */
public class NotebookDirectory {

    File notebookDirectory;

    public NotebookDirectory(File notebookDirectory, boolean setup) {
        this.notebookDirectory = notebookDirectory;
        if(!setup)
            setupDirectoryTree();
    }

    private void setupDirectoryTree() {
        File saves = new File(notebookDirectory.getAbsolutePath() + System.getProperty("file.separator") + "saves");
        if(!saves.exists()) saves.mkdir();
    }

    public String openSave(File save){
        return null;
    }
}
