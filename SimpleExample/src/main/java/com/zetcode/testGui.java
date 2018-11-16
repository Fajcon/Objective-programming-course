package com.zetcode;

import shapes.Drawer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class testGui {
    private JButton button1;
    private JPanel panelMain;
    private JTextArea helloWorldTextArea;

    public testGui() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //JOptionPane.showMessageDialog(null, "Hello world!");
                helloWorldTextArea.setText("Hello World!");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new testGui().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,450);
        frame.setVisible(true);

    }
}
