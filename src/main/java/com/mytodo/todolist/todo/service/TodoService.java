package com.mytodo.todolist.todo.service;

import com.mytodo.todolist.todo.model.Todo;
import com.mytodo.todolist.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    public String addTodo(String userid, String title, String detail) {
        Todo todo = new Todo();
        todo.setUserid(userid);
        todo.setTitle(title);
        todo.setDetail(detail);
        if (todoRepository.addTodo(todo).equals("success")) {
            return "success";
        } else {
            return "failed";
        }
    }
}
