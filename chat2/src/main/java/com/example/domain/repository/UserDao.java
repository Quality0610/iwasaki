package com.example.domain.repository;

import org.springframework.dao.DataAccessException;

import com.example.domain.model.User;

public interface UserDao {

	public int insertUser(User user) throws DataAccessException;
		
	public int deleteUser(int id) throws DataAccessException;
}
