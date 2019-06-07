package com.wawa.streammovingaverage;

import com.wawa.streammovingaverage.dto.Event;
import com.wawa.streammovingaverage.dto.MovingAverageResponse;
import com.wawa.streammovingaverage.service.IMovingAverageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamMovingAverageApplicationTests {

	@Autowired
	IMovingAverageService movingAverageService;

	private Event event;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testMovingAverageCalculation()
	{
		event = new Event();
		event.setPrice(23.0);
		event.setStrategy("gold");
		event.setCategory("green");
		event.setId(10L);
		assertEquals(movingAverageService.calculateMovingAverage(event.getPrice(),event.getStrategy()),3.68,0.0);
	}
}
