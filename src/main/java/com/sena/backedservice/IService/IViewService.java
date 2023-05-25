package com.sena.backedservice.IService;

import java.util.List;
import java.util.Optional;

import com.sena.backedservice.Entity.View;

public interface IViewService {
	
	public List<View> all();
    
    public Optional<View> findById(Long id);
    
    public View save(View view);
    
    public void delete(Long id);
}
