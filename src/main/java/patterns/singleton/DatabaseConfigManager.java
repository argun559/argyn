package patterns.singleton;

public class DatabaseConfigManager {
    private static DatabaseConfigManager instance;

    private String url;
    private String username;

    private DatabaseConfigManager() {
        this.url = "jdbc:h2:mem:endtermdb";
        this.username = "sa";
    }

    public static DatabaseConfigManager getInstance() {
        if (instance == null) {
            instance = new DatabaseConfigManager();
        }
        return instance;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }
}
