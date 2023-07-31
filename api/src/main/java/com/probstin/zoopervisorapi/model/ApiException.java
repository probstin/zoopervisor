package com.probstin.zoopervisorapi.model;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ApiException {
    private final String message;
    private final HttpStatus httpStatus;
    private final Date timestamp;

    public ApiException(String message, HttpStatus httpStatus, Date timestamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public Date getTimestamp() {
        return timestamp;
    }

}
