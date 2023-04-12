package com.boot.springrestapi.Service;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.boot.springrestapi.Entity.Role;


@Service
public interface RoleService {
	
	Role addRole(Role role);
	
	Role updateRole(Long id, Role role);

	Role getRoleById(Long id);

	List<Role> getAllRoles();
}
