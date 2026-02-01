package model;

public abstract class VehicleBase {
    private int id;
    private String name;
    private String brand;
    private boolean available;

    protected VehicleBase(int id, String name, String brand, boolean available) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.available = available;
    }

    public abstract String getVehicleType();
    public abstract double calculateRentalPrice(int days);

    public String displayInfo() {
        return id + " | " + getVehicleType() + " | " + brand + " " + name + " | available=" + available;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
