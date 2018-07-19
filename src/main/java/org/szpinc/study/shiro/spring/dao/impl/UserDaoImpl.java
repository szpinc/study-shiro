package org.szpinc.study.shiro.spring.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.szpinc.study.shiro.spring.dao.UserDao;
import org.szpinc.study.shiro.spring.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String sql;

    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO `user` VALUES(?,?,?)";
        int status = jdbcTemplate.update(sql, user.getId(), user.getUsername(), user.getPassword());
    }

    @Override
    public void deleteUser(String id) {
        sql = "DELETE FROM `user` WHERE `id`=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateUser(User user) {
        sql = "UPDATE `user` SET `username`=? , `password`=? WHERE `id`=?";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getId());
    }

    @Override
    public User findUserById(String id) {
        sql = "SELECT * FROM `user` WHERE `id`=?";
        User user = jdbcTemplate.queryForObject(sql, User.class, id);
        return user;
    }

    @Override
    public User findUserByUsername(String username) {
        sql = "SELECT * FROM `user` WHERE username=?";
        return jdbcTemplate.queryForObject(sql, User.class, username);
    }
}
