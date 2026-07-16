package com.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ecommerce.dao.UserDao;

public class UserLoginTest {
	static UserLogin useLogin;
	static UserDao userDao;

	@BeforeAll
	public static void beforeAll() {
		userDao = new UserDao();
		useLogin = new UserLogin();
	}

	@Test
	public void testLogIn() {
		boolean expected = true;
		boolean result = useLogin.logIn("signuptest@gmail.com", "signuptest@123");
		assertEquals(expected, result);
	}
}
