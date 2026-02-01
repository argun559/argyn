package utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {
    public static void inspect(Class<?> cls) {
        System.out.println("Class: " + cls.getName());

        Field[] fields = cls.getDeclaredFields();
        for (Field f : fields) {
            System.out.println("Field: " + f.getName());
        }

        Method[] methods = cls.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println("Method: " + m.getName());
        }
    }
}
