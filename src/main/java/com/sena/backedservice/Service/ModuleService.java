package com.sena.backedservice.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.backedservice.Entity.Module;
import com.sena.backedservice.IRepository.IModuleRepository;
import com.sena.backedservice.IService.IModuleService;

@Service
public class ModuleService implements IModuleService{
	
	@Autowired
	private IModuleRepository repository;

	@Override
	public List<Module> all() {		
		return repository.findAll();
	}

	@Override
	public Optional<Module> findById(Long id) {		
		return repository.findById(id);
	}

	@Override
	public Module save(Module module) {
		return repository.save(module);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);		
	}
}
