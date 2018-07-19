package org.szpinc.study.shiro.spring.service;

import org.szpinc.study.shiro.spring.entity.User;

public interface UserService {

    void addUser (User user);

    void updateUser (User user);

    void deleteUserById (String id);

    User selectUserById (String id);

    User getUserByUsername (String username);
}
