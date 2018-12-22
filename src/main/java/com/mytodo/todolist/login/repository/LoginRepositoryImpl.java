package com.mytodo.todolist.login.repository;

import com.mytodo.todolist.login.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class LoginRepositoryImpl implements LoginRepository {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public LoginRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String login(Login login) {
        // loginの処理
        String sql = "select count(userid) from users where userid = ? and passwd = ?";
        if (jdbcTemplate.queryForObject(sql, Integer.class, login.getUserid(), login.getPasswd()) == 1) {
            return "success";
        } else {
            return "failed";
        }
    }
}
