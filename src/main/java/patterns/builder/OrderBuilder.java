package patterns.builder;

import model.Customer;
import model.Order;

import java.time.LocalDateTime;

public class OrderBuilder {
    private Customer customer;
    private LocalDateTime createdAt;
    private String status;

    public OrderBuilder customer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public OrderBuilder createdAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public OrderBuilder status(String status) {
        this.status = status;
        return this;
    }

    public Order build() {
        return new Order(customer, createdAt, status);
    }
}
