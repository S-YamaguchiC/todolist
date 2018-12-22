package com.mytodo.todolist.todo;

import com.mytodo.todolist.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("todo")
public class TodoController {

    @Autowired
    SessionManager sessionManager;

    @RequestMapping(method = RequestMethod.GET)
    public String ToDoHomePage(Model model) {
        //認証がなければログインページに
        model.addAttribute("name", sessionManager.getUserid()+"さん");
        return "todo/todoHomeTpl";
    }
}
