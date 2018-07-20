package org.szpinc.study.shiro.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController extends BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultController.class);

    @RequestMapping(value = "/{page}.html")
    public String page(@PathVariable("page") String page) {
        return page;
    }
}
