package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	

    /**
     * GET用の処理.
     */
    @GetMapping("/hello")
    public String getHello() {
        // hello.htmlに画面遷移
        return "hello";
    }
    
    /**
     * POST用の処理.
     */
    @PostMapping("/hello")
    public String postRequest(@RequestParam("text1") String str, Model model) {

        // 画面から受け取った文字列をModelに登録
        model.addAttribute("sample", str);

        // helloResponse.htmlに画面遷移
        return "helloResponse";
    }

}
