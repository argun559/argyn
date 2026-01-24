package model;
public class Rental {
    private int id;
    private Customer customer;
    private VehicleBase vehicle;
    private int days;

    public Rental(int id, Customer customer, VehicleBase vehicle, int days) {
        this.id = id;
        this.customer = customer;
        this.vehicle = vehicle;
        this.days = days;
    }

    public double totalPrice() {
        return vehicle.calculateRentalCost(days);
    }

    public int getId() {
        return id;
    }
    public Customer getCustomer() {
        return customer;
    }

    public VehicleBase getVehicle() {
        return vehicle;
    }

    public int getDays() {
        return days;
    }
}
