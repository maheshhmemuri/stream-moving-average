package com.wawa.streammovingaverage.controller;

import com.wawa.streammovingaverage.dto.Event;
import com.wawa.streammovingaverage.dto.MovingAverageResponse;
import com.wawa.streammovingaverage.service.IMovingAverageService;


import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamControllerTest {

    @Autowired
    IMovingAverageService movingAverageService;

    private Event event;


    @Test
    public void whenRequestSuccess_thenReturnOkResponse() throws URISyntaxException {

        TestRestTemplate testRestTemplate = new TestRestTemplate();
        final String baseUrl = "http://localhost:"+8082+"/events";
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        headers.set("Content-Type","application/json");

        event = new Event();
        event.setPrice(23.0);
        event.setStrategy("gold");
        event.setCategory("green");
        event.setId(10L);

        HttpEntity<Event> request = new HttpEntity<>(event, headers);

        ResponseEntity<MovingAverageResponse> response = testRestTemplate.postForEntity(uri, request, MovingAverageResponse.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void whenRequestFails_thenReturnBadRequestResponse() throws URISyntaxException {

        TestRestTemplate testRestTemplate = new TestRestTemplate();
        final String baseUrl = "http://localhost:"+8082+"/events";
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        headers.set("Content-Type","application/json");

        event = new Event();
        event.setStrategy("gold");
        event.setCategory("green");
        event.setId(10L);

        HttpEntity<Event> request = new HttpEntity<>(event, headers);

        ResponseEntity<MovingAverageResponse> response = testRestTemplate.postForEntity(uri, request, MovingAverageResponse.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }


}
