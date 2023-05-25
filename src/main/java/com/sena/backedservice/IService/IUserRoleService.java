package com.sena.backedservice.IService;

import java.util.List;
import java.util.Optional;

import com.sena.backedservice.Entity.UserRole;

public interface IUserRoleService {
	
	public List<UserRole> all();
    
    public Optional<UserRole> findById(Long id);
    
    public UserRole save(UserRole userRole);
    
    public void delete(Long id);
}
