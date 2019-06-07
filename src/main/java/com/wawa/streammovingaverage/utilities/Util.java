package com.wawa.streammovingaverage.utilities;

import java.math.BigDecimal;
import java.math.RoundingMode;
/*
Author : Mahesh Melmuri
Date : 6/7/2019
Description: Util to define utilities being used in application
*/

public class Util {

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
