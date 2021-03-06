package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.domain.model.Bbs;
import com.example.domain.model.GroupOrder;
import com.example.domain.model.SignupForm;
import com.example.domain.model.User;
import com.example.domain.service.UserService;

@Controller
public class SignupController {
	
    @Autowired
    private UserService userService;


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
    		@ModelAttribute @Validated(GroupOrder.class) SignupForm form,
    		BindingResult bindingResult,
            Model model) {

    	// passwordと確認用passwordが違う場合考慮
    	if(bindingResult.hasErrors() ||
    			!form.getPassword().equals(form.getConfirmationPassword())) {
    		return getSignUp(form, model);
    	}
    	
    	User user = new User();
    	
        user.setName(form.getUserName()); //ユーザー名
        user.setPassword(form.getPassword()); //パスワード
        
        model.addAttribute("user", user);

        return "login/signupConfirm";
    }
    
    /**
     * ユーザー登録確認画面のPOSTメソッド用処理.
     */
    @PostMapping("/signupCommit")
    public String postSignUpCommit(
    		@ModelAttribute @Validated(GroupOrder.class) SignupForm form,
    		BindingResult bindingResult,
            Model model) {
    	

    	System.out.println(form);

    	
    	User user = new User();
    	
        user.setName(form.getUserName()); //ユーザー名
        user.setPassword(form.getPassword()); //パスワード
        

        // ユーザー登録処理
        boolean result = userService.insert(user);

        // ユーザー登録結果の判定
        if (result == true) {
            System.out.println("insert成功");
        } else {
            System.out.println("insert失敗");
        }
    	
        return "redirect:/login";
        
    }
    
}
