package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.data.model.Customer;
import com.example.demo.repo.CustomerRepo;

@Service
public class CustomerService {

	private CustomerRepo repo;
	
	public CustomerService(CustomerRepo repo) {
		this.repo = repo;
	}
	
	public Customer createCustomer(Customer customer) {
		return this.repo.save(customer);
	}
	
	public List<Customer> getAllCustomers() {
		return this.repo.findAll();
	}
}
