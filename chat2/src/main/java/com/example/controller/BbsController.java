package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.domain.model.Bbs;
import com.example.domain.model.BbsForm;
import com.example.domain.model.GroupOrder;
import com.example.domain.model.SignupForm;
import com.example.domain.model.User;
import com.example.domain.service.BbsService;

@Controller
public class BbsController {

	
	@Autowired
	BbsService bbsService;
	
	//BBS画面用のGETメソッド
	@GetMapping("/bbs")
	public String getBbs(Model model) {
		
		// loginUser名の取得
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loginName = auth.getName();
        model.addAttribute("loginName", loginName);

		
		model.addAttribute("contents", "login/bbs :: bbs_contents");
		
        List<Bbs> bbsList = bbsService.selectAllBbs();

        model.addAttribute("bbsList", bbsList);
        
        System.out.println("unkouuuuu");
        System.out.println("bbsList " + bbsList);
		
		return "login/bbsLayout";
	}
	
	@PostMapping("/bbs")
	public String postBbs(
			@ModelAttribute @Validated(GroupOrder.class) BbsForm form,
    		BindingResult bindingResult,
            Model model) {
    	
    	if(bindingResult.hasErrors()) {
    		return getBbs(model);
    	}
    	
    	System.out.println(form);
    	
		// loginUser名の取得
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loginName = auth.getName();
        model.addAttribute("loginName", loginName);
    	
    	Bbs bbs = new Bbs();
    	
    	bbs.setAuthor(loginName); 
    	bbs.setSubject(form.getSubject());
    	bbs.setBody(form.getBody());
    	bbs.setDeleteFlag(0);
    	        
        // 投稿登録処理
        boolean result = bbsService.insert(bbs);

        // 投稿登録結果の判定
        if (result == true) {
            System.out.println("insert成功");
        } else {
            System.out.println("insert失敗");
        }

		model.addAttribute("contents", "login/bbs :: bbs_contents");

		List<Bbs> bbsList = bbsService.selectAllBbs();

        model.addAttribute("bbsList", bbsList);
		
		return "login/bbsLayout";
	}
	
	@PostMapping("/logout")
	public String postLogout() {
		return "redirect:/login";
	}
	
    @GetMapping("/bbs/{id:.+}")
    public String delete(
            Model model,
            @PathVariable("id") Integer id) {

        System.out.println("削除ボタンの処理");

        boolean result = bbsService.deleteOne(id);

        if (result == true) {
            model.addAttribute("result", "削除成功");
        } else {
            model.addAttribute("result", "削除失敗");
        }

        return getBbs(model);
    }	
	
}
