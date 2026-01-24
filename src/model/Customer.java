package model;

import interfaces.Validatable;
import exception.InvalidInputException;
public class Customer implements Validatable {
    private int id;
    private String name;
    private String phone;

    public Customer(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public void validate() {
        if (name == null || name.isEmpty()) throw new InvalidInputException("Empty customer name");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

}

