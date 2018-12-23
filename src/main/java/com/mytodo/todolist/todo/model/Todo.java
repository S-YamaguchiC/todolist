package com.mytodo.todolist.todo.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "todos")
public class Todo {

    @Column
    private String userid;

    @Column
    private String title;

    @Column
    private String detail;

    @Column
    private Timestamp post_time;

    @Column
    private Timestamp last_update_time;

    // getter/setter
    public void setUserid(String id) { this.userid = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDetail(String detail) { this.detail = detail; }
    public void setPost_time(Timestamp postTime) { this.post_time = postTime; }
    public void setLast_update_time(Timestamp lastUpdateTime) { this.last_update_time = lastUpdateTime; }

    public String getUserid() { return this.userid; }
    public String getTitle() { return this.title; }
    public String getDetail() { return this.detail; }
    public Timestamp getPost_time() {
        post_time = Timestamp.valueOf(LocalDateTime.now());
        return this.post_time;
    }
    public Timestamp getLast_update_time() {
        last_update_time = Timestamp.valueOf(LocalDateTime.now());
        return this.last_update_time;
    }
}
