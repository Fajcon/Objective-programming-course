package punkty;

import java.lang.Math;

public class Punkt2D {
    protected double x;
    protected double y;
    public String name;
    public Punkt2D(double _x, double _y, String _name){
        x = _x;
        y = _y;
        name = _name;
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distance(Punkt2D other){
        return Math.sqrt(Math.pow((other.x - this.x),2) + Math.pow((other.y - this.y),2));
    }

}
