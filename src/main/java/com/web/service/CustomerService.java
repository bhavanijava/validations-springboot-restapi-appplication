package com.web.service;

import java.util.List;

import com.web.dto.CustomerDTO;
import com.web.exception.CustomerNameNotFoundException;
import com.web.exception.CustomerNotFoundException;
import com.web.model.Customer;

public interface CustomerService {

	public Customer saveCustomer(CustomerDTO customerDTO);
	public List<Customer> getAllCustomer();
	public Customer getCustomer(Integer customerId) throws CustomerNotFoundException;
	public Customer findByName(String name) throws CustomerNameNotFoundException;

}
