package com.probstin.zoopervisorapi.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.probstin.zoopervisorapi.model.ApiException;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ApiRequestException.class)
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
        ApiException apiException = new ApiException(e.getMessage(), BAD_REQUEST, new Date());
        return new ResponseEntity<Object>(apiException, BAD_REQUEST);
    }

}
