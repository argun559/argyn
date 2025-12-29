public class Car extends Vehicle {

    private int doors;
    private String fuelType;

    public Car(String brand, int year, Driver driver, int doors, String fuelType) {
        super(brand, year, driver);
        this.doors = doors;
        this.fuelType = fuelType;
    }

    public void startEngine() {
        System.out.println("Car engine started");
    }

    public void stopEngine() {
        System.out.println("Car engine stopped");
    }
}

