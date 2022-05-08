package gr.aueb.cf.testbed.week7;

public class VehicleDriver {

    public static void main(String[] args) {

        Vehicle veh1 = new Vehicle();

        veh1.setType("Sport");
        veh1.setReleaseYear(2010);
        veh1.setCubicCapacity(1400);
        veh1.setLongVehicle(true);

        Vehicle veh2 = new Vehicle("City", 2015, 1200, false);




        System.out.println("Vehicle 1: Type: "+veh1.getType()+", Release Year: "+ veh1.getReleaseYear()+", Cubic Capacity: "+
                veh1.getCubicCapacity()+", Long vehicle: "+ veh1.isLongVehicle());

        System.out.println("Vehicle 2: Type: "+veh2.getType()+", Release Year: "+ veh2.getReleaseYear()+", Cubic Capacity: "+
                veh2.getCubicCapacity()+", Long vehicle: "+ veh2.isLongVehicle());

        System.out.println("Vehicles count: "+Vehicle.getVehicleCount());
    }
}
