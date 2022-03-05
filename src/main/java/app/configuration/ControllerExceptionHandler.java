package app.configuration;

import app.models.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleGlobalException (MethodArgumentNotValidException e) {
        StringBuilder errors = new StringBuilder();
        for (FieldError error: e.getFieldErrors()) {
            errors.append(error.getField()).append("= ").append(error.getDefaultMessage());
        }
        ApiError apiError = new ApiError(errors.toString(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(apiError, apiError.getHttpStatus());
    }
}
