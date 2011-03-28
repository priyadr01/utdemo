package com.talentica.utdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) throws IOException {
		String menu = "Enter 0 to register\n1 to login\n2 to quit";
		
		//UserService userService = new UserService();
		//UserService userService = new UserService(new UserDaoImpl());
		
		AbstractModule module = new DBModule();
		Injector injector = Guice.createInjector(module);
		UserService userService = injector.getInstance(UserService.class);

		
		while (true) {
			System.out.println(menu);
			int choice = Integer.parseInt(readLine());
			if (choice == 0 || choice == 1) {
				System.out.println("UserName:");
				String username = readLine();
				System.out.println("Password:");
				String password = readLine();
				if (choice == 0) {
					RegistrationStatus status = userService.register(username,
							password);
					System.out.println("Registration Status:" + status);
				} else if (choice == 1) {
					boolean status = userService.verifyUser(username, password);
					System.out.println("Login Status:" + status);
				}
			} else {
				break;
			}
		}
	}

	public static String readLine() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = null;

		// read the username from the command-line; need to use try/catch with
		// the
		// readLine() method
		try {
			str = br.readLine();
		} catch (IOException ioe) {
			System.out.println("IO error trying to read your name!");
			System.exit(1);
		}
		return str;

	}
}
