package com.wawa.streammovingaverage.exceptions;

import com.wawa.streammovingaverage.dto.MovingAverageResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
Author : Mahesh Melmuri
Date : 6/7/2019
Description: Custom Exception handler classes
*/

@ControllerAdvice
@Slf4j
public class StreamServiceErrorAdvice {

    @ExceptionHandler({StreamServiceException.class, Exception.class})
    public ResponseEntity<Object> handleStreamServiceException(StreamServiceException e)
    {
        return error(HttpStatus.INTERNAL_SERVER_ERROR,e);
    }

    private ResponseEntity<Object> error(HttpStatus status, Exception e) {
        log.error("Exception : ", e);
        return ResponseEntity.status(status).body(e.getMessage());
    }
}
