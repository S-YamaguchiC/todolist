package com.mytodo.todolist.account.repository;

import com.mytodo.todolist.account.model.Account;
import com.google.inject.ImplementedBy;

@ImplementedBy(AccountRepositoryImpl.class)
public interface AccountRepository {

    /**
     * アカウント登録
     * */
    String save(Account account);

    /**
     * アカウントのID変更
     * */
    String change(Account account, String newId);

    /**
     * アカウントの削除
     * */
    String delete(Account account);
}
