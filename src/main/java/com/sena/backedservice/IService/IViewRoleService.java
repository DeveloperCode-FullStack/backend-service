package com.sena.backedservice.IService;

import java.util.List;
import java.util.Optional;

import com.sena.backedservice.Entity.ViewRole;

public interface IViewRoleService {
	
	public List<ViewRole> all();
    
    public Optional<ViewRole> findById(Long id);
    
    public ViewRole save(ViewRole viewRole);
    
    public void delete(Long id);
}
