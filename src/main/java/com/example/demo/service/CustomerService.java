package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.data.dto.CustomerDTO;
import com.example.demo.data.model.Customer;
import com.example.demo.repo.CustomerRepo;

@Service
public class CustomerService {

	private CustomerRepo repo;
	
	private ModelMapper mapper;
	
	public CustomerService(CustomerRepo repo, ModelMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}
	
//	use MethodMapper to convert a Customer to a CustomerDTO
	private CustomerDTO mapToDTO(Customer customer) {
		return this.mapper.map(customer, CustomerDTO.class);
	}
	
	public List<CustomerDTO> getAllCustomersDTO(){
		return this.repo.findAll().stream().map(customer -> this.mapToDTO(customer)).collect(Collectors.toList());
	}
	
	public Customer createCustomer(Customer customer) {
		return this.repo.save(customer);
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
	
	public CustomerDTO getCustomerDTOById(Integer id) {
		Optional<Customer> customerToFind = this.repo.findById(id);
		Customer found = customerToFind.get();
		return this.mapToDTO(found);
	}
	
	public List<CustomerDTO> getHighBalanceCustomersDTO(){
		return this.repo.getHighBalanceCustomers().stream().map(customer -> this.mapToDTO(customer)).collect(Collectors.toList());
	}
	
	public List<CustomerDTO> getLowBalanceCustomersDTO(){
		return this.repo.getLowBalanceCustomers().stream().map(customer -> this.mapToDTO(customer)).collect(Collectors.toList());
	}
}
