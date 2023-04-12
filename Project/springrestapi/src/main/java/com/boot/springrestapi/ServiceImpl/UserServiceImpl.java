package com.boot.springrestapi.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.springrestapi.Entity.User;
import com.boot.springrestapi.Repository.UserRepository;
import com.boot.springrestapi.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public User addUser(User user) {
		User existingUser = userRepository.findByEmail(user.getEmail());
	    if (existingUser != null) {
	        throw new RuntimeException("Email ID already exists: " + user.getEmail());
	    }
		
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		
		userRepository.deleteById(id);
	}

	@Override
	public User updateUser(Long id, User user) {
		
		User existingUser = userRepository.findById(id).orElse(null);
		if(existingUser== null) {
			throw new RuntimeException("User Not Found With id: " + id);
		}
		existingUser.setName(user.getName());
	    existingUser.setDob(user.getDob());
	    existingUser.setEducation(user.getEducation());
	    existingUser.setEmail(user.getEmail());
	    existingUser.setPhoneNumber(user.getPhoneNumber());
	    existingUser.setMaritalStatus(user.getMaritalStatus());
	    existingUser.setUserRole(user.getUserRole());
	    return userRepository.save(existingUser);
	}

	@Override
	public User getUserById(Long id) {
		
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

}
