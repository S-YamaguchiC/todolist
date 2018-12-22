package com.mytodo.todolist.todo.repository;

import com.google.inject.ImplementedBy;
import com.mytodo.todolist.todo.model.Todo;

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
    List<Todo> findTitle(String userid);

    List<String> findDetail(String userid);

    List<String> findPosttime(String userid);

    List<String> findLastUpdatetime(String userid);

    /**
     * UserIdを使って既存のTodoを編集
     * */

    /**
     * UserIdを使って既存のTodoを削除
     * */
 }
