package com.eddgarcia.webfinder.service;

import java.util.List;

import com.eddgarcia.webfinder.model.User;

public interface UserService {
	public User findUserById(long id);
	public User findUserByEmail(String email);
	public void saveUser(User user);
	public void delete(User user);
	public List<User> getAllUsers();
}