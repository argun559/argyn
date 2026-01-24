package controller;

import service.*;
import model.*;
import exception.*;

public class Main {

    public static void main(String[] args) {

        VehicleService vehicleService = new VehicleService();
        CustomerService customerService = new CustomerService();
        RentalService rentalService = new RentalService();

        Customer c1 = new Customer(1, "Aisultan", "111");
        Customer c2 = new Customer(2, "Miras", "222");

        customerService.addCustomer(c1);
        customerService.addCustomer(c2);

        VehicleBase v1 = new EconomyCar(1, "Toyota", 50, "ABC123");
        VehicleBase v2 = new LuxuryCar(2, "BMW", 150, "XYZ999");

        vehicleService.addVehicle(v1);
        vehicleService.addVehicle(v2);

        for (VehicleBase v : vehicleService.getAll()) {
            v.displayInfo();
            System.out.println(v.calculateTotal(3));
        }

        vehicleService.updatePrice(1, 60);

        rentalService.createRental(1, 1, 1, 3);

        try {
            customerService.addCustomer(new Customer(3, "", "333"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            vehicleService.addVehicle(new EconomyCar(3, "Honda", 40, "ABC123"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            rentalService.createRental(2, 99, 1, 2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        rentalService.delete(1);
        vehicleService.delete(2);
        customerService.delete(2);
    }
}
