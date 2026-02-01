package repository;
import repository.interfaces.CrudRepository;




import db.DatabaseConnection;
import exception.DatabaseOperationException;
import model.Engine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EngineRepository implements CrudRepository<Engine> {

    @Override
    public void create(Engine e) {
        String sql = "INSERT INTO engine(id, engine_type, horse_power) VALUES(?,?,?)";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, e.getId());
            ps.setString(2, e.getEngineType());
            ps.setInt(3, e.getHorsePower());
            ps.executeUpdate();
        } catch (Exception ex) {
            throw new DatabaseOperationException("DB create engine failed: " + ex.getMessage());
        }
    }

    @Override
    public Engine findById(int id) {
        String sql = "SELECT id, engine_type, horse_power FROM engine WHERE id=?";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Engine(rs.getInt("id"), rs.getString("engine_type"), rs.getInt("horse_power"));
            }
            return null;
        } catch (Exception ex) {
            throw new DatabaseOperationException("DB find engine failed: " + ex.getMessage());
        }
    }

    @Override
    public List<Engine> findAll() {
        String sql = "SELECT id, engine_type, horse_power FROM engine";
        List<Engine> list = new ArrayList<>();
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Engine(rs.getInt("id"), rs.getString("engine_type"), rs.getInt("horse_power")));
            }
            return list;
        } catch (Exception ex) {
            throw new DatabaseOperationException("DB list engines failed: " + ex.getMessage());
        }
    }

    @Override
    public void update(Engine e) {
        String sql = "UPDATE engine SET engine_type=?, horse_power=? WHERE id=?";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, e.getEngineType());
            ps.setInt(2, e.getHorsePower());
            ps.setInt(3, e.getId());
            ps.executeUpdate();
        } catch (Exception ex) {
            throw new DatabaseOperationException("DB update engine failed: " + ex.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM engine WHERE id=?";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            throw new DatabaseOperationException("DB delete engine failed: " + ex.getMessage());
        }
    }
}
