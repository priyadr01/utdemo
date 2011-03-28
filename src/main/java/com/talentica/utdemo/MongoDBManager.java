package com.talentica.utdemo;

import java.net.UnknownHostException;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class MongoDBManager {
	private static MongoDBManager  mongoDBManager = new MongoDBManager();
	private Datastore datastore;
	private Morphia morphia;

	private MongoDBManager()  {
		
		Mongo m = null;
		try {
			m = new Mongo();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MongoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		morphia = new Morphia();
		morphia.map(User.class);
		this.datastore = morphia.createDatastore(m, "utdemo");
	}

	public static MongoDBManager getInstance() {
		return mongoDBManager;
	}

	

	public Datastore getDatastore() {
		return datastore;
	}

}
