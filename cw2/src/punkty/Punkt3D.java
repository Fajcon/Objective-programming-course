package punkty;

public class Punkt3D extends Punkt2D{


    private double z;

    public Punkt3D(double _x, double _y, double _z, String _name) {
        super(_x, _y, _name);
        z = _z;
    }


    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double distance(Punkt3D other){
        return Math.sqrt(Math.pow((other.x-this.x),2) + Math.pow((other.y - this.y),2) + Math.pow((other.z - this.z),2));
    }
}
