package com.wawa.streammovingaverage.dto;

import lombok.Getter;
import lombok.Setter;

/*
Author : Mahesh Melmuri
Date : 6/7/2019
Description: Response object to map return to http requests
*/

@Getter
@Setter
public class MovingAverageResponse {
    private Double movingAverage;
}
