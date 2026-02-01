package model;
import service.interfaces.Rentable;


public class Car extends VehicleBase implements Rentable {
    private int seats;
    private boolean hasAC;
    private Engine engine;

    public Car(int id, String name, String brand, boolean available, int seats, boolean hasAC, Engine engine) {
        super(id, name, brand, available);
        this.seats = seats;
        this.hasAC = hasAC;
        this.engine = engine;
    }

    @Override
    public String getVehicleType() {
        return "CAR";
    }

    @Override
    public double calculateRentalPrice(int days) {
        double base = 15000;
        double extra = hasAC ? 2000 : 0;
        return (base + extra) * days;
    }

    @Override
    public void rent() {
        setAvailable(false);
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
    }

    public int getSeats() {
        return seats;
    }

    public boolean getHasAC() {
        return hasAC;
    }

    public Engine getEngine() {
        return engine;
    }
}
