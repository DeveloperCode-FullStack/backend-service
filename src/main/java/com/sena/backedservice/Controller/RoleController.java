package com.sena.backedservice.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sena.backedservice.Entity.Role;
import com.sena.backedservice.IService.IRoleService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/security/role")
public class RoleController {

	@Autowired
	private IRoleService service;
	
	@GetMapping
	public List<Role> all() {
		return service.all();
	}
	
	@GetMapping("{id}")
	public Optional<Role> show(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Role save(@RequestBody Role role) {
		return service.save(role);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Role update(@PathVariable Long id, @RequestBody Role role) {
		Optional<Role> op = service.findById(id);
		
		if (!op.isEmpty()) {
			Role rolesUpdate = op.get();
			BeanUtils.copyProperties(role, rolesUpdate, "id");
            return service.save(rolesUpdate);
		}
		
		return role;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	
	
	
}
