package com.example.Vet.Clinic.System.exception;

import com.example.Vet.Clinic.System.dto.ApiResponse;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.function.Function;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Function<Exception, ApiResponse> function =
            exception -> new ApiResponse(false, exception.getLocalizedMessage(), exception.getCause());


    @ExceptionHandler(value = ResourceAlreadyExistsException.class)
    protected ResponseEntity<Object> handleResourceAlreadyExistsException(@NotNull ResourceAlreadyExistsException exception) {
        return ResponseEntity.status(HttpServletResponse.SC_CONFLICT)
                .body(new ApiResponse(false, exception.getMessage(), null));
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    protected ResponseEntity<Object> handleResourceNotFoundException(@NotNull ResourceNotFoundException exception) {
        return ResponseEntity.status(HttpServletResponse.SC_NOT_FOUND)
                .body(new ApiResponse(false, exception.getMessage(), null));
    }

    @ExceptionHandler(value = ForbiddenActionException.class)
    protected ResponseEntity<Object> handleForbiddenActionException(@NotNull ForbiddenActionException exception) {
        return ResponseEntity.status(HttpServletResponse.SC_FORBIDDEN)
                .body(new ApiResponse(false, exception.getMessage(), null));
    }

}