package com.mytodo.todolist.todo.service;

import com.mytodo.todolist.todo.model.Todo;
import com.mytodo.todolist.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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
        todo.setPost_time(Timestamp.valueOf(LocalDateTime.now()));
        todo.setLast_update_time(Timestamp.valueOf(LocalDateTime.now()));
        if (todoRepository.addTodo(todo).equals("success")) {
            return "success";
        } else {
            return "failed";
        }
    }

    public List<Todo> findAllTodo(String userid) {
        List<Todo> todoList = todoRepository.findAllTodo(userid);
        if (!Objects.isNull(todoList)) {
            return todoList;
        } else {
            return null;
        }
    }

    public List<Todo> findOneTodo(String userid, Timestamp post) {
        List<Todo> todoList = todoRepository.findOneTodo(userid, post);
        if (!Objects.isNull(todoList)) {
            return todoList;
        } else {
            return null;
        }
    }

    public String editTodo(String userid, Timestamp post, String title, String detail) {
        // TODO変更の処理
        Todo todo = new Todo();
        todo.setUserid(userid);
        todo.setTitle(title);
        todo.setDetail(detail);
        todo.setPost_time(post);
        todo.setLast_update_time(Timestamp.valueOf(LocalDateTime.now()));
        if (todoRepository.editTodo(todo).equals("success")) {
            return "success";
        } else {
            return "failed";
        }
    }
}
