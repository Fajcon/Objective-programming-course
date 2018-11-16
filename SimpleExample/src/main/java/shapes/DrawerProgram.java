package shapes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class DrawerProgram extends JFrame{

    public static void main(String [] argv){
        JFrame dp = new JFrame();
        Drawer d = new Drawer();
        dp.setSize(450, 450);
        dp.setVisible(true);
        dp.add(d);
        dp.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });

    }

}