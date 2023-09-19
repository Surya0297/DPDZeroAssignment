package com.DPDZero.exception;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("status", "error");
        responseData.put("code", "INVALID_REQUEST");

        List<String> errorMessages = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errorMessages.add(error.getDefaultMessage());
        }
        responseData.put("message", "Invalid request. Please provide all required fields: " + String.join(", ", errorMessages));

        return ResponseEntity.badRequest().body(responseData);
    }

    @ExceptionHandler(UserExistsException.class)
    public ResponseEntity<Object> handleUserExistsException(UserExistsException ex) {
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("status", "error");
        responseData.put("code", "USERNAME_EXISTS");
        responseData.put("message", "The provided username is already taken. Please choose a different username.");

        return ResponseEntity.badRequest().body(responseData);
    }

    @ExceptionHandler(EmailExistsException.class)
    public ResponseEntity<Object> handleEmailExistsException(EmailExistsException ex) {
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("status", "error");
        responseData.put("code", "EMAIL_EXISTS");
        responseData.put("message", "The provided email is already registered. Please use a different email address.");

        return ResponseEntity.badRequest().body(responseData);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<Object> handleInvalidPasswordException(InvalidPasswordException ex) {
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("status", "error");
        responseData.put("code", "INVALID_PASSWORD");
        responseData.put("message", "The provided password does not meet the requirements. Password must be at least 8 characters long and contain a mix of uppercase and lowercase letters, numbers, and special characters.");

        return ResponseEntity.badRequest().body(responseData);
    }

    @ExceptionHandler(InvalidAgeException.class)
    public ResponseEntity<Object> handleInvalidAgeException(InvalidAgeException ex) {
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("status", "error");
        responseData.put("code", "INVALID_AGE");
        responseData.put("message", "Invalid age value. Age must be a positive integer.");

        return ResponseEntity.badRequest().body(responseData);
    }
}
