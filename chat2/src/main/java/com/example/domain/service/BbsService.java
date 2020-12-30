package com.example.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.model.Bbs;
import com.example.domain.repository.BbsDao;

@Service
public class BbsService {

	@Autowired
	BbsDao bbsDao;
	
	public boolean insert(Bbs bbs) {
		
		int rowNumber = bbsDao.insertBbs(bbs);
		
		boolean result = false;
		
		if(rowNumber > 0) {
			result = true;
		}
		
		return result;
	}
	
}
