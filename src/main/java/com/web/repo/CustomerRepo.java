package com.web.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {


	public Optional<Customer> findByName(String name);
}
