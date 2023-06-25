package com.mybootapp.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybootapp.main.exception.ResourceNotFoundException;
import com.mybootapp.main.model.Customer;
import com.mybootapp.main.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer insert(Customer customer) {
		return customerRepository.save(customer);
	}

	public List<Customer> getAll() {
		return customerRepository.findAll();
	}
	
	public Customer getById(int id) throws ResourceNotFoundException {
		Optional<Customer> optional = customerRepository.findById(id);
		
		if (optional.isEmpty()) {
			throw new ResourceNotFoundException("Invalid ID given");
		}
		
		return optional.get();
	}
	
	public void delete(int id) {
		customerRepository.deleteById(id);
	}

}