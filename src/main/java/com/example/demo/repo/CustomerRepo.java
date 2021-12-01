package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}