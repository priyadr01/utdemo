package com.talentica.utdemo;

import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.DAO;
import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.QueryResults;

public class UserDaoImpl implements UserDao {
	DAO<User, ObjectId> dao = null;

	public UserDaoImpl() {
		MongoDBManager dbManager = MongoDBManager.getInstance();
		dao = new DAO<User, ObjectId>(User.class, dbManager.getDatastore());
	}

	public User findUserByUsername(String username) {
		Query<User> query = dao.createQuery();
		query.field("username").equal(username);
		return query.get();
	}

	public void saveUser(User user) {
		dao.save(user);

	}

	public List<User> findAllUsers() {
		QueryResults<User> results = dao.find();
		if (results != null)
			return results.asList();
		return null;
	}

	public boolean verifyUser(String username, String password) {
		Query<User> query = dao.createQuery();
		query.field("username").equal(username);
		query.field("password").equal(password);
		User user = query.get();
		if(user != null && user.getId() != null){
			return true;
		}
		return false;
	}

}
