package com.boot.springrestapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.boot.springrestapi.Entity.Role;
import com.boot.springrestapi.Service.RoleService;

import jakarta.validation.Valid;

@RestController
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/roles/{id}")
	public ResponseEntity<Role> getRoleById(@PathVariable Long id){
		Role role = roleService.getRoleById(id);
		return new ResponseEntity<>(role, HttpStatus.OK);
	}
	
	@GetMapping("/roles")
	public ResponseEntity<List<Role>> getAllRoles(){
		List<Role> roles= roleService.getAllRoles();
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}
	
	
	@PostMapping("/roles")
	public ResponseEntity<Role> addRole(@Valid @RequestBody Role role){
		Role addedRole = roleService.addRole(role);
		return new ResponseEntity<>(addedRole,HttpStatus.CREATED);
	}
	
	@PutMapping("/roles/{id}")
	public ResponseEntity<Role> updateRole(@PathVariable Long id, @Valid @RequestBody Role role){
		Role updatedRole= roleService.updateRole(id, role);
		return new ResponseEntity<>(updatedRole,HttpStatus.OK);
	}
}
