package com.redpill.mule.http;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.redpill.mule.http.HttpTest.TestApplication;


/**
 * Simple test for Mule with a HTTP Endpoint
 * 
 * @author Dennis Schulte
 */
@SpringApplicationConfiguration(classes = TestApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@IntegrationTest("mule.config=mule-http-config.xml")
public class HttpTest {

	@Test
	public void testHttpRequest() {
		// Given
		// When
		ResponseEntity<String> response = new TestRestTemplate().getForEntity("http://localhost:8081/echo", String.class);
		// Then
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("/echo", response.getBody());
	}
	
	@Configuration
	@EnableAutoConfiguration
	public static class TestApplication {
	}

}
