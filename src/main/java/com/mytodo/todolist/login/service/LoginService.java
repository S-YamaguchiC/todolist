package com.mytodo.todolist.login.service;

import com.mytodo.todolist.login.model.Login;
import com.mytodo.todolist.login.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginService {

    @Autowired
    LoginRepository loginRepository;

    public String loginAuth(String userid, String passwd) {
        Login login = new Login();
        login.setUserid(userid);
        login.setPasswd(passwd);
        if (loginRepository.login(login).equals("success")) {
            return "success";
        } else {
            return "failed";
        }
    }
}
