package shapes;

import java.awt.*;

public abstract class Shape {
    public String name;

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPostionY(int postionY) {
        this.postionY = postionY;
    }

    protected int positionX;
    protected int postionY;
    public abstract void draw(Graphics graphics);
    public abstract boolean pressed(int mousePositionX, int mousePositionY);
}
