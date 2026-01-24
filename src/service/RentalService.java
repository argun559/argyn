package service;

import repository.RentalRepository;
import repository.VehicleRepository;
import repository.CustomerRepository;
import model.*;
import exception.*;

import java.util.List;

public class RentalService {

    private final RentalRepository rentalRepo = new RentalRepository();
    private final VehicleRepository vehicleRepo = new VehicleRepository();
    private final CustomerRepository customerRepo = new CustomerRepository();

    public void createRental(int rentalId, int customerId, int vehicleId, int days) {
        if (days <= 0) throw new InvalidInputException("Invalid rental days");

        Customer customer = customerRepo.getById(customerId);
        VehicleBase vehicle = vehicleRepo.getById(vehicleId);

        Rental rental = new Rental(rentalId, customer, vehicle, days);
        rentalRepo.create(rental);
    }

    public List<Rental> getAll() {
        return rentalRepo.getAll();
    }

    public void delete(int id) {
        rentalRepo.delete(id);
    }
}
