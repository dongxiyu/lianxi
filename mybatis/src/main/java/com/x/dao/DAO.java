package com.x.dao;

import com.x.pojo.Account;

import java.util.List;

/**
 * @author dxy
 * @date 2021/3/30 - 22:43
 */
public interface DAO {
    List<Account> findAll();
    void add(Account account);
    void update(Account account);
    void delete(int id);
    List<Account> like(String value);
}
