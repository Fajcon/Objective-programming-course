package shapes;

import java.awt.*;

public class Trójkąt extends Shape {
    public int a;
    public Trójkąt(String _name, int _a) {
        name = _name;
        a = _a;
    }

    public void draw(Graphics graphics){
        graphics.setColor(Color.BLUE);
        graphics.fillOval(1,1,a,a);

    }
}
