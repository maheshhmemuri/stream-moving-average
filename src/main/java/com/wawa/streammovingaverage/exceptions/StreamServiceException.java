package com.wawa.streammovingaverage.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
Author : Mahesh Melmuri
Date : 6/7/2019
Description: To handle service run time Exception
*/

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class StreamServiceException extends RuntimeException {
    public StreamServiceException(String message)
    {
        super(message);
    }

}
