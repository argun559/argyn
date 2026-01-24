package repository;

import utils.DatabaseConnection;
import model.Customer;
import exception.*;

import java.sql.*;
import java.util.*;

public class CustomerRepository {

    public void create(Customer cst) {
        String sql = "insert into customers(id,name,phone) values(?,?,?)";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, cst.getId());
            ps.setString(2, cst.getName());
            ps.setString(3, cst.getPhone());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseOperationException(e.getMessage());
        }
    }

    public Customer getById(int id) {
        String sql = "select * from customers where id=?";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) throw new ResourceNotFoundException("Customer not found");
            return new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("phone"));
        } catch (SQLException e) {
            throw new DatabaseOperationException(e.getMessage());
        }
    }

    public List<Customer> getAll() {
        List<Customer> list = new ArrayList<>();
        String sql = "select * from customers";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("phone")));
            }
        } catch (SQLException e) {
            throw new DatabaseOperationException(e.getMessage());
        }
        return list;
    }

    public void delete(int id) {
        String sql = "delete from customers where id=?";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            if (ps.executeUpdate() == 0) throw new ResourceNotFoundException("Customer not found");
        } catch (SQLException e) {
            throw new DatabaseOperationException(e.getMessage());
        }
    }
}
