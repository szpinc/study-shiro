package org.szpinc.study.shiro.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.szpinc.study.shiro.spring.dao.UserDao;
import org.szpinc.study.shiro.spring.entity.User;
import org.szpinc.study.shiro.spring.service.UserService;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUserById(String id) {
        userDao.deleteUser(id);
    }

    @Override
    public User selectUserById(String id) {
        return userDao.findUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }


}
