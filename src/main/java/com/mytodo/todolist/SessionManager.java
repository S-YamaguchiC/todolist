package com.mytodo.todolist;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionManager implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userid;

    public void setUserid(String id) {
        this.userid = id;
    }

    public String getUserid() {
        return this.userid;
    }
}
