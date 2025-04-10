package com.authentication.auth_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> ResourceNotFound(ResourceNotFoundException exception){
        Map<String, Object>responseEx = new HashMap<>();

        responseEx.put("status", HttpStatus.NOT_FOUND);
        responseEx.put("error", "Resource not found");
        responseEx.put("message", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseEx);
    }

    @ExceptionHandler(UsernameAlreadyExist.class)
    public ResponseEntity<Map<String, Object>> usernameAlreadyExists(UsernameAlreadyExist exception){

        Map<String, Object>responseEx = new HashMap<>();

        responseEx.put("status", HttpStatus.CONFLICT);
        responseEx.put("error", "Conflict");
        responseEx.put("message", exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(responseEx);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Map<String, Object>> authenticationException(AuthenticationException exception){

        Map<String, Object>responseEx = new HashMap<>();

        responseEx.put("status", HttpStatus.UNAUTHORIZED);
        responseEx.put("error", "Unauthorized");
        responseEx.put("message", exception.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseEx);
    }


    @ExceptionHandler(IncorrectFormatPassword.class)
    public ResponseEntity<Map<String, Object>> IncorrectFormatPassword(IncorrectFormatPassword exception){

        Map<String, Object>responseEx = new HashMap<>();

        responseEx.put("status", HttpStatus.BAD_REQUEST);
        responseEx.put("error", "Bad request");
        responseEx.put("message", exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseEx);
    }






}
