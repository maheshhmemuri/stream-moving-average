package com.wawa.streammovingaverage.controller;

import com.wawa.streammovingaverage.dto.Event;
import com.wawa.streammovingaverage.dto.MovingAverageResponse;
import com.wawa.streammovingaverage.exceptions.StreamServiceException;
import com.wawa.streammovingaverage.service.IMovingAverageService;
import com.wawa.streammovingaverage.validations.ValidateEvent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/*
Author : Mahesh Melmuri
Date : 6/7/2019
Description: Controller to handle the Rest requests
*/

@RestController
@Api(value ="Calculating moving average of streams ", description = "Operations pertaining to system ")
public class StreamController {
    //Logger
    private static final Logger LOG = LoggerFactory.getLogger(StreamController.class);

    @Autowired
    IMovingAverageService movingAverageService;

    @PostMapping(value = "/events", consumes = "Application/json", produces = "Application/json")
    @ApiOperation(value = "add new event it returns moving average", response = MovingAverageResponse.class)
    private ResponseEntity<MovingAverageResponse> updateStream(
            @ApiParam(value ="Event json adds into stream", required = true)
            @RequestBody @Valid Event event)
    {
        MovingAverageResponse movingAverageResponse = new MovingAverageResponse();
        Double movingAverage = 0.0;
        movingAverageResponse.setMovingAverage(movingAverage);
        try
        {
            movingAverage =   movingAverageService.calculateMovingAverage(event.getPrice(),event.getStrategy());
        }catch (StreamServiceException e)
        {
            return new ResponseEntity<>(movingAverageResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        movingAverageResponse.setMovingAverage(movingAverage);
        LOG.info("event got added to stream and moving average: " +movingAverage);
        return new ResponseEntity<>(movingAverageResponse, HttpStatus.CREATED);
    }

}
