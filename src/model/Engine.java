package model;

public class Engine {
    private int id;
    private String engineType;
    private int horsePower;

    public Engine(int id, String engineType, int horsePower) {
        this.id = id;
        this.engineType = engineType;
        this.horsePower = horsePower;
    }

    public int getId() {
        return id;
    }

    public String getEngineType() {
        return engineType;
    }

    public int getHorsePower() {
        return horsePower;
    }
}
