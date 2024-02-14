package com.product.controller;

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
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.product.entity.Customer;
import com.product.entity.RequiredResponse;
import com.product.model.Product;
import com.product.repo.ProductRepo;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepo repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/test")
	public String home()
	{
		return "Welcome to Product Service";
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<Product> addProduct(@RequestBody Product product)
	{
		double p = product.getPrice() * product.getQuantity();
		double disc = p * 5 / 100;
		double t = p - disc;
		product.setDiscount(disc);
		product.setTotal(t);
		Product newProd = repo.save(product);
		return new ResponseEntity<>(newProd, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/get/{id}")
	@HystrixCommand(fallbackMethod="handleCustomerDownTime")
	public ResponseEntity<RequiredResponse> getData(@PathVariable int id)
	{
		RequiredResponse requiredResponse = new RequiredResponse();
		Product prod = repo.findById(id).get();
		requiredResponse.setProduct(prod);
		
		List<Customer> list = restTemplate.getForObject("http://CUSTOMER-SERVICE/customer/get/"+id, List.class);
		requiredResponse.setCustomer(list);
		
		return new ResponseEntity<RequiredResponse>(requiredResponse, HttpStatus.OK);
	}
	public ResponseEntity<RequiredResponse> handleCustomerDownTime(@PathVariable int id)
	{
		RequiredResponse response = new RequiredResponse();
		Product prod = repo.findById(id).get();
		response.setProduct(prod);
		
		return new ResponseEntity<RequiredResponse>(response, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/getData/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable int id)
	{
		Product prod = repo.findByBankId(id);
		return new ResponseEntity<Product>(prod, HttpStatus.OK);
	}
}
