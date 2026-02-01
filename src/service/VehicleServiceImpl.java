package service;
import repository.interfaces.CrudRepository;


import exception.DuplicateResourceException;
import exception.InvalidInputException;
import exception.ResourceNotFoundException;
import model.Car;
import model.Engine;
import model.VehicleBase;
import repository.EngineRepository;
import service.interfaces.Validatable;
import service.interfaces.VehicleService;

import java.util.List;

public class VehicleServiceImpl implements VehicleService, Validatable<VehicleBase> {

    private CrudRepository<VehicleBase> vehicleRepo;
    private EngineRepository engineRepo;

    public VehicleServiceImpl(CrudRepository<VehicleBase> vehicleRepo, EngineRepository engineRepo) {
        this.vehicleRepo = vehicleRepo;
        this.engineRepo = engineRepo;
    }

    @Override
    public void addVehicle(VehicleBase v) {
        validate(v);

        VehicleBase exists = vehicleRepo.findById(v.getId());
        if (exists != null) throw new DuplicateResourceException("Vehicle with id already exists: " + v.getId());

        if ("CAR".equals(v.getVehicleType())) {
            Car car = (Car) v;
            Engine e = car.getEngine();
            if (e == null) throw new InvalidInputException("Car engine is null");
            if (engineRepo.findById(e.getId()) == null) {
                engineRepo.create(e);
            }
        }

        vehicleRepo.create(v);
    }

    @Override
    public VehicleBase getVehicle(int id) {
        if (id <= 0) throw new InvalidInputException("Vehicle id must be > 0");
        VehicleBase v = vehicleRepo.findById(id);
        if (v == null) throw new ResourceNotFoundException("Vehicle not found: " + id);
        return v;
    }

    @Override
    public List<VehicleBase> getAllVehicles() {
        return vehicleRepo.findAll();
    }

    @Override
    public void updateAvailability(int id, boolean available) {
        VehicleBase v = getVehicle(id);
        v.setAvailable(available);
        vehicleRepo.update(v);
    }

    @Override
    public void rentVehicle(int id) {
        VehicleBase v = getVehicle(id);
        if (!v.isAvailable()) throw new InvalidInputException("Vehicle is already rented: " + id);
        v.setAvailable(false);
        vehicleRepo.update(v);
    }

    @Override
    public void returnVehicle(int id) {
        VehicleBase v = getVehicle(id);
        if (v.isAvailable()) throw new InvalidInputException("Vehicle is already available: " + id);
        v.setAvailable(true);
        vehicleRepo.update(v);
    }

    @Override
    public void deleteVehicle(int id) {
        getVehicle(id);
        vehicleRepo.delete(id);
    }

    @Override
    public void validate(VehicleBase v) {
        Validatable.log("Validating vehicle");

        if (!notNull(v)) throw new InvalidInputException("Vehicle is null");
        if (v.getId() <= 0) throw new InvalidInputException("Vehicle id must be > 0");
        if (v.getName() == null || v.getName().isBlank()) throw new InvalidInputException("Vehicle name is empty");
        if (v.getBrand() == null || v.getBrand().isBlank()) throw new InvalidInputException("Brand is empty");
    }
}
