package com.library.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException exception) {
        return new ResponseEntity<>("User with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Object> handleBookNotFoundException(BookNotFoundException exception) {
        return new ResponseEntity<>("Book with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BookCopyNotFoundException.class)
    public ResponseEntity<Object> handleBookCopyNotFoundException(BookCopyNotFoundException exception) {
        return new ResponseEntity<>("Book copy with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BookStatusNotFoundException.class)
    public ResponseEntity<Object> handleBookStatusNotFoundException(BookStatusNotFoundException exception) {
        return new ResponseEntity<>("Book status with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }
}
