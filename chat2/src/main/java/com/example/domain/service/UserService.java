package com.example.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.domain.model.User;
import com.example.domain.repository.UserDao;

@Service
@Qualifier("UserDaoJdbcImpl")
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public boolean insert(User user) {
		
		int rowNumber = userDao.insertUser(user);
		
		boolean result = false;
		
		if(rowNumber > 0) {
			result = true;
		}
		
		return result;
	}

}
