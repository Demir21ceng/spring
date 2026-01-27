package com.mycompany.todowithspring1.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Map;
import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log =
            LoggerFactory.getLogger(GlobalExceptionHandler.class);

    //404 custom exception
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleNotFound(NotFoundException ex){
        log.warn("NOT FOUND: {} ", ex.getMessage());
        Map<String,Object> body = new HashMap<>();
        body.put("status", 404);
        body.put("error", ex.getMessage());
        return ResponseEntity.
                status(HttpStatus.NOT_FOUND).
                body(body);
    }

    // 400 validation hataları (buradaki hataların shortcut ı bulunduğundan dolayı bad request ekledik)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>> handleValidation(MethodArgumentNotValidException ex){
        log.warn("WALİDATİON ERROR: {} ", ex.getMessage());
        Map<String,Object> body = new HashMap<>();
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach((e)->{body.put(e.getField(),e.getDefaultMessage());});
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("errors", errors);
        return ResponseEntity.badRequest().body(body);
    }

    // 500 genel hatalar
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,Object>> handleGeneral(Exception ex){
        log.warn("UNEXPECTED ERROR: {} ", ex.getMessage());
        Map<String,Object> body = new HashMap<>();
        body.put("status", 500);
        body.put("error", "internal server error");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<Map<String,Object>> handleConflict(ConflictException ex) {
        Map<String,Object> body = new HashMap<>();
        body.put("status", 409);
        body.put("error", ex.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
    }

}
