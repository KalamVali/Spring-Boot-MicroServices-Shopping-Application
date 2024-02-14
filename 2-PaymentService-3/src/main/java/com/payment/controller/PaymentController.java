package com.payment.controller;




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
import com.payment.entity.Customer;
import com.payment.entity.Product;
import com.payment.entity.RequiredResponse;
import com.payment.model.Payment;
import com.payment.repo.PaymentRepo;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentRepo repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/test")
	public String home()
	{
		return "Welcome to Payment Service";
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<Payment> addPayment(@RequestBody Payment payment)
	{
		Payment add = repo.save(payment);
		return new ResponseEntity<Payment>(add, HttpStatus.OK);
	}
	
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Payment> getPayment(@PathVariable int id)
	{
		Payment getOne = repo.findById(id).get();
		return new ResponseEntity<Payment>(getOne, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/getData/{bankId}")
	@HystrixCommand(fallbackMethod = "handleProductDownTime")
	public ResponseEntity<RequiredResponse> getData(@PathVariable int bankId)
	{
		RequiredResponse response = new RequiredResponse();
		Payment get = repo.findById(bankId).get();
		response.setPayment(get);
		
		Product prod = restTemplate.getForObject("http://PRODUCT-SERVICE/product/getData/"+ bankId, Product.class);
		response.setProducts(prod);
		
		List<Customer> cust = restTemplate.getForObject("http://CUSTOMER-SERVICE/customer/get/"+ prod.getCompanyId(), List.class);
		response.setCustomers(cust);
		
		return new ResponseEntity<RequiredResponse>(response, HttpStatus.OK);
	}
	public ResponseEntity<RequiredResponse> handleProductDownTime(@PathVariable int bankId)
	{
		RequiredResponse response = new RequiredResponse();
		Payment get = repo.findById(bankId).get();
		response.setPayment(get);
		
		return new ResponseEntity<RequiredResponse>(response, HttpStatus.OK);
	}
}
