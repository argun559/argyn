package model;

import interfaces.Validatable;
import interfaces.Billable;
import exception.InvalidInputException;

public abstract class VehicleBase implements Validatable, Billable {
    protected int id;
    protected String name;
    protected double dailyPrice;
    protected String licensePlate;
    protected boolean available;

    public VehicleBase(int id, String name, double dailyPrice, String licensePlate) {
        this.id = id;
        this.name = name;
        this.dailyPrice = dailyPrice;
        this.licensePlate = licensePlate;
        this.available = true;
    }

    public abstract double calculateRentalCost(int days);
    public abstract String getVehicleType();

    public void displayInfo() {
        System.out.println(getVehicleType() + " | " + name + " | " + dailyPrice + " | " + licensePlate);
    }

    public void validate() {
        if (name == null || name.isEmpty()) throw new InvalidInputException("Empty name");
        if (dailyPrice <= 0) throw new InvalidInputException("Invalid price");
    }

    public double calculateTotal(int days) {
        return calculateRentalCost(days);
    }

    public int getId() {
        return id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }
    public String getName() {
        return name;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }
}

