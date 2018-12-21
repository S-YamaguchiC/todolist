package com.mytodo.todolist.account;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/account")
public class AccountController {

    @RequestMapping(method = RequestMethod.GET)
    public String AccountForm(Model model) {
        model.addAttribute("Title", "アカウント登録");
        return "account/accountTpl";
    }
}
