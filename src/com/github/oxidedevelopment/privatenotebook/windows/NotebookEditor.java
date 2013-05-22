package com.github.oxidedevelopment.privatenotebook.windows;

import javax.swing.*;

/**
 * Created by: Justin
 * Date: 5/22/13
 * Time: 4:26 PM
 */
public class NotebookEditor extends JFrame {

    public NotebookEditor() {
        super("Private Notebook");
        createGui();
    }

    private void createGui() {
        JPanel panel = new JPanel();
       
        JMenuBar menu = new JMenuBar();
        setJMenuBar(menu);
        panel.add(menu);

        JTextArea editor = new JTextArea();
        panel.add(editor);

        add(panel);
    }


}
