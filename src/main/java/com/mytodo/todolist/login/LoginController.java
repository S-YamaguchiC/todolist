package com.mytodo.todolist.login;

import com.mytodo.todolist.SessionManager;
import com.mytodo.todolist.login.service.LoginService;
import com.mytodo.todolist.todo.model.Todo;
import com.mytodo.todolist.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    TodoService todoService;

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
            List<Todo> todoList = todoService.findTodo(sessionManager.getUserid());
            if (!Objects.isNull(todoList)) {
                model.addAttribute("todoList", todoList);
            } else {
                model.addAttribute("todoList", new ArrayList<Todo>());
            }
            model.addAttribute("name", sessionManager.getUserid()+"さん");
            return "todo/todoHomeTpl";
        } else {
            model.addAttribute("error", true);
            return "login/loginTpl";
        }

    }

}
