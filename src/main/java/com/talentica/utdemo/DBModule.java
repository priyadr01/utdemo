package com.talentica.utdemo;

import com.google.inject.AbstractModule;

public class DBModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(UserDao.class).to(UserDaoImpl.class);
	}
}
