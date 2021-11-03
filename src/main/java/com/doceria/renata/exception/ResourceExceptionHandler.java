package com.doceria.renata.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ErrorApiException.class)
    public ResponseEntity<StandardError> genericError(ErrorApiException e, HttpServletRequest request) {
        StandardError err = new StandardError(e.getHttpStatus().value(), e.getReason(), System.currentTimeMillis());
        return ResponseEntity.status(e.getHttpStatus()).body(err);
    }
}
