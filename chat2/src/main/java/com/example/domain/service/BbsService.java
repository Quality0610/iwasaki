package com.example.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.model.Bbs;
import com.example.domain.model.BbsForm;
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
	
	public int count() {
		return bbsDao.count();
	}
	
	public List<Bbs> selectAllBbs(){
		return bbsDao.selectAllBbs();
	}
	
	public boolean deleteOne(int formId) {
		
		boolean result = false;
		
		int rowNumber = bbsDao.deleteBbs(formId);
		
		if(rowNumber > 0) {
			result = true;
		}
		
		return result;
	}
	
	
}
