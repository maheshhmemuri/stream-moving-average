package com.wawa.streammovingaverage.service;

import java.util.Map;

/*
Author : Mahesh Melmuri
Date : 6/7/2019
Description: interface to service class
*/

public interface IMovingAverageService {
    Double calculateMovingAverage(Double price, String Strategy);
}
