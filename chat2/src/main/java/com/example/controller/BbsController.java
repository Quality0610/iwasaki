package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.domain.service.BbsService;

@Controller
public class BbsController {

	
	@Autowired
	BbsService bbsService;
	
	//BBS画面用のGETメソッド
	@GetMapping("/bbs")
	public String getBbs(Model model) {
		
		model.addAttribute("contents", "login/home :: home_contents");
		
		return "login/bbsLayout";
	}
	
	@PostMapping("/logout")
	public String postLogout() {
		return "redirect:/login";
	}
}
