package com.mytodo.todolist.account.repository;

import com.mytodo.todolist.account.model.Account;
import com.google.inject.ImplementedBy;

@ImplementedBy(AccountRepositoryImpl.class)
public interface AccountRepository {

    /**
     * アカウント登録
     * */
    String save(Account account);
}
