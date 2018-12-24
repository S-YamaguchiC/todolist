package com.mytodo.todolist.logout;

import com.mytodo.todolist.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Objects;

@Controller
@RequestMapping("logout")
@SessionAttributes("scopedTarget.sessionManager")
public class LogoutController {

    @Autowired
    SessionManager sessionManager;

    @RequestMapping(method = RequestMethod.GET)
    public String Logout(SessionStatus status) {
        //認証がなければログインページに
        if (Objects.isNull(sessionManager.getUserid())) {
            return "login/loginTpl";
        } else {
            // Sessionを切る処理
            status.setComplete();
            return "logout/logoutTpl";
        }
    }
}
