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

import com.sena.backedservice.Entity.ViewRole;
import com.sena.backedservice.Service.ViewRoleService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/security/viewRole")
public class ViewRoleController {

	@Autowired
	private ViewRoleService service;
	
	@GetMapping
	public List<ViewRole> all() {
		return service.all();
	}
	
	@GetMapping("{id}")
	public Optional<ViewRole> show(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ViewRole save(@RequestBody ViewRole viewRole) {
		return service.save(viewRole);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ViewRole update(@PathVariable Long id, @RequestBody ViewRole viewRole) {
		Optional<ViewRole> op = service.findById(id);
		
		if (!op.isEmpty()) {
			ViewRole viewsRolesUpdate = op.get();
			BeanUtils.copyProperties(viewRole, viewsRolesUpdate, "id");
            return service.save(viewsRolesUpdate);
		}
		
		return viewRole;
	}
	
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	
}
