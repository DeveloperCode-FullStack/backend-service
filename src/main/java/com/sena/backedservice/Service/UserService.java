package com.sena.backedservice.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.backedservice.Dto.ILoginDto;
import com.sena.backedservice.Dto.IPermissionDto;
import com.sena.backedservice.Entity.User;
import com.sena.backedservice.IRepository.IUserRepository;
import com.sena.backedservice.IService.IUserService;

@Service
public class UserService implements IUserService{

	@Autowired
	private IUserRepository repository;
	
	@Override
	public List<User> all() {
		return repository.findAll();
	}

	@Override
	public Optional<User> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public User save(User user) {
		return repository.save(user);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<IPermissionDto> getPermission(String user, String password) {
		return repository.getPermission(user, password);
	}

	@Override
	public Optional<ILoginDto> getLogin(String user, String password) {
		return repository.getLogin(user, password);
	}	
}
