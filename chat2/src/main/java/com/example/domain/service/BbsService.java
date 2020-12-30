package com.example.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.repository.BbsDao;

@Service
public class BbsService {

	@Autowired
	BbsDao bbsDao;
	
}
