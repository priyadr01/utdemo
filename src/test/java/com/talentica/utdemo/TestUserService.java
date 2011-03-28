package com.talentica.utdemo;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import junit.framework.TestCase;

public class TestUserService extends TestCase {
	
	public void testUserRegistration()
	{
		UserService userService = new UserService();
		
		//MongoDBManager dbManager = MongoDBManager.getInstance();
		//UserService userService = new UserService(new UserDaoMockImpl(dbManager.getDatastore()));
		
		//AbstractModule module = new MockDBModule();
		//Injector injector = Guice.createInjector(module);
		//UserService userService = injector.getInstance(UserService.class);
		
		//Invalid username
		RegistrationStatus status = userService.register("abc", "test@123");
		assertSame(RegistrationStatus.InvalidUserName, status);
		
		//Invalid password
		status = userService.register("rajasekhar", "abc");
		assertSame(RegistrationStatus.InvalidPassword, status);
		
		//Valid registration
		status = userService.register("rajasekhar", "test@123");
		assertSame(RegistrationStatus.Sucess, status);
		
		//Invalid login
		boolean loginStatus = userService.verifyUser("rajasekhar", "test@1234");
		assertFalse(loginStatus);
		
		//Valid login
		loginStatus = userService.verifyUser("rajasekhar", "test@123");
		assertTrue(loginStatus);
		
		//Some other user with same username
		status = userService.register("rajasekhar", "abc@123");
		assertSame(RegistrationStatus.DuplicateUserName, status);
		
		loginStatus = userService.verifyUser("rajasekhar", "abc@123");
		assertFalse(loginStatus);
	}
}
