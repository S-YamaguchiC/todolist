package com.mytodo.todolist.account;

import com.mytodo.todolist.SessionManager;
import com.mytodo.todolist.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
@RequestMapping("/change")
public class AccountDataChangeController {

    @Autowired
    AccountService accountService;

    @Autowired
    SessionManager sessionManager;

    @RequestMapping(method = RequestMethod.GET)
    public String AccountDataChangeForm(Model model) {
        if (Objects.isNull(sessionManager.getUserid())) {
            return "login/loginTpl";
        } else {
            model.addAttribute("name", sessionManager.getUserid() + "さん");
            return "account/accountDataChangeTpl";
        }
    }

    @RequestMapping(params = "change" ,method = RequestMethod.POST)
    public String AccountDataChange(
            Model model,
            @RequestParam("pass")String pass,
            @RequestParam("newId")String newId
    ) {
        if (accountService.changeAccount(sessionManager.getUserid(), pass, newId).equals("success")) {
            model.addAttribute("changed", true);
            return "login/loginTpl";
        } else if(accountService.changeAccount(sessionManager.getUserid(), pass, newId).equals("failed2")) {
            model.addAttribute("error2", true);
            model.addAttribute("name", sessionManager.getUserid() + "さん");
            return "account/accountDataChangeTpl";
        } else if(accountService.changeAccount(sessionManager.getUserid(), pass, newId).equals("failed1")) {
            model.addAttribute("error1", true);
            model.addAttribute("name", sessionManager.getUserid() + "さん");
            return "account/accountDataChangeTpl";
        } else {
            model.addAttribute("error3", true);
            model.addAttribute("name", sessionManager.getUserid() + "さん");
            return "account/accountDataChangeTpl";
        }
    }

    @RequestMapping(params = "delete", method = RequestMethod.POST)
    public String AccountDelete(
            Model model,
            @RequestParam("pass")String pass
    ) {
        if (accountService.deleteAccount(sessionManager.getUserid(), pass).equals("success")) {
            model.addAttribute("deleted", true);
            return "account/accountTpl";
        } else {
            model.addAttribute("name", sessionManager.getUserid() + "さん");
            model.addAttribute("error", true);
            return "account/accountDataChangeTpl";
        }
    }
}
