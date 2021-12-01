package com.example.demo.service;

import java.util.List;
import java.util.Optional;

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
	
	public void deleteCustomer(Integer id) {
		boolean exists = this.repo.existsById(id);
		if (!exists) {
			throw new IllegalStateException("Customer with id "+ id +"does not exist" );
		} else {
			this.repo.deleteById(id);
		}
	}
	
	public Customer updateCustomer(Customer customer, Integer id) {
//		find the customer to update
		Optional<Customer> customerToFind = this.repo.findById(id);
		Customer customerToUpdate = customerToFind.get();
		
        //set that customer with the new values
		customerToUpdate.setAccount(customer.getAccount());
		customerToUpdate.setAddress(customer.getAddress());
		customerToUpdate.setDob(customer.getDob());
		customerToUpdate.setEmail(customer.getEmail());
		customerToUpdate.setFirstName(customer.getFirstName());
		customerToUpdate.setLastName(customer.getLastName());
		customerToUpdate.setNationality(customer.getNationality());
		customerToUpdate.setPassword(customer.getPassword());
		customerToUpdate.setUsername(customer.getUsername());
		customerToUpdate.setStartingBalance(customer.getStartingBalance());
		
        //save updated customer
        return this.repo.save(customerToUpdate);
	}
	
	public Customer getCustomerById(Integer id) {
		Optional<Customer> customerToFind = this.repo.findById(id);
		Customer found = customerToFind.get();
		return found;
	}
	
	public List<Customer> getHighBalanceCustomers(){
		return this.repo.getHighBalanceCustomers();
	}
	
	public List<Customer> getLowBalanceCustomers(){
		return this.repo.getLowBalanceCustomers();
	}
}
