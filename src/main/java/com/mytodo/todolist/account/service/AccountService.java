package com.mytodo.todolist.account.service;

import com.mytodo.todolist.account.model.Account;
import com.mytodo.todolist.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public List<Account> selectAll() {
        return null;
    }

    public String addAccount(String userid, String passwd) {
        Account account = new Account();
        account.setUserid(userid);
        account.setPasswd(passwd);
        if (accountRepository.save(account).equals("success")) {
            return "success";
        } else {
            return "failed";
        }
    }
}
