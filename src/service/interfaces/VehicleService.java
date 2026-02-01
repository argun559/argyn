package service.interfaces;

import model.VehicleBase;
import java.util.List;

public interface VehicleService {
    void addVehicle(VehicleBase v);
    VehicleBase getVehicle(int id);
    List<VehicleBase> getAllVehicles();
    void updateAvailability(int id, boolean available);
    void rentVehicle(int id);
    void returnVehicle(int id);
    void deleteVehicle(int id);
}
