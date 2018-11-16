package shapes;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author szymon
 */

import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawer extends JPanel{

    @Override
    public void paint(Graphics graphics) {
        Trójkąt trójkąt = new Trójkąt("test", 100);
        trójkąt.draw(graphics);

    }





}