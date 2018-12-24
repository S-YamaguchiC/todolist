package com.mytodo.todolist.todo.repository;

import com.google.inject.ImplementedBy;
import com.mytodo.todolist.todo.model.Todo;

import java.sql.Timestamp;
import java.util.List;

@ImplementedBy(TodoRepository.class)
public interface TodoRepository {

    /**
     * UserIdを使ってTODOを追加
     * */
    String addTodo(Todo todo);

    /**
     * UserIdに紐付いたTODOをすべて検索
     * 参考：https://tokkan.net/spring/jdbc.html
     * */
    List<Todo> findAllTodo(String userid);

    /**
     * UserIdとPostTimeをもとにTODOを1件取得
     * */
    List<Todo> findOneTodo(String userid, Timestamp post);

    /**
     * UserIdとPostTimeを使って既存のTodoを編集
     * */
    String editTodo(Todo todo);

    /**
     * UserIdとPostTimeを使って既存のTodoを削除
     * */
    String deleteTodo(Todo todo);

    /**
     * UserIdと検索キーワードでTodoを検索
     * */
    List<Todo> searchTodo(String userid, String key);
 }
