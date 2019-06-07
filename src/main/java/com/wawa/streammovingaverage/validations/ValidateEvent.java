package com.wawa.streammovingaverage.validations;

import com.wawa.streammovingaverage.dto.Event;

/*
Author : Mahesh Melmuri
Date : 6/7/2019
Description: Supporting class if any further validation required
             its sample class as of now, same can be called in controller
*/

public class ValidateEvent {

    public static boolean validateEventPayload(Event event)
    {
        if(event.getPrice() == null)
            return false;
        if(event.getStrategy() == null)
            return false;
        if(event.getId() == null)
            return false;
        if(event.getCategory() == null)
            return false;
        return true;
    }
}
