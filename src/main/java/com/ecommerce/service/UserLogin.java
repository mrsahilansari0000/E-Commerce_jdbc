package com.ecommerce.service;

import com.ecommerce.dao.UserDao;

public class UserLogin {
      private UserDao userDao = new UserDao();
      public boolean logIn(String email, String password) {
  		// Basic validation
  		if (email == null || password == null) {
  			return false;
  		}

  		return userDao.logIn(email, password);
  	}
}
