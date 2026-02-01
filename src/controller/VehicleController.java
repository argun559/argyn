package controller;

import model.VehicleBase;
import service.interfaces.VehicleService;

import java.util.List;

public class VehicleController {
    private VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    public void create(VehicleBase v) {
        service.addVehicle(v);
    }

    public VehicleBase get(int id) {
        return service.getVehicle(id);
    }

    public List<VehicleBase> list() {
        return service.getAllVehicles();
    }

    public void setAvailability(int id, boolean available) {
        service.updateAvailability(id, available);
    }

    public void rent(int id) {
        service.rentVehicle(id);
    }

    public void returnVehicle(int id) {
        service.returnVehicle(id);
    }

    public void delete(int id) {
        service.deleteVehicle(id);
    }
}
