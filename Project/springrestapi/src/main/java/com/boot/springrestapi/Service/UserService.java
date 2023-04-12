package com.boot.springrestapi.Service;

import java.util.List;

import com.boot.springrestapi.Entity.User;

public interface UserService {
	
	User addUser(User user);
	
	void deleteUser(Long id);
	
	User updateUser(Long id, User user);

	User getUserById(Long id);

	List<User> getAllUsers();

	

}
