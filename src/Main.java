public class Main {

    public static void main(String[] args) {

        Driver d1 = new Driver("Argyn", "LIC123");
        Driver d2 = new Driver("Aidos", "LIC456");
        Driver d3 = new Driver("Alikhan", "LIC789");

        Vehicle car = new Car("Toyota", 2020, d1, 4, "Petrol");
        Vehicle bike = new Motorcycle("Yamaha", 2019, d1, false);
        Vehicle truck = new Truck("Volvo", 2018, d2, 12.5, 6);
        Vehicle eCar = new ElectricCar("Tesla", 2022, d3, 4, 75);

        Vehicle[] vehicles = new Vehicle[4];
        vehicles[0] = car;
        vehicles[1] = bike;
        vehicles[2] = truck;
        vehicles[3] = eCar;

        for (int i = 0; i < vehicles.length; i++) {
            vehicles[i].startEngine();
            vehicles[i].displayInfo();
            vehicles[i].displayDriver();
            vehicles[i].stopEngine();
            System.out.println("-----");
        }
    }
}


