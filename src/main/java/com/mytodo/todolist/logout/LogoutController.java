package com.mytodo.todolist.logout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("logout")
public class LogoutController {

    @RequestMapping(method = RequestMethod.GET)
    public String Logout() {
        //認証がなければログインページに
        return "logout/logoutTpl";
    }
}
