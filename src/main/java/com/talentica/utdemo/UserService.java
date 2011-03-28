package com.talentica.utdemo;

import com.google.inject.Inject;

public class UserService {
	UserDao userDao = null;

	public UserService() {
		this.userDao = new UserDaoImpl();
	}
	
	/*
	@Inject
	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}
*/
	public RegistrationStatus register(String username, String password) {
		RegistrationStatus status = RegistrationStatus.Sucess;
		if (username == null || username.length() < 6) {
			status = RegistrationStatus.InvalidUserName;
		} else if (password == null || password.length() < 6) {
			status = RegistrationStatus.InvalidPassword;
		} else {
			User user = userDao.findUserByUsername(username);
			if (user != null) {
				status = RegistrationStatus.DuplicateUserName;
			}
		}
		if (status == RegistrationStatus.Sucess) {
			User user = new User(username, password);
			userDao.saveUser(user);
		}
		return status;
	}

	public boolean verifyUser(String username, String password) {
		return userDao.verifyUser(username, password); 
	}
}
