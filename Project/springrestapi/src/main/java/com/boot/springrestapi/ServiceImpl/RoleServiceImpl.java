package com.boot.springrestapi.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.springrestapi.Entity.Role;
import com.boot.springrestapi.Repository.RoleRepository;
import com.boot.springrestapi.Service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Role addRole(Role role) {
		
		return roleRepository.save(role);
	}

	@Override
	public Role updateRole(Long id, Role role) {
		Role existingRole = roleRepository.findById(id).orElse(null);
			if (existingRole == null) {
			throw new RuntimeException("Role not found with id: " + id);
		}
			existingRole.setRoleName(role.getRoleName());
			existingRole.setRoleDescription(role.getRoleDescription());
				return roleRepository.save(existingRole);
	}

	@Override
	public Role getRoleById(Long id) {
		
		return roleRepository.findById(id).orElse(null);
	}

	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();

	}

}
