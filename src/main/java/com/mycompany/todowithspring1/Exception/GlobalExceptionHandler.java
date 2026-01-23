package com.mycompany.todowithspring1.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //404 custom exception
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleNotFound(NotFoundException ex){
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
        Map<String,Object> body = new HashMap<>();
        body.put("status", 500);
        body.put("error", "Unexpected server error");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }
}
