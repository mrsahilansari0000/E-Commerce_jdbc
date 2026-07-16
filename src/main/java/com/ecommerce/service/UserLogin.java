package com.ecommerce.service;

import com.ecommerce.dao.UserDao;
import com.ecommerce.model.Seller;

public class UserLogin {
      private UserDao userDao = new UserDao();
      
      public Seller logIn(String email, String password) {
  		// Basic validation
  		if (email == null || password == null) {
  			return null;
  		}

  		return userDao.logIn(email, password);
  	}
}
