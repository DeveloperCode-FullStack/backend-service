package com.sena.backedservice.IService;

import java.util.List;
import java.util.Optional;

import com.sena.backedservice.Dto.ILoginDto;
import com.sena.backedservice.Dto.IPermissionDto;
import com.sena.backedservice.Entity.User;

public interface IUserService {
	
	public List<User> all();
    
    public Optional<User> findById(Long id);
    
    public User save(User user);
    
    public void delete(Long id);
    
    public List<IPermissionDto> getPermission(String user, String password);
    
    public Optional<ILoginDto> getLogin(String user, String password);
}
