package com.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.dto.CustomerDTO;
import com.web.exception.CustomerNameNotFoundException;
import com.web.exception.CustomerNotFoundException;
import com.web.model.Customer;
import com.web.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@PostMapping("/save")
	public Customer saveCustomer(@RequestBody @Valid CustomerDTO customerDTO)
	{
		return service.saveCustomer(customerDTO);
	}
	
	@GetMapping("/fetchAll")
	public List<Customer> getAllCustomers()
	{
		return service.getAllCustomer();
	}
	
	@GetMapping("/fetch/{customerId}")
	public Customer fetchCustomer(@PathVariable Integer customerId) throws CustomerNotFoundException
	{
		return service.getCustomer(customerId);
	}
	
	@GetMapping("/fetchName/{name}")
	public Customer fetchCustomerName(@PathVariable String name) throws CustomerNameNotFoundException 
	{
		return service.findByName(name);
	}
	
	
}
