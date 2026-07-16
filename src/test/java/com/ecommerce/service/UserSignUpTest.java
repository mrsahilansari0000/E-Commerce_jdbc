package com.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ecommerce.dao.UserDao;

public class UserSignUpTest {
	static UserSignUp userSignUp;
	static UserLogin useLogin;
	static UserDao userDao;
      @BeforeAll
      public static void beforeAll(){
    	  userSignUp = new UserSignUp();
    	  userDao = new UserDao();
    	  useLogin = new UserLogin();
      }
      
      @Test
      public void testSignUp() {
    	  boolean expected = true;
    	  boolean result = userSignUp.signUp("signup2", "signuptest2@gmail.com", "signuptest2@123", "customer");
    	  assertEquals(expected, result);
      }
      
     
}
