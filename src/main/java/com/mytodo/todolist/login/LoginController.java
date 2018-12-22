package com.mytodo.todolist.login;

import com.mytodo.todolist.SessionManager;
import com.mytodo.todolist.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    SessionManager sessionManager;

    @RequestMapping(method = RequestMethod.GET)
    public String LoginForm(Model model) {
        return "login/loginTpl";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String Login(
            Model model,
            @RequestParam("userid")String userid,
            @RequestParam("passwd")String passwd
    ) {
        if (loginService.loginAuth(userid, passwd).equals("success")) {
            sessionManager.setUserid(userid);
            model.addAttribute("name", sessionManager.getUserid()+"さん");
            return "todo/todoHomeTpl";
        } else {
            model.addAttribute("error", true);
            return "login/loginTpl";
        }

    }

}
