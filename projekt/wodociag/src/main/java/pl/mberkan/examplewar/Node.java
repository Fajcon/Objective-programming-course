package pl.mberkan.examplewar;

public class Node {
    private String ID;
    private double altitude;
    private double positionX;
    private double positionY;
    private double predefinedWaterUsage;
    private String adres = null;
    private String prevID;

    public String getID() {
        return ID;
    }

    public double getAltitude() {
        return altitude;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public double getPredefinedWaterUsage() {
        return predefinedWaterUsage;
    }

    public String getAdres() {
        return adres;
    }

    public String getPrevID() { return prevID;}

    public Node(String ID, double altitude, double positionX, double positionY, double predefinedWaterUsage, String adres, String prevID) {
        this.ID = ID;
        this.altitude = altitude;
        this.positionX = positionX;
        this.positionY = positionY;
        this.predefinedWaterUsage = predefinedWaterUsage;
        this.adres = adres;
        this.prevID = prevID;
    }
}
