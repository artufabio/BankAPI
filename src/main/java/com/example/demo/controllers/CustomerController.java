package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CustomerService;

@RestController
@RequestMapping(path="/customer")
public class CustomerController {

	private CustomerService service;
	
	public CustomerController(CustomerService service) {
		this.service = service;
	}
}
