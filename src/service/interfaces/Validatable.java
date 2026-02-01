package service.interfaces;

public interface Validatable<T> {
    void validate(T obj);

    default boolean notNull(T obj) {
        return obj != null;
    }

    static void log(String msg) {
        System.out.println("[VALIDATION] " + msg);
    }
}
