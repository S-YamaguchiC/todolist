package com.mytodo.todolist.login.repository;

import com.google.inject.ImplementedBy;
import com.mytodo.todolist.login.model.Login;

@ImplementedBy(LoginRepositoryImpl.class)
public interface LoginRepository {

    /**
     * ログインの認証
     * */
    String login(Login login);
}
