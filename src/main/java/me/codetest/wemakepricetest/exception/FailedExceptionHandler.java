package me.codetest.wemakepricetest.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FailedExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> Failed(Exception e) {
        return ResponseEntity.badRequest().body(new ErrorMessage(e.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorMessage> argumentFailedException(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(new ErrorMessage(e.getMessage()));
    }

    @ExceptionHandler(FailedUrlLoaderException.class)
    public ResponseEntity<ErrorMessage> urlLoadFailedException(FailedUrlLoaderException e) {
        return ResponseEntity.badRequest().body(new ErrorMessage(e.getMessage()));
    }
}
