package com.mytodo.todolist.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String LoginForm(Model model) {
        model.addAttribute("Title", "TODO管理アプリ（仮）");
        model.addAttribute("subtitle", "Login");
        return "login/loginTpl";
    }

}
