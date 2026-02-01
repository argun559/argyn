package model;
import service.interfaces.Rentable;


public class Truck extends VehicleBase implements Rentable {
    private int loadCapacityKg;

    public Truck(int id, String name, String brand, boolean available, int loadCapacityKg) {
        super(id, name, brand, available);
        this.loadCapacityKg = loadCapacityKg;
    }

    @Override
    public String getVehicleType() {
        return "TRUCK";
    }

    @Override
    public double calculateRentalPrice(int days) {
        double base = 25000;
        double loadExtra = loadCapacityKg >= 3000 ? 8000 : 3000;
        return (base + loadExtra) * days;
    }

    @Override
    public void rent() {
        setAvailable(false);
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
    }

    public int getLoadCapacityKg() {
        return loadCapacityKg;
    }
}
