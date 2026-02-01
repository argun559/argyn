package service;

import exception.DuplicateResourceException;
import exception.InvalidInputException;
import exception.ResourceNotFoundException;
import model.Engine;
import repository.interfaces.CrudRepository;
import service.interfaces.EngineService;
import service.interfaces.Validatable;

import java.util.List;

public class EngineServiceImpl implements EngineService, Validatable<Engine> {

    private CrudRepository<Engine> engineRepo;

    public EngineServiceImpl(CrudRepository<Engine> engineRepo) {
        this.engineRepo = engineRepo;
    }

    @Override
    public void addEngine(Engine e) {
        validate(e);

        Engine exists = engineRepo.findById(e.getId());
        if (exists != null) throw new DuplicateResourceException("Engine with id already exists: " + e.getId());

        engineRepo.create(e);
    }

    @Override
    public Engine getEngine(int id) {
        if (id <= 0) throw new InvalidInputException("Engine id must be > 0");
        Engine e = engineRepo.findById(id);
        if (e == null) throw new ResourceNotFoundException("Engine not found: " + id);
        return e;
    }

    @Override
    public List<Engine> getAllEngines() {
        return engineRepo.findAll();
    }

    @Override
    public void deleteEngine(int id) {
        getEngine(id);
        engineRepo.delete(id);
    }

    @Override
    public void validate(Engine e) {
        Validatable.log("Validating engine");

        if (!notNull(e)) throw new InvalidInputException("Engine is null");
        if (e.getId() <= 0) throw new InvalidInputException("Engine id must be > 0");
        if (e.getEngineType() == null || e.getEngineType().isBlank()) throw new InvalidInputException("Engine type is empty");
        if (e.getHorsePower() <= 0) throw new InvalidInputException("Horse power must be > 0");
    }
}
