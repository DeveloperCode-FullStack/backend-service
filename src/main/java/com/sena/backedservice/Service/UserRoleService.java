package com.sena.backedservice.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.backedservice.Entity.UserRole;
import com.sena.backedservice.IRepository.IUserRoleRepository;
import com.sena.backedservice.IService.IUserRoleService;

@Service
public class UserRoleService implements IUserRoleService{

	@Autowired
	private IUserRoleRepository repository;
	
	@Override
	public List<UserRole> all() {
		return repository.findAll();
	}

	@Override
	public Optional<UserRole> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public UserRole save(UserRole userRole) {
		return repository.save(userRole);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);	
	}

}
