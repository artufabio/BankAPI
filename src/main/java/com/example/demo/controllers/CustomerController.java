package com.example.demo.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.dto.CustomerDTO;
import com.example.demo.data.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping(path="/customer")
public class CustomerController {

	private CustomerService service;
	
	public CustomerController(CustomerService service, ModelMapper mapper) {
		this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
		ResponseEntity<Customer> response = new ResponseEntity<Customer>(this.service.createCustomer(customer), HttpStatus.CREATED);
		return response;
	}
	
	@GetMapping
	public ResponseEntity<List<CustomerDTO>> getAllCustomersDTO(){
		return new ResponseEntity<List<CustomerDTO>>(this.service.getAllCustomersDTO(), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable Integer id) {
		this.service.deleteCustomer(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable Integer id) {
        ResponseEntity<Customer> response = new ResponseEntity<Customer>(this.service.updateCustomer(customer, id), HttpStatus.ACCEPTED); // 202
        return response;
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDTO> getCustomerDTOById(@PathVariable Integer id){
		return new ResponseEntity<CustomerDTO>(this.service.getCustomerDTOById(id), HttpStatus.OK);
	}
	
	@GetMapping("/high-balance")
	public ResponseEntity<List<CustomerDTO>> getHighBalanceCustomersDTO(){
		return new ResponseEntity<List<CustomerDTO>>(this.service.getHighBalanceCustomersDTO(), HttpStatus.OK);
	}
	
	@GetMapping("/low-balance")
	public ResponseEntity<List<CustomerDTO>> getLowBalanceCustomersDTO(){
		return new ResponseEntity<List<CustomerDTO>>(this.service.getLowBalanceCustomersDTO(), HttpStatus.OK);
	}
}
