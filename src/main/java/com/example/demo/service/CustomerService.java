package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repo.CustomerRepo;

@Service
public class CustomerService {

	private CustomerRepo repo;
	
	public CustomerService(CustomerRepo repo) {
		this.repo = repo;
	}
}
