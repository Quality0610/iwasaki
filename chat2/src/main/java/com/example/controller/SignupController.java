package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.domain.model.SignupForm;

@Controller
public class SignupController {


    /**
     * ユーザー登録画面のGETメソッド用処理.
     */
    @GetMapping("/signup")
    public String getSignUp(@ModelAttribute SignupForm form,Model model) {

        // signup.htmlに画面遷移
        return "login/signup";
    }

    /**
     * ユーザー登録画面のPOSTメソッド用処理.
     */
    @PostMapping("/signup")
    public String postSignUp(
    		@ModelAttribute @Validated SignupForm form,
    		BindingResult bindingResult,
            Model model) {

    	//TO DO passwordの確認用サービスを読んでチェックする    	
    	
    	if(bindingResult.hasErrors()) {
    		return getSignUp(form, model);
    	}
    	
    	System.out.println(form);
    	
        // login.htmlにリダイレクト
        return "redirect:/login";
    }
}
