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
        String sql1 = "select count(userid) from users where userid = ?";
        String sql2 = "insert into users(userid, passwd) values (?,?)";
        if (jdbcTemplate.queryForObject(sql1, Integer.class, account.getUserid()) == 0) {
            if (jdbcTemplate.update(sql2, account.getUserid(), account.getPasswd()) == 1) {
                return "success";
            } else {
                return "failed";
            }
        } else {
            return "failed";
        }
    }

    @Override
    public String change(Account account, String newId) {
        String sql1 = "select count(userid) from users where userid = ? and passwd = ?";
        String sql2 = "update users set userid = ? where userid = ? and passwd = ?";
        if (jdbcTemplate.queryForObject(sql1, Integer.class, account.getUserid(), account.getPasswd()) == 1) {
            if (jdbcTemplate.update(sql2, newId, account.getUserid(), account.getPasswd()) == 1) {
                return "success";
            } else {
                return "failed";
            }
        } else {
            return "failed";
        }
    }
}
