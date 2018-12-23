package com.mytodo.todolist.todo;

import com.mytodo.todolist.SessionManager;
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
@RequestMapping("add")
public class TodoAddController {

    @Autowired
    SessionManager sessionManager;

    @Autowired
    TodoService todoService;

    @RequestMapping(method = RequestMethod.GET)
    public String AddForm(Model model) {
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
            return "todo/todoAddTodoTpl";
        }
    }
}
