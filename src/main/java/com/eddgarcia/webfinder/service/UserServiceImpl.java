package com.eddgarcia.webfinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eddgarcia.webfinder.model.User;
import com.eddgarcia.webfinder.repository.UserRepository;


@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
    @Override
    public User findUserById(long id) {
    	return userRepository.getOne(id);
    }
    
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}
	
	@Override
	public List<User> getAllUsers(){
		return userRepository.findAllByOrderByIdAsc();
	}
}