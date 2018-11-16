package shapes;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class MyPanel extends JPanel {
    public LinkedList<Shape> shapesList = new LinkedList<>();

    public MyPanel() {
    }

    public void paint(Graphics g) {
        g.setColor(new Color(0, 0, 0));
        for(Shape s: shapesList) {
            s.draw(g);
        }
    }


}
