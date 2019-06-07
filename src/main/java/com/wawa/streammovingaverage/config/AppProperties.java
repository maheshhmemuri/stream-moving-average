package com.wawa.streammovingaverage.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/*
Author : Mahesh Melmuri
Date : 6/7/2019
Description: properties class to read the config
*/

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    private Integer period;
    private Map<String, Double> strategy;

}
