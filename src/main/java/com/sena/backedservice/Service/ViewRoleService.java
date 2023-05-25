package com.sena.backedservice.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.backedservice.Entity.ViewRole;
import com.sena.backedservice.IRepository.IViewRoleRepository;
import com.sena.backedservice.IService.IViewRoleService;

@Service
public class ViewRoleService implements IViewRoleService{

	@Autowired
	private IViewRoleRepository repository;
	
	@Override
	public List<ViewRole> all() {
		return repository.findAll();
	}

	@Override
	public Optional<ViewRole> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public ViewRole save(ViewRole viewRole) {
		return repository.save(viewRole);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
