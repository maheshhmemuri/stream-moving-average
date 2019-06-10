package com.wawa.streammovingaverage.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StrategyNotFoundException extends RuntimeException{

    public StrategyNotFoundException(String message)
    {
        super(message);
    }
}
