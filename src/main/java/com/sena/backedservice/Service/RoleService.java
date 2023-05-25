package com.sena.backedservice.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.backedservice.Entity.Role;
import com.sena.backedservice.IRepository.IRoleRepository;
import com.sena.backedservice.IService.IRoleService;

@Service
public class RoleService implements IRoleService{

	@Autowired
	private IRoleRepository repository;
	
	@Override
	public List<Role> all() {
		return repository.findAll();
	}

	@Override
	public Optional<Role> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Role save(Role role) {
		return repository.save(role);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
