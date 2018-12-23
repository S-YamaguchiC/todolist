package com.mytodo.todolist.todo.repository;

import com.mytodo.todolist.todo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
@Transactional
public class TodoRepositoryImpl implements TodoRepository {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public TodoRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String addTodo(Todo todo) {
        String sql = "insert into " +
                "todos (userid, title, detail, post_time, last_update_time) " +
                "values (?,?,?,?,?);";
        if (jdbcTemplate.update(sql,
                todo.getUserid(),
                todo.getTitle(),
                todo.getDetail(),
                todo.getPost_time(),
                todo.getLast_update_time()) == 1)
        {
            return "success";
        } else {
            return "failed";
        }
    }

    @Override
    public List<Todo> findAllTodo(String userid) {
        String sql = "select * from todos where userid = ? order by post_time asc ";
        List<Todo> allTodo = jdbcTemplate.query(sql, new RowMapper<Todo>() {
            @SuppressWarnings("Duplicates") // よくわからんがWarningが邪魔なのでつけた
            @Override
            public Todo mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
                Todo todos = new Todo();
                todos.setUserid(resultSet.getString("userid"));
                todos.setTitle(resultSet.getString("title"));
                todos.setDetail(resultSet.getString("detail"));
                todos.setPost_time(resultSet.getTimestamp("post_time"));
                todos.setLast_update_time(resultSet.getTimestamp("last_update_time"));
                return todos;
            }
        }, userid);
        return allTodo;
    }

    @Override
    public List<Todo> findOneTodo(String userid, Timestamp post) {
        String sql = "select * from todos where userid = ? and post_time = ?";
        List<Todo> oneTodo = jdbcTemplate.query(sql, new RowMapper<Todo>() {
            @SuppressWarnings("Duplicates")
            @Override
            public Todo mapRow(ResultSet resultSet, int i) throws SQLException {
                Todo todo = new Todo();
                todo.setUserid(resultSet.getString("userid"));
                todo.setTitle(resultSet.getString("title"));
                todo.setDetail(resultSet.getString("detail"));
                todo.setPost_time(resultSet.getTimestamp("post_time"));
                todo.setLast_update_time(resultSet.getTimestamp("last_update_time"));
                return todo;
            }
        }, userid, post);
        return oneTodo;
    }

    @Override
    public String editTodo(Todo todo) {
        String sql = "update todos set title = ?, detail = ?, last_update_time = ? where userid = ? and post_time = ?";
        if (jdbcTemplate.update(
                sql,
                todo.getTitle(),
                todo.getDetail(),
                todo.getLast_update_time(),
                todo.getUserid(),
                todo.getPost_time()) == 1)
        {
            return "success";
        } else {
            return "failed";
        }
    }
}
