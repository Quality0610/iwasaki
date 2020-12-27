package com.example.domain.model;

import lombok.Data;

@Data
public class Bbs {

	private int id;
	private String author;
	private String subject;
	private String body;
	private int deleteFlag;
}
