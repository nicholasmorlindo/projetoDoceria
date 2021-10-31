package com.doceria.renata.exception;

import org.springframework.http.HttpStatus;

public class ErrorApiException extends RuntimeException{

    private final HttpStatus httpStatus;

    private final String reason;

    public ErrorApiException(HttpStatus httpStatus, String reason) {
        super(reason);
        this.httpStatus = httpStatus;
        this.reason = reason;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getReason() {
        return reason;
    }
}