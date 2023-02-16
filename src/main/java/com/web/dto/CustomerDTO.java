package com.web.dto;

import javax.validation.constraints.Email;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.web.model.Customer;

public class CustomerDTO {

	@NotNull(message="Customer Name Should not be null")
	@NotEmpty(message="Customer Name Should not be null")
	private String name;
	@Email
	private String email;
	@NotNull
	private String gender;
	@Min(18)
	@Max(60)
	private Integer age;
	@NotBlank(message="Nationality should not be blank")
	private String nationality;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public static Customer prepareCustomer(CustomerDTO customerDTO)
	{
		Customer customer=new Customer();
		
		customer.setName(customerDTO.getName());
		customer.setEmail(customerDTO.getEmail());
		customer.setGender(customerDTO.getGender());
		customer.setAge(customerDTO.getAge());
		customer.setNationality(customerDTO.getNationality());
		return customer;
		
	}
}
