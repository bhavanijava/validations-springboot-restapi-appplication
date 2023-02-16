package com.web.advise;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.web.exception.CustomerNameNotFoundException;
import com.web.exception.CustomerNotFoundException;

@RestControllerAdvice
public class ValidationExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleValidationErrors(MethodArgumentNotValidException ex)
	{
		Map<String,String> errorMap=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->{
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return errorMap;
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public Map<String,String> handleCustomerServiceException(CustomerNotFoundException ex)
	{
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("errorMessage", ex.getMessage());
		return errorMap;
	}
	@ExceptionHandler(CustomerNameNotFoundException.class)
	public Map<String,String> handleCustomerNameServiceException(CustomerNameNotFoundException ex)
	{
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("errorMessage", ex.getMessage());
		return errorMap;
	}

	
}
