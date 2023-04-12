package com.boot.springrestapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.springrestapi.Entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
