package com.example.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HelloRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Map<String, Object> findOne(int id) {

        // SELECT文
        String query = "SELECT "
                + " id,"
                + " name,"
                + " password "
                + "FROM user "
                + "WHERE id=?";

        // 検索実行
        Map<String, Object> user = jdbcTemplate.queryForMap(query, id);

        return user;
    }
}