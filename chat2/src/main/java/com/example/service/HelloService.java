package com.example.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.model.User;
import com.example.repository.HelloRepository;

@Service
public class HelloService {

	@Autowired
    private HelloRepository helloRepository;

    public User findOne(int id) {

        // １件検索実行
        Map<String, Object> map = helloRepository.findOne(id);

        // Mapから値を取得
        int userId = (Integer) map.get("id");
        String name = (String) map.get("name");
        String password = (String) map.get("password");

        // Userクラスに値をセット
        User user = new User();
        user.setId(userId);
        user.setName(name);
        user.setPassword(password);

        return user;
    }
}
