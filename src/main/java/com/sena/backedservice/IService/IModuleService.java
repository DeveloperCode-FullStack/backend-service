package com.sena.backedservice.IService;

import java.util.List;
import java.util.Optional;

import com.sena.backedservice.Entity.Module;

public interface IModuleService {
	
	public List<Module> all();
	    
    public Optional<Module> findById(Long id);
    
    public Module save(Module module);
    
    public void delete(Long id);
}
