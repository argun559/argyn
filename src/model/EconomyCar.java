package model;
public class EconomyCar extends VehicleBase {
    public EconomyCar(int id, String name, double dailyPrice, String licensePlate) {
        super(id, name, dailyPrice, licensePlate);
    }

    public double calculateRentalCost(int days) {
        return dailyPrice * days;
    }

    public String getVehicleType() {
        return "ECONOMY";
    }
}
