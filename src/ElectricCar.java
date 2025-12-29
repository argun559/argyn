public class ElectricCar extends Car {
    private int batteryCapacity;

    public ElectricCar(String brand, int year, Driver driver, int doors, int batteryCapacity) {
        super(brand, year, driver, doors, "Electric");
        this.batteryCapacity = batteryCapacity;
    }

    public void startEngine() {
        System.out.println("Electric car started silently");
    }

    public void stopEngine() {
        System.out.println("Electric car stopped");
    }
}

