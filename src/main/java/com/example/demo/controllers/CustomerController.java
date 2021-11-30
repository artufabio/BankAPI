package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping(path="/customer")
public class CustomerController {

	private CustomerService service;
	
	public CustomerController(CustomerService service) {
		this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
		ResponseEntity<Customer> response = new ResponseEntity<Customer>(this.service.createCustomer(customer), HttpStatus.CREATED);
		return response;
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers(){
		return new ResponseEntity<List<Customer>>(this.service.getAllCustomers(), HttpStatus.OK);
	}
}
