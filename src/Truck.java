public class Truck extends Vehicle {

    private double capacity;
    private int numAxles;

    public Truck(String brand, int year, Driver driver, double capacity, int numAxles) {
        super(brand, year, driver);
        this.capacity = capacity;
        this.numAxles = numAxles;
    }

    public void startEngine() {
        System.out.println("Truck engine started");
    }

    public void stopEngine() {
        System.out.println("Truck engine stopped");
    }
}
