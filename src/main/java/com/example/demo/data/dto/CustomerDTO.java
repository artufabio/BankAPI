package com.example.demo.data.dto;

import com.example.demo.data.model.Customer;

public class CustomerDTO {
	
	private Integer id;
	private String firstName;
	private String lastName;
	private String dob;
	private String nationality;
	private String address;
	private String email;
	private Integer account;
	private Integer startingBalance;
	
	public CustomerDTO() {}
	
	public CustomerDTO(Customer customer) {
		this.id = customer.getId();
		this.firstName = customer.getFirstName();
		this.lastName = customer.getLastName();
		this.dob = customer.getDob();
		this.nationality = customer.getNationality();
		this.address = customer.getAddress();
		this.email = customer.getEmail();
		this.account = customer.getAccount();
		this.startingBalance = customer.getStartingBalance();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAccount() {
		return account;
	}

	public void setAccount(Integer account) {
		this.account = account;
	}

	public Integer getStartingBalance() {
		return startingBalance;
	}

	public void setStartingBalance(Integer startingBalance) {
		this.startingBalance = startingBalance;
	}
	
	

}
