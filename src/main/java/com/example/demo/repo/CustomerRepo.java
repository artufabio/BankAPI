package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.data.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	
//	Custom query 
	@Query("select c from customer where c.startingBalance > 10000;")
	List<Customer> getHighBalanceCustomers();
}
