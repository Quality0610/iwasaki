package com.example.domain.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.domain.model.User;
import com.example.domain.repository.UserDao;

@Repository
public class UserDaoJdbcImpl implements UserDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public int insertUser(User user) throws DataAccessException{
		
		String password = passwordEncoder.encode(user.getPassword());
		
		System.out.println(user.getName());
		
		String sql = "INSERT INTO user(name,"
                + " password)"
                + " VALUES(?, ?)";
		
        //１件登録
        int rowNumber = jdbcTemplate.update(sql,
                user.getName(),
                password);

        return rowNumber;
	}

	@Override
	public int deleteUser(int id) throws DataAccessException{
		return 0;
	}
}
