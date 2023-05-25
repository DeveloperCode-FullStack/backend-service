package com.sena.backedservice.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.backedservice.Entity.Person;
import com.sena.backedservice.IRepository.IPersonRepository;
import com.sena.backedservice.IService.IPersonService;

@Service
public class PersonService implements IPersonService {

	@Autowired
	private IPersonRepository repository;
	
	@Override
	public List<Person> all() {
		return repository.findAll();
	}

	@Override
	public Optional<Person> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Person save(Person person) {
		return repository.save(person);
	}

	@Override
	
	public void delete(Long id) {
		repository.deleteById(id);	
	}

}
