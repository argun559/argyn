package repository;



import db.DatabaseConnection;
import exception.DatabaseOperationException;
import model.Car;
import model.Engine;
import model.Truck;
import model.VehicleBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import repository.interfaces.CrudRepository;


public class VehicleRepository implements CrudRepository<VehicleBase> {

    private EngineRepository engineRepo;

    public VehicleRepository(EngineRepository engineRepo) {
        this.engineRepo = engineRepo;
    }

    @Override
    public void create(VehicleBase v) {
        String sql = "INSERT INTO vehicle(id, name, brand, available, vehicle_type, seats, has_ac, engine_id, load_capacity_kg) VALUES(?,?,?,?,?,?,?,?,?)";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            Integer seats = null;
            Boolean hasAc = null;
            Integer engineId = null;
            Integer load = null;

            if ("CAR".equals(v.getVehicleType())) {
                Car car = (Car) v;
                seats = car.getSeats();
                hasAc = car.getHasAC();
                engineId = car.getEngine() == null ? null : car.getEngine().getId();
            }

            if ("TRUCK".equals(v.getVehicleType())) {
                Truck truck = (Truck) v;
                load = truck.getLoadCapacityKg();
            }

            ps.setInt(1, v.getId());
            ps.setString(2, v.getName());
            ps.setString(3, v.getBrand());
            ps.setBoolean(4, v.isAvailable());
            ps.setString(5, v.getVehicleType());

            if (seats == null) ps.setNull(6, java.sql.Types.INTEGER); else ps.setInt(6, seats);
            if (hasAc == null) ps.setNull(7, java.sql.Types.BOOLEAN); else ps.setBoolean(7, hasAc);
            if (engineId == null) ps.setNull(8, java.sql.Types.INTEGER); else ps.setInt(8, engineId);
            if (load == null) ps.setNull(9, java.sql.Types.INTEGER); else ps.setInt(9, load);

            ps.executeUpdate();
        } catch (Exception ex) {
            throw new DatabaseOperationException("DB create vehicle failed: " + ex.getMessage());
        }
    }

    @Override
    public VehicleBase findById(int id) {
        String sql = "SELECT * FROM vehicle WHERE id=?";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) return null;

            String type = rs.getString("vehicle_type");
            String name = rs.getString("name");
            String brand = rs.getString("brand");
            boolean available = rs.getBoolean("available");

            if ("CAR".equals(type)) {
                int seats = rs.getInt("seats");
                boolean hasAc = rs.getBoolean("has_ac");
                int engineId = rs.getInt("engine_id");
                Engine e = engineRepo.findById(engineId);
                return new Car(id, name, brand, available, seats, hasAc, e);
            }

            if ("TRUCK".equals(type)) {
                int load = rs.getInt("load_capacity_kg");
                return new Truck(id, name, brand, available, load);
            }

            return null;

        } catch (Exception ex) {
            throw new DatabaseOperationException("DB find vehicle failed: " + ex.getMessage());
        }
    }

    @Override
    public List<VehicleBase> findAll() {
        String sql = "SELECT * FROM vehicle";
        List<VehicleBase> list = new ArrayList<>();
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("vehicle_type");
                String name = rs.getString("name");
                String brand = rs.getString("brand");
                boolean available = rs.getBoolean("available");

                if ("CAR".equals(type)) {
                    int seats = rs.getInt("seats");
                    boolean hasAc = rs.getBoolean("has_ac");
                    int engineId = rs.getInt("engine_id");
                    Engine e = engineRepo.findById(engineId);
                    list.add(new Car(id, name, brand, available, seats, hasAc, e));
                } else if ("TRUCK".equals(type)) {
                    int load = rs.getInt("load_capacity_kg");
                    list.add(new Truck(id, name, brand, available, load));
                }
            }
            return list;

        } catch (Exception ex) {
            throw new DatabaseOperationException("DB list vehicles failed: " + ex.getMessage());
        }
    }

    @Override
    public void update(VehicleBase v) {
        String sql = "UPDATE vehicle SET name=?, brand=?, available=? WHERE id=?";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, v.getName());
            ps.setString(2, v.getBrand());
            ps.setBoolean(3, v.isAvailable());
            ps.setInt(4, v.getId());
            ps.executeUpdate();

        } catch (Exception ex) {
            throw new DatabaseOperationException("DB update vehicle failed: " + ex.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM vehicle WHERE id=?";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception ex) {
            throw new DatabaseOperationException("DB delete vehicle failed: " + ex.getMessage());
        }
    }
}


