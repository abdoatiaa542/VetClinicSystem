package com.example.Vet.Clinic.System.exception;

import com.example.Vet.Clinic.System.dto.ApiResponse;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> validationErrors = new HashMap<>();
        List<ObjectError> validationErrorList = ex.getBindingResult().getAllErrors();

        validationErrorList.forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String validationMsg = error.getDefaultMessage();
            validationErrors.put(fieldName, validationMsg);
        });
        return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
    }


}