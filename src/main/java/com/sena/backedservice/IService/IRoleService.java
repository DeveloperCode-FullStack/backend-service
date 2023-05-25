package com.sena.backedservice.IService;

import java.util.List;
import java.util.Optional;

import com.sena.backedservice.Entity.Role;

public interface IRoleService {
	
	public List<Role> all();
    
    public Optional<Role> findById(Long id);
    
    public Role save(Role role);
    
    public void delete(Long id);
}
