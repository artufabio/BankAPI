package com.example.demo.controllers_test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

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

import com.example.demo.data.dto.CustomerDTO;
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
		String testCustomerAsJsonResponse = this.mapper.writeValueAsString(
				new Customer(3, "Elvis", "Presley", "1948-12-04", "American", "Regent Street 103", "email@gmail.com", 123456, 120000, "elvis25", "secret123"));
		
		RequestBuilder request = post("/customer/create").contentType(MediaType.APPLICATION_JSON).content(testCustomerAsJson);
		
		ResultMatcher status = MockMvcResultMatchers.status().isCreated();
		ResultMatcher content = MockMvcResultMatchers.content().json(testCustomerAsJsonResponse);
		
		this.mvc.perform(request).andExpect(status).andExpect(content);
	}
	
	@Test
	void getAllCustomersDTOTest() throws Exception{
		Customer c1 = new Customer(1, "Elvis", "Presley", "1948-12-04", "American", "Regent Street 103", "email@gmail.com", 123456, 120000, "elvis25", "secret123");
		Customer c2 = new Customer(2, "Freddy", "Mercury", "1984-01-08", "British", "Regent Street 301", "email2@gmail.com", 654321, 1200, "freddy25", "secret456");
		String listOfCustomersDTOAsJson = this.mapper.writeValueAsString(List.of(
				new CustomerDTO(c1),
				new CustomerDTO(c2)
				));
		
		RequestBuilder request = get("/customer");
		
		ResultMatcher status = MockMvcResultMatchers.status().isOk();
		ResultMatcher content = MockMvcResultMatchers.content().json(listOfCustomersDTOAsJson);
		
		this.mvc.perform(request).andExpect(status).andExpect(content);
	}
	
	@Test
	void deleteCustomerTest() throws Exception {
		this.mvc.perform(delete("/customer/delete/1")).andExpect(status().isOk());
	}
	
	@Test
	void updateCustomerTest() throws Exception{
		String updatedCustomerAsJson = this.mapper.writeValueAsString(new Customer(1, "Bob", "Marley", "1948-12-04", "American", "Regent Street 103", "email@gmail.com", 123456, 120000, "elvis25", "secret123"));
		
		RequestBuilder request = put("/customer/update/1").contentType(MediaType.APPLICATION_JSON).content(updatedCustomerAsJson);
		
		ResultMatcher status = MockMvcResultMatchers.status().isAccepted();
		ResultMatcher content = MockMvcResultMatchers.content().json(updatedCustomerAsJson);
		
		this.mvc.perform(request).andExpect(status).andExpect(content);
	}
	
	@Test
	void getCustomerDTOByIdTest() throws Exception{
		String customerDTOAsJson = this.mapper.writeValueAsString(
				new CustomerDTO(
						new Customer(1, "Elvis", "Presley", "1948-12-04", "American", "Regent Street 103", "email@gmail.com", 123456, 120000, "elvis25", "secret123")
						));
		
		RequestBuilder request = get("/customer/1");
		
		ResultMatcher status = MockMvcResultMatchers.status().isOk();
		ResultMatcher content = MockMvcResultMatchers.content().json(customerDTOAsJson);
		
		this.mvc.perform(request).andExpect(status).andExpect(content);
	}
	
	@Test
	void getHighBalanceCustomersDTOTest() throws Exception{
		String listOfCustomersDTOAsJson = this.mapper.writeValueAsString(List.of(
				new CustomerDTO(
						new Customer(1, "Elvis", "Presley", "1948-12-04", "American", "Regent Street 103", "email@gmail.com", 123456, 120000, "elvis25", "secret123")
				)));
		
		RequestBuilder request = get("/customer/high-balance");
		
		ResultMatcher status = MockMvcResultMatchers.status().isOk();
		ResultMatcher content = MockMvcResultMatchers.content().json(listOfCustomersDTOAsJson);
		
		this.mvc.perform(request).andExpect(status).andExpect(content);
	}
	
	@Test
	void getLowBalanceCustomersDTOTest() throws Exception{
		String listOfCustomersDTOAsJson = this.mapper.writeValueAsString(List.of(
				new CustomerDTO(
						new Customer(2, "Freddy", "Mercury", "1984-01-08", "British", "Regent Street 301", "email2@gmail.com", 654321, 1200, "freddy25", "secret456")
				)));
		
		RequestBuilder request = get("/customer/low-balance");
		
		ResultMatcher status = MockMvcResultMatchers.status().isOk();
		ResultMatcher content = MockMvcResultMatchers.content().json(listOfCustomersDTOAsJson);
		
		this.mvc.perform(request).andExpect(status).andExpect(content);
	}
}