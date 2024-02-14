package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.model.Customer;
import com.customer.repo.CustomerRepo;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerRepo repo;
	
	@GetMapping("/test")
	public String home()
	{
		return "Welcome to customer Service";
	}
	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)
	{
		Customer cust = repo.save(customer);
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<List<Customer>> getById(@PathVariable int id)
	{
		List<Customer> customers = repo.findByCompanyId(id);
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}
}
