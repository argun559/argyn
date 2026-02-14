package utils;

import exception.BadRequestException;

public class ValidationUtils {
    public static void require(boolean condition, String message) {
        if (!condition) {
            throw new BadRequestException(message);
        }
    }
}
