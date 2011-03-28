package com.talentica.utdemo;

import com.google.inject.AbstractModule;

public class MockDBModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(UserDao.class).to(UserDaoMockImpl.class);
		
	}

}
