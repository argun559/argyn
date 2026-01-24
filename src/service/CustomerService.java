package service;

import repository.CustomerRepository;
import model.Customer;
import exception.*;

import java.util.List;

public class CustomerService {

    private final CustomerRepository repo = new CustomerRepository();

    public void addCustomer(Customer c) {
        c.validate();
        repo.create(c);
    }

    public Customer getById(int id) {
        return repo.getById(id);
    }

    public List<Customer> getAll() {
        return repo.getAll();
    }

    public void delete(int id) {
        repo.delete(id);
    }
}
