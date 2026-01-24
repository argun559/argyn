package service;

import repository.VehicleRepository;
import model.VehicleBase;
import exception.*;

import java.util.List;

public class VehicleService {

    private final VehicleRepository repo = new VehicleRepository();

    public void addVehicle(VehicleBase v) {
        v.validate();
        repo.create(v);
    }

    public List<VehicleBase> getAll() {
        return repo.getAll();
    }

    public VehicleBase getById(int id) {
        return repo.getById(id);
    }

    public void updatePrice(int id, double price) {
        if (price <= 0) throw new InvalidInputException("Invalid price");
        repo.update(id, price);
    }

    public void delete(int id) {
        repo.delete(id);
    }
}
