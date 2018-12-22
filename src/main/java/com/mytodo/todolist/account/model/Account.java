package com.mytodo.todolist.account.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Account {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String userid;

    @Column
    private String passwd;

    // getter/setter
    public Integer getID() {return id;}
    public void setId(Integer no) {this.id = no;}
    public String getUserid() {return userid;}
    public void setUserid(String id) {this.userid = id;}
    public String getPasswd() {return passwd;}
    public void setPasswd(String pass) {this.passwd = pass;}
}
