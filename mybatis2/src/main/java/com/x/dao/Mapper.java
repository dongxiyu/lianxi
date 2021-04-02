package com.x.dao;

import com.x.pojo.Account;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author dxy
 * @date 2021/3/30 - 22:43
 */
public interface Mapper {
    @Select("select * from account;")
    List<Account> findAll();
    List<Account> findAll2(Map<String,Object> map);
    void add(Account account);
    void update(Account account);
    void delete(int id);
    List<Account> like(String value);
}
