package controller;

import model.Engine;
import service.interfaces.EngineService;

import java.util.List;

public class EngineController {
    private EngineService service;

    public EngineController(EngineService service) {
        this.service = service;
    }

    public void create(Engine e) {
        service.addEngine(e);
    }

    public Engine get(int id) {
        return service.getEngine(id);
    }

    public List<Engine> list() {
        return service.getAllEngines();
    }

    public void delete(int id) {
        service.deleteEngine(id);
    }
}
