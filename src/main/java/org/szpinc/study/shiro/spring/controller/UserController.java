package org.szpinc.study.shiro.spring.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.szpinc.study.shiro.spring.entity.User;
import org.szpinc.study.shiro.spring.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {


    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {

        Subject currentSubject = SecurityUtils.getSubject();

        if (!currentSubject.isAuthenticated()) {
            //将用户名密码封装成UsernamePasswordToken对象
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);

            LOG.debug("token:[{}]", token.hashCode());


            try {
                //执行登陆
                currentSubject.login(token);
            } catch (AuthenticationException e) {
                LOG.error("登陆失败,用户名[{}],密码[{}]", username, password);
                LOG.error("error msg",e);
            }


        }

        return "redirect:/index.html";
    }


    @RequestMapping(value = "/registry", method = RequestMethod.POST)
    public String registry(@RequestParam("username") String username, @RequestParam("password") String password) {
        SimpleHash hash = new SimpleHash("MD5", password, ByteSource.Util.bytes(username), 1024);
        password = hash.toString();
        User user = new User(DigestUtils.md5DigestAsHex((username + password + System.currentTimeMillis()).getBytes()), username, password);
        userService.addUser(user);
        return "redirect:/index.html";
    }

}
