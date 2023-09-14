package com.example.EmpSystem.models.response;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class BadRequestHandler {
//
//    protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
//                                                          HttpStatus status, WebRequest request) {
//
//        Map<String, Object> responseBody = new HashMap<>();
//
//        Map<String, Object> fieldErrors = new HashMap<>();
//        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
//            fieldErrors.put(error.getField(), error.getDefaultMessage());
//        }
//
//        responseBody.put("data", fieldErrors);
//        responseBody.put("status", HttpStatus.BAD_REQUEST.value());
//        responseBody.put("message", "HTTP request error");
//
//        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
//
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<DefaultResponse> validationError(MethodArgumentNotValidException ex) {
    Map<String, Object> fieldErrors = new HashMap<>();
    for (FieldError error : ex.getBindingResult().getFieldErrors()) {
        fieldErrors.put(error.getField(), error.getDefaultMessage());
    }
    DefaultResponse response = new DefaultResponse("FAILED", "Input Validation Failed", fieldErrors);
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
}
}