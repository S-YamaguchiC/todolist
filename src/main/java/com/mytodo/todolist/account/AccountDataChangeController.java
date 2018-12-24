package com.mytodo.todolist.account;

import com.mytodo.todolist.SessionManager;
import com.mytodo.todolist.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/change")
public class AccountDataChangeController {

    @Autowired
    AccountService accountService;

    @Autowired
    SessionManager sessionManager;

    @RequestMapping(method = RequestMethod.GET)
    public String AccountDataChangeForm(Model model) {
        model.addAttribute("name", sessionManager.getUserid() + "さん");
        return "account/accountDataChangeTpl";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String AccountDataChange(
            Model model,
            @RequestParam("pass")String pass,
            @RequestParam("newId")String newId
    ) {
        if (accountService.changeAccount(sessionManager.getUserid(), pass, newId).equals("success")) {
            model.addAttribute("changed", true);
            return "login/loginTpl";
        } else {
            model.addAttribute("error", true);
            model.addAttribute("name", sessionManager.getUserid());
            return "account/accountDataChangeTpl";
        }
    }
}
