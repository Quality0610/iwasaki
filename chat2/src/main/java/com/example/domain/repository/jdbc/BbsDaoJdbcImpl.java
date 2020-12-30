package com.example.domain.repository.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	public int count() throws DataAccessException{
        
		// 全件取得してカウント
        int count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM bbs", Integer.class);

        return count;
	}
	
	@Override
	public List<Bbs> selectAllBbs() throws DataAccessException{
		
		List<Map<String, Object>> getList = jdbcTemplate.queryForList("SELECT * FROM bbs");
		
		List<Bbs> bbsList = new ArrayList<>();
		 
        for (Map<String, Object> map : getList) {

            Bbs bbs = new Bbs();

            bbs.setId((Integer) map.get("id"));
            bbs.setAuthor((String) map.get("author"));
            bbs.setSubject((String) map.get("subject"));
            bbs.setBody((String) map.get("body"));
            bbs.setDeleteFlag((Integer) map.get("delete_flg"));

            bbsList.add(bbs);
        }

        return bbsList;
	}
	
	@Override
	public int deleteBbs(int id) throws DataAccessException{
		return 0;
	}
	
	@Override
	public Bbs selectOne(int id) throws DataAccessException{
		return null;
	}
}
