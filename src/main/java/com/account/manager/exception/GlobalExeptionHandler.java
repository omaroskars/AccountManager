package com.account.manager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExeptionHandler {

  /**
   * NotFoundException handler
   */
  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<?> notFoundException(NotFoundException ex, WebRequest request) {
    ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage(), request.getDescription(false));

    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

  /**
   * Global exception handler. Handles unpredicted exceptions
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> globalExeptionHandler(Exception ex, WebRequest request) {
    ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(),
        request.getDescription(false));

    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}