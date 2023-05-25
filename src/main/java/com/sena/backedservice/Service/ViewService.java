package com.sena.backedservice.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.backedservice.Entity.View;
import com.sena.backedservice.IRepository.IViewRepository;
import com.sena.backedservice.IService.IViewService;

@Service
public class ViewService implements IViewService{

	@Autowired
	private IViewRepository repository;
	
	@Override
	public List<View> all() {
		return repository.findAll();
	}

	@Override
	public Optional<View> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public View save(View view) {
		return repository.save(view);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	
	
}
