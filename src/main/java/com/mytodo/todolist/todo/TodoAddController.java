package com.mytodo.todolist.todo;

import com.mytodo.todolist.SessionManager;
import com.mytodo.todolist.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
@RequestMapping("add")
public class TodoAddController {

    @Autowired
    SessionManager sessionManager;

    @Autowired
    TodoService todoService;

    @RequestMapping(method = RequestMethod.GET)
    public String AddForm(Model model) {
        //認証がなければログインページに
        if (Objects.isNull(sessionManager.getUserid())) {
            return "login/loginTpl";
        } else {
            model.addAttribute("name", sessionManager.getUserid() + "さん");
            return "todo/todoAddTodoTpl";
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public String Add(
            Model model,
            @RequestParam("title")String title,
            @RequestParam("detail")String detail
    ) {
        if(todoService.addTodo(sessionManager.getUserid(), title, detail).equals("success")) {
            // 追加したことを表示するのもあり
            model.addAttribute("name", sessionManager.getUserid()+"さん");
            return "todo/todoHomeTpl";
        } else {
            model.addAttribute("error", true);
            return "todo/todoAddTodoTpl";
        }
    }
}
