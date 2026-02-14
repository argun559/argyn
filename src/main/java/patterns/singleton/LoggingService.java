package patterns.singleton;

import java.time.LocalDateTime;

public class LoggingService {
    private static LoggingService instance;

    private LoggingService() {}

    public static LoggingService getInstance() {
        if (instance == null) {
            instance = new LoggingService();
        }
        return instance;
    }

    public void info(String message) {
        System.out.println(LocalDateTime.now() + " INFO " + message);
    }

    public void error(String message) {
        System.out.println(LocalDateTime.now() + " ERROR " + message);
    }
}
