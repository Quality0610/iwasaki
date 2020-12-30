package com.example.domain.repository.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.model.Bbs;
import com.example.domain.repository.BbsDao;

@Repository
public class BbsDaoJdbcImpl implements BbsDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int insertBbs(Bbs bbs) throws DataAccessException{
		
        //１件登録
        int rowNumber = jdbcTemplate.update("INSERT INTO bbs("
                + " author,"
                + " subject,"
                + " body,"
                + " delete_flg)"
                + " VALUES(?, ?, ?, ?)",
                bbs.getAuthor(),
                bbs.getSubject(),
                bbs.getBody(),
                bbs.getDeleteFlag());

        return rowNumber;
	}

	@Override
	public List<Bbs> selectAllBbs() throws DataAccessException{
		return null;
	}
	
	@Override
	public int deleteBbs(int id) throws DataAccessException{
		return 0;
	}
}
