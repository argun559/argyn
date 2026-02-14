package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ApiError handleNotFound(NotFoundException ex) {
        return new ApiError(ex.getMessage(), HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(BadRequestException.class)
    public ApiError handleBadRequest(BadRequestException ex) {
        return new ApiError(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiError handleValidation(MethodArgumentNotValidException ex) {
        String msg = "validation failed";
        if (ex.getBindingResult().getFieldError() != null) {
            msg = ex.getBindingResult().getFieldError().getField() + " is invalid";
        }
        return new ApiError(msg, HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(Exception.class)
    public ApiError handleAny(Exception ex) {
        return new ApiError("internal error", HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
