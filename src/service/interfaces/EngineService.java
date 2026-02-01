package service.interfaces;

import model.Engine;
import java.util.List;

public interface EngineService {
    void addEngine(Engine e);
    Engine getEngine(int id);
    List<Engine> getAllEngines();
    void deleteEngine(int id);
}
