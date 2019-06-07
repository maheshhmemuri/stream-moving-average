package com.wawa.streammovingaverage.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;


/*
Author : Mahesh Melmuri
Date : 6/7/2019
Description: Json payload to event object mapper
*/

@Getter
@Setter
@ToString
public class Event {

    @NotNull(message = "please pass the id")
    @Min(value = 1, message ="Id should be more than 1")
    @Max(value = Long.MAX_VALUE)
    private Long id;

    @NotNull(message = "please pass the price")
    @Min(value = 1, message ="price cannot be zero")
    private Double price;

    @NotBlank(message ="Strategy cannot be blank")
    private String strategy;

    @NotBlank(message ="Category cannot be blank")
    private String category;
}
