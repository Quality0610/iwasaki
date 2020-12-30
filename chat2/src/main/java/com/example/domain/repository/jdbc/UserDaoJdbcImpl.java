package com.example.domain.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.model.User;
import com.example.domain.repository.UserDao;

@Repository
public class UserDaoJdbcImpl implements UserDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int insertUser(User user) throws DataAccessException{
		
        //１件登録
        int rowNumber = jdbcTemplate.update("INSERT INTO user(name,"
                + " password)"
                + " VALUES(?, ?)",
                user.getId(),
                user.getPassword());

        return rowNumber;
	}

	@Override
	public int deleteUser(int id) throws DataAccessException{
		return 0;
	}
}
