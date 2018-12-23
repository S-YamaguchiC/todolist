package com.mytodo.todolist.todo;

import com.mytodo.todolist.SessionManager;
import com.mytodo.todolist.todo.model.Todo;
import com.mytodo.todolist.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("edit")
public class TodoEditController {

    @Autowired
    SessionManager sessionManager;

    @Autowired
    TodoService todoService;

    @RequestMapping(method = RequestMethod.GET, value="/{id}/{post}")   // 本来ならTODOの番号を振るべき
    public String EditTodo(
            Model model,
            @PathVariable("id")String userid,
            @PathVariable("post")String posttime
    ) {
        if (Objects.isNull(sessionManager.getUserid())) {
            return "login/loginTpl";
        } else {
            List<Todo> todoList = todoService.findOneTodo(userid, Timestamp.valueOf(posttime));
            if (!Objects.isNull(todoList)) {
                model.addAttribute("name", sessionManager.getUserid());
                model.addAttribute("title", todoList.get(0).getTitle());
                model.addAttribute("detail", todoList.get(0).getDetail());
                model.addAttribute("post_hidden", posttime);
            } else {
                model.addAttribute("todoList", new ArrayList<Todo>());
            }
            model.addAttribute("name", sessionManager.getUserid() + "さん");
            return "todo/todoEditTodoTpl";
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public String Edit(
            Model model,
            @RequestParam("title")String title,
            @RequestParam("detail")String detail,
            @RequestParam("post")Timestamp post
    ) {
        if (todoService.editTodo(sessionManager.getUserid(), post, title, detail).equals("success")) {
            List<Todo> todoList = todoService.findAllTodo(sessionManager.getUserid());
            if (!Objects.isNull(todoList)) {
                model.addAttribute("todoList", todoList);
            } else {
                model.addAttribute("todoList", new ArrayList<Todo>());
            }
            model.addAttribute("name", sessionManager.getUserid()+"さん");
            return "todo/todoHomeTpl";
        } else {
            model.addAttribute("error", true);
            return "todo/todoEditTodoTpl";
        }
    }
}
