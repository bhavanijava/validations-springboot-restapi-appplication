package com.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dto.CustomerDTO;
import com.web.exception.CustomerNameNotFoundException;
import com.web.exception.CustomerNotFoundException;
import com.web.model.Customer;
import com.web.repo.CustomerRepo;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	private CustomerRepo repo;
	
	@Override
	public Customer saveCustomer(CustomerDTO customerDTO) {
		return repo.save(CustomerDTO.prepareCustomer(customerDTO));
	}

	@Override
	public List<Customer> getAllCustomer() {
		return repo.findAll();
	}

	@Override
	public Customer getCustomer(Integer customerId) throws CustomerNotFoundException{
		
		Optional<Customer> found = repo.findById(customerId);
		if (found.isPresent()) {
			return found.get();
		}else{
			throw new CustomerNotFoundException("This Customer No " + customerId + " does not exists");
		}
	}

	

	@Override
	public Customer findByName(String name) throws CustomerNameNotFoundException {
		Optional<Customer> found = repo.findByName(name);
		if (found.isPresent()) {
			return found.get();
		}else{
			throw new CustomerNameNotFoundException("This Customer Name " + name + " does not exists");
		}
	}


	
}

