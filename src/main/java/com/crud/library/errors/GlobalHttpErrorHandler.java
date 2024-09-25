package com.crud.library.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ReaderNotFoundException.class)
    public ResponseEntity<Object> handleReaderNotFoundException(ReaderNotFoundException exception) {
        return new ResponseEntity<>("Reader with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }
}
