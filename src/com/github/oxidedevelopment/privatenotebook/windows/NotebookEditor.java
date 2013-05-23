package com.github.oxidedevelopment.privatenotebook.windows;

import com.github.oxidedevelopment.privatenotebook.PrivateNotebook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by: Justin
 * Date: 5/22/13
 * Time: 4:26 PM
 */
public class NotebookEditor extends JFrame {

    JMenuBar menu;
    JMenu fileMenu;
    JPanel textPanel;
    JTextPane editor;

    public NotebookEditor() {
        super("Private Notebook");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        createGui();
    }

    private void createGui() {

        //Menu bar
        menu = new JMenuBar();
        //File menubar object
        fileMenu = new JMenu("File");
        //Setting the menubar
        setJMenuBar(menu);
        //Adding the file item to menubar
        JMenuItem file_open = new JMenuItem("Open");
        file_open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });

        fileMenu.add(file_open);
        menu.add(fileMenu);

        textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        editor = new JTextPane();
        editor.setPreferredSize(new Dimension(590, 400 - menu.getHeight()));
        //editor.setLayout(null);
        editor.setMinimumSize(new Dimension(0, 0));
        editor.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(editor);
        scrollPane.createHorizontalScrollBar();
        scrollPane.createVerticalScrollBar();

        textPanel.add(scrollPane);

        add(textPanel, BorderLayout.CENTER);


    }

    private void openFile() {
        PrivateNotebook.notebookDirectory.openSave();
    }


}
