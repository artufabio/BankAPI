package com.example.demo.controllers_test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.data.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:test-schema.sql", "classpath:test-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class CustomerControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void createCustomerTest() throws Exception{
		String testCustomerAsJson = this.mapper.writeValueAsString(
				new Customer(null, "Elvis", "Presley", "1948-12-04", "American", "Regent Street 103", "email@gmail.com", 123456, 120000, "elvis25", "secret123"));
		String testPlayerAsJsonResponse = this.mapper.writeValueAsString(
				new Customer(1, "Elvis", "Presley", "1948-12-04", "American", "Regent Street 103", "email@gmail.com", 123456, 120000, "elvis25", "secret123"));
		
		RequestBuilder request = post("/customer/create").contentType(MediaType.APPLICATION_JSON).content(testCustomerAsJson);
		
		ResultMatcher status = MockMvcResultMatchers.status().isCreated();
		ResultMatcher content = MockMvcResultMatchers.content().json(testPlayerAsJsonResponse);
		
		this.mvc.perform(request).andExpect(status).andExpect(content);
	}
}
