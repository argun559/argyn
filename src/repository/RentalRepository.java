package repository;

import utils.DatabaseConnection;
import model.Rental;
import exception.*;

import java.sql.*;
import java.util.*;

public class RentalRepository {

    public void create(Rental r) {
        String sql = "insert into rentals(id,customer_id,vehicle_id,days) values(?,?,?,?)";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, r.getId());
            ps.setInt(2, r.getCustomer().getId());
            ps.setInt(3, r.getVehicle().getId());
            ps.setInt(4, r.getDays());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseOperationException(e.getMessage());
        }
    }

    public List<Rental> getAll() {
        List<Rental> list = new ArrayList<>();
        String sql = "select * from rentals";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Rental(rs.getInt("id"), null, null, rs.getInt("days")));
            }
        } catch (SQLException e) {
            throw new DatabaseOperationException(e.getMessage());
        }
        return list;
    }

    public void delete(int id) {
        String sql = "delete from rentals where id=?";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            if (ps.executeUpdate() == 0) throw new ResourceNotFoundException("Rental not found");
        } catch (SQLException e) {
            throw new DatabaseOperationException(e.getMessage());
        }
    }
}
