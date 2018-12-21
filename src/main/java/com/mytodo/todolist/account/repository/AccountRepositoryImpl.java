package com.mytodo.todolist.account.repository;

import com.mytodo.todolist.account.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AccountRepositoryImpl implements AccountRepository {

    //各種DB処理
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public AccountRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String save(Account account) {
        String sql = "insert into users(userid, passwd) values (?,?)";
        if (jdbcTemplate.update(sql, account.getUserid(), account.getPasswd()) == 1) {
            return "success";
        } else {
            return "failed";
        }
    }
}