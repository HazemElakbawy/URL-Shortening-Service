package com.hazem.urlshortener.exception;

import com.hazem.urlshortener.exception.custom.UrlNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(UrlNotFoundException.class)
  public ResponseEntity<ErrorDetails> handleUrlNotFoundException(UrlNotFoundException e) {
    ErrorDetails errorDetails = new ErrorDetails(
        Timestamp.valueOf(LocalDateTime.now()),
        "Requested URL not found",
        e.getMessage(),
        HttpStatus.NOT_FOUND.value()
    );

    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorDetails> handleGlobalException(Exception ex) {
    ErrorDetails errorDetails = new ErrorDetails(
        Timestamp.valueOf(LocalDateTime.now()),
        "Internal server error",
        "An unexpected error occurred. Please try again later.",
        HttpStatus.INTERNAL_SERVER_ERROR.value()
    );

    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
