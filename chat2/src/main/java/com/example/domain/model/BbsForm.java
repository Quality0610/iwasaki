package com.example.domain.model;

import lombok.Data;

@Data
public class BbsForm {
	private int id;
	private String author;
	private String subject;
	private String body;
	private int deleteFlag;
	
}
