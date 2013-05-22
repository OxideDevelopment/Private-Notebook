package com.github.oxidedevelopment.privatenotebook.windows;

import javax.swing.*;
import java.awt.*;

/**
 * Created by: Justin
 * Date: 5/22/13
 * Time: 4:26 PM
 */
public class NotebookEditor extends JFrame {

    JPanel menuPanel;
    JMenuBar menu;
    JPanel textPanel;
    JTextArea editor;

    public NotebookEditor() {
        super("Private Notebook");
        createGui();
    }

    private void createGui() {
        menuPanel = new JPanel();

        menu = new JMenuBar();
        setJMenuBar(menu);
        menuPanel.add(menu);

        textPanel = new JPanel();
        editor = new JTextArea();
        menuPanel.add(editor);

        add(menuPanel, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
    }


}
