package org.szpinc.study.shiro.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.szpinc.study.shiro.spring.service.UserService;

public class BaseController {

    @Autowired
    protected UserService userService;

}
