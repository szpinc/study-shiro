package org.szpinc.study.shiro.spring.dao;

import org.szpinc.study.shiro.spring.entity.User;

public interface UserDao {

    void addUser (User user);

    void deleteUser (String id);

    void updateUser (User user);

    User findUserById (String id);

    User findUserByUsername (String username);

}
