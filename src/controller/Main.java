package controller;

import model.Car;
import model.Engine;
import model.Truck;
import model.VehicleBase;
import repository.EngineRepository;
import repository.VehicleRepository;
import service.EngineServiceImpl;
import service.VehicleServiceImpl;
import service.interfaces.EngineService;
import service.interfaces.VehicleService;
import utils.ReflectionUtils;
import utils.SortingUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EngineRepository engineRepo = new EngineRepository();
        VehicleRepository vehicleRepo = new VehicleRepository(engineRepo);

        EngineService engineService = new EngineServiceImpl(engineRepo);
        VehicleService vehicleService = new VehicleServiceImpl(vehicleRepo, engineRepo);

        EngineController engineController = new EngineController(engineService);
        VehicleController vehicleController = new VehicleController(vehicleService);

        Engine e1 = new Engine(4, "V8", 400);
        engineController.create(e1);

        VehicleBase v1 = new Car(1, "Camry", "Toyota", true, 5, true, e1);
        VehicleBase v2 = new Truck(2, "Actros", "Mercedes", true, 5000);

        vehicleController.create(v1);
        vehicleController.create(v2);

        System.out.println("All vehicles:");
        List<VehicleBase> all = vehicleController.list();
        for (VehicleBase v : all) {
            System.out.println(v.displayInfo());
        }

        System.out.println("Reflection on Car:");
        ReflectionUtils.inspect(Car.class);

        System.out.println("Sorted by price for 3 days:");
        SortingUtils.sortByRentalPriceForDays(all, 3);
        for (VehicleBase v : all) {
            System.out.println(v.displayInfo() + " | price=" + v.calculateRentalPrice(3));
        }

        System.out.println("Available only:");
        List<VehicleBase> available = SortingUtils.filterAvailable(all);
        for (VehicleBase v : available) {
            System.out.println(v.displayInfo());
        }

        System.out.println("Rent vehicle 1:");
        vehicleController.rent(1);
        System.out.println(vehicleController.get(1).displayInfo());

        System.out.println("Return vehicle 1:");
        vehicleController.returnVehicle(1);
        System.out.println(vehicleController.get(1).displayInfo());

        try {
            vehicleController.get(999);
        } catch (Exception ex) {
            System.out.println("Expected exception: " + ex.getMessage());
        }

        System.out.println("Try delete engine 1 (FK test):");
        try {
            engineController.delete(1);
            System.out.println("Engine deleted");
        } catch (Exception ex) {
            System.out.println("Expected FK/DB exception: " + ex.getMessage());
        }
    }
}
