package org.szpinc.study.shiro.spring.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {


    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login (@RequestParam("username") String username, @RequestParam("password") String password) {

        Subject currentSubject = SecurityUtils.getSubject();

        if (!currentSubject.isAuthenticated()) {
            //将用户名密码封装成UsernamePasswordToken对象
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);

            LOG.debug("token:[{}]",token.hashCode());


            try {
                //执行登陆
                currentSubject.login(token);
            }catch (AuthenticationException e) {
                LOG.error("登陆失败,用户名[{}],密码[{}]",username,password);
            }


        }

        return "redirect:/index.html";
    }

}
