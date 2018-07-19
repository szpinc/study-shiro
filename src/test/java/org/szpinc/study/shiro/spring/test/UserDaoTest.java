package org.szpinc.study.shiro.spring.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.szpinc.study.shiro.spring.dao.UserDao;
import org.szpinc.study.shiro.spring.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-jdbc.xml","classpath*:spring/spring-service.xml"})
public class UserDaoTest {

    private static final Logger LOG = LoggerFactory.getLogger(UserDaoTest.class);

    @Autowired
    private UserDao userDao;

    @Test
    public void testGetUserByUsername () {

        String username = "12345634";

        String id = "4021f7bad1203c6542f3df79d6604ed6";

        User user = userDao.findUserById(id);

        LOG.debug("user==[{}]",user);
    }

}
