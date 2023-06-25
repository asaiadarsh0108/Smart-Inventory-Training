package com.mybootapp.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybootapp.main.exception.ResourceNotFoundException;
import com.mybootapp.main.model.Supplier;
import com.mybootapp.main.repository.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;

	public Supplier insert(Supplier supplier) {
		return supplierRepository.save(supplier);
	}
	
	public List<Supplier> getAll() {
		return supplierRepository.findAll();
	}

	public Supplier getById(int id) throws ResourceNotFoundException {
		Optional<Supplier> optional = supplierRepository.findById(id);
		
		if (optional.isEmpty()) {
			throw new ResourceNotFoundException("Invalid ID given");
		}
		
		return optional.get();
	}
	
	public void delete(int id) {
		supplierRepository.deleteById(id);
	}

}
