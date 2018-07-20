package org.szpinc.study.shiro.spring.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.szpinc.study.shiro.spring.dao.UserDao;
import org.szpinc.study.shiro.spring.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

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
        User user = jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);
        return user;
    }

    @Override
    public User findUserByUsername(String username) {
        sql = "SELECT * FROM `user` WHERE username=?";
        return jdbcTemplate.queryForObject(sql, new UserRowMapper(), username);
    }

    class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getString("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            return user;
        }
    }
}
