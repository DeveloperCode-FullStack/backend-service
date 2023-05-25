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

import com.sena.backedservice.Dto.ILoginDto;
import com.sena.backedservice.Dto.IPermissionDto;
import com.sena.backedservice.Entity.User;
import com.sena.backedservice.Service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/security/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping
	public List<User> all() {
		return service.all();
	}
	
	@GetMapping("{id}")
	public Optional<User> show(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public User save(@RequestBody User user) {
		return service.save(user);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public User update(@PathVariable Long id, @RequestBody User user) {
		Optional<User> op = service.findById(id);
		
		if (!op.isEmpty()) {
			User usersUpdate = op.get();
			BeanUtils.copyProperties(user, usersUpdate, "id");
            return service.save(usersUpdate);
		}
		
		return user;
	}
	
	@GetMapping("/permission/{user}/{password}")
	public List<IPermissionDto> getPermission(@PathVariable String user, String password) {
		return service.getPermission(user, password);
	}
	
	@GetMapping("/login/{user}/{password}")
	public Optional<ILoginDto> getLogin(@PathVariable String user, String password) {
		return service.getLogin(user, password);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
