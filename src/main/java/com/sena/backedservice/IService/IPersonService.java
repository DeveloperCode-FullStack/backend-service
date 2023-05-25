package com.sena.backedservice.IService;

import java.util.List;
import java.util.Optional;

import com.sena.backedservice.Entity.Person;

public interface IPersonService {
	
	public List<Person> all();
    
    public Optional<Person> findById(Long id);
    
    public Person save(Person person);
    
    public void delete(Long id);
}
