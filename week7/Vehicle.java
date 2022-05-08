package gr.aueb.cf.testbed.week7;

public class Vehicle {

    private static int vehicleCount=0;
    private String type;
    private int releaseYear;
    private int cubicCapacity;
    private boolean longVehicle;

    public Vehicle() {
        vehicleCount++;
    }

    public Vehicle(String type, int releaseYear, int cubicCapacity,  boolean longVehicle) {
        this.type = type;
        this.releaseYear = releaseYear;
        this.cubicCapacity = cubicCapacity;
        this.longVehicle = longVehicle;
        vehicleCount++;
    }

    public static int getVehicleCount() {
        return vehicleCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getCubicCapacity() {
        return cubicCapacity;
    }

    public void setCubicCapacity(int cubicCapacity) {
        this.cubicCapacity = cubicCapacity;
    }

    public boolean isLongVehicle() {
        return longVehicle;
    }

    public void setLongVehicle(boolean longVehicle) {
        this.longVehicle = longVehicle;
    }
}
