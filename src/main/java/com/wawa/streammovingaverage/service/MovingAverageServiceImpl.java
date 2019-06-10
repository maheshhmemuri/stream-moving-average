package com.wawa.streammovingaverage.service;

import com.wawa.streammovingaverage.config.AppProperties;
import com.wawa.streammovingaverage.exceptions.StrategyNotFoundException;
import com.wawa.streammovingaverage.utilities.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/*
Author : Mahesh Melmuri
Date : 6/7/2019
Description: service to implement moving average business logic
*/
@Service
public class MovingAverageServiceImpl implements IMovingAverageService {

    @Autowired
    private AppProperties properties;

    private final Queue<Double> streamData = new ArrayDeque<>();
    public Double sum;

    public MovingAverageServiceImpl()
    {
        this.sum = 0.0;
    }


    @Override
    public Double calculateMovingAverage(Double price, String strategy) {
        int period = properties.getPeriod();
        Double determinedPrice = calculatePrice(strategy,price);
        sum += determinedPrice;
        streamData.add(determinedPrice);
        if(streamData.size() > period )
        {
            sum -= streamData.remove();
        }
        return Util.round((sum/period),3);
    }

    public Double calculatePrice(String strategy, Double price) {

        Double rate = getRate(strategy);
        return price * rate;
    }

    private Double getRate(String strategy) {
        Double rate = properties.getStrategy().get(strategy);
        if (rate == null)
            throw new StrategyNotFoundException("Rate not found for the strategy :" + strategy);
        return rate;
    }

}
