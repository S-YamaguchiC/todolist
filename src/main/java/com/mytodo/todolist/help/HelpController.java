package com.mytodo.todolist.help;

import com.mytodo.todolist.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("help")
public class HelpController {

    @Autowired
    SessionManager sessionManager;

    @RequestMapping(method = RequestMethod.GET)
    public String HelpPage(Model model) {
        model.addAttribute("name", sessionManager.getUserid());
        return "help/helpTpl";
    }
}
