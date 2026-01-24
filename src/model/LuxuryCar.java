package model;
public class LuxuryCar extends VehicleBase {
    public LuxuryCar(int id, String name, double dailyPrice, String licensePlate) {
        super(id, name, dailyPrice, licensePlate);
    }

    public double calculateRentalCost(int days) {
        return dailyPrice * days * 1.5;
    }

    public String getVehicleType() {
        return "LUXURY";
    }
}

