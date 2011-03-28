package com.talentica.utdemo;

import java.util.List;

public interface UserDao {
	User findUserByUsername(String username);

	void saveUser(User entry);

	List<User> findAllUsers();

	boolean verifyUser(String username, String password);
}
