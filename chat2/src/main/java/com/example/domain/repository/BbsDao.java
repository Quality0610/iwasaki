package com.example.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.domain.model.Bbs;

public interface BbsDao {

	public int insertBbs(Bbs bbs) throws DataAccessException;
	
	public int count() throws DataAccessException;
	
	public List<Bbs> selectAllBbs() throws DataAccessException;
	
	public int deleteBbs(int id) throws DataAccessException;
	
    public Bbs selectOne(int id) throws DataAccessException;

}
