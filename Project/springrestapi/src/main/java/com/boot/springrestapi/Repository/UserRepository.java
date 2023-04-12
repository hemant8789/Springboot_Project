package com.boot.springrestapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.springrestapi.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
