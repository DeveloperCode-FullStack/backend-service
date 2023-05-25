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

import com.sena.backedservice.Entity.UserRole;
import com.sena.backedservice.Service.UserRoleService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/security/userRole")
public class UserRoleController {
	
	@Autowired
	private UserRoleService service;
	
	@GetMapping
	public List<UserRole> all() {
		return service.all();
	}

	@GetMapping("{id}")
	public Optional<UserRole> show(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public UserRole save(@RequestBody UserRole userRole) {
		return service.save(userRole);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public UserRole update(@PathVariable Long id, @RequestBody UserRole userRole) {
		Optional<UserRole> op = service.findById(id);
		
		if (!op.isEmpty()) {
			UserRole userRolesUpdate = op.get();
			BeanUtils.copyProperties(userRole, userRolesUpdate, "id");
            return service.save(userRolesUpdate);
		}
		
		return userRole;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
}
