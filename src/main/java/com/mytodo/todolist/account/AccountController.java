package com.mytodo.todolist.account;

import com.mytodo.todolist.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(method = RequestMethod.GET)
    public String AccountForm(Model model) {
        model.addAttribute("Title", "アカウント登録");
        return "account/accountTpl";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String Account(
            @RequestParam("userid")String userid,
            @RequestParam("passwd")String passwd
            ) {
        accountService.addAccount(userid, passwd);
        return "account/accountResultTpl";
    }
}
