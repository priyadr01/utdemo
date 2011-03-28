package com.talentica.utdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.inject.Singleton;

@Singleton
public class UserDaoMockImpl implements UserDao {
	private Map<String, User> userMap = null;
 
	public UserDaoMockImpl() {
		userMap = new HashMap<String, User>();
	}

	public User findUserByUsername(String username) {
		for(User user : userMap.values()){
			if(username == user.getUsername()){
				return user;
			}
		}
		return null;
	}

	public void saveUser(User user) {
		userMap.put(user.getUsername(), user);
		
	}

	public List<User> findAllUsers() {
		return new ArrayList<User>(userMap.values());
	}

	public boolean verifyUser(String username, String password) {
		for(User user : userMap.values()){
			if(username == user.getUsername() && user.getPassword() == password){
				return true;
			}
		}
		return false;
	}

}

