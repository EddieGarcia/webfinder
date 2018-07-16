package com.eddgarcia.webfinder.service;

import com.eddgarcia.webfinder.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}