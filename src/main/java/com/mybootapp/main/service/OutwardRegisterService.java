package com.mybootapp.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybootapp.main.exception.ResourceNotFoundException;
import com.mybootapp.main.model.OutwardRegister;
import com.mybootapp.main.repository.OutwardRegisterRepository;

@Service
public class OutwardRegisterService {

	@Autowired
	private OutwardRegisterRepository outwardRegisterRepository;

	public OutwardRegister insert(OutwardRegister outwardRegister) {
		return outwardRegisterRepository.save(outwardRegister);
	}

	public List<OutwardRegister> getAll() {
		return outwardRegisterRepository.findAll();
	}
	
	public OutwardRegister getById(int id) throws ResourceNotFoundException {
		Optional<OutwardRegister> optional = outwardRegisterRepository.findById(id);
		
		if (optional.isEmpty()) {
			throw new ResourceNotFoundException("Invalid ID given");
		}
		
		return optional.get();
	}
	
	public void delete(int id) {
		outwardRegisterRepository.deleteById(id);
	}
	
}
