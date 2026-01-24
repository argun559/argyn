package repository;

import utils.DatabaseConnection;
import model.VehicleBase;
import model.EconomyCar;
import model.LuxuryCar;
import exception.*;

import java.sql.*;
import java.util.*;

public class VehicleRepository {

    public void create(VehicleBase v) {
        String sql = "insert into vehicles(id,name,daily_price,license_plate,type) values(?,?,?,?,?)";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, v.getId());
            ps.setString(2, v.getName());
            ps.setDouble(3, v.getDailyPrice());
            ps.setString(4, v.getLicensePlate());
            ps.setString(5, v.getVehicleType());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseOperationException(e.getMessage());
        }
    }

    public List<VehicleBase> getAll() {
        List<VehicleBase> list = new ArrayList<>();
        String sql = "select * from vehicles";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String type = rs.getString("type");
                VehicleBase v =
                        type.equals("LUXURY")
                                ? new LuxuryCar(rs.getInt("id"), rs.getString("name"), rs.getDouble("daily_price"), rs.getString("license_plate"))
                                : new EconomyCar(rs.getInt("id"), rs.getString("name"), rs.getDouble("daily_price"), rs.getString("license_plate"));
                list.add(v);
            }
        } catch (SQLException e) {
            throw new DatabaseOperationException(e.getMessage());
        }
        return list;
    }

    public VehicleBase getById(int id) {
        String sql = "select * from vehicles where id=?";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) throw new ResourceNotFoundException("Vehicle not found");
            String type = rs.getString("type");
            return type.equals("LUXURY")
                    ? new LuxuryCar(rs.getInt("id"), rs.getString("name"), rs.getDouble("daily_price"), rs.getString("license_plate"))
                    : new EconomyCar(rs.getInt("id"), rs.getString("name"), rs.getDouble("daily_price"), rs.getString("license_plate"));
        } catch (SQLException e) {
            throw new DatabaseOperationException(e.getMessage());
        }
    }

    public void update(int id, double price) {
        String sql = "update vehicles set daily_price=? where id=?";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setDouble(1, price);
            ps.setInt(2, id);
            if (ps.executeUpdate() == 0) throw new ResourceNotFoundException("Vehicle not found");
        } catch (SQLException e) {
            throw new DatabaseOperationException(e.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "delete from vehicles where id=?";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            if (ps.executeUpdate() == 0) throw new ResourceNotFoundException("Vehicle not found");
        } catch (SQLException e) {
            throw new DatabaseOperationException(e.getMessage());
        }
    }
}
