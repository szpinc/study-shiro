package org.szpinc.study.shiro.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(BaseController.class);

    @RequestMapping(value = "/{page}.html")
    public String page (@PathVariable("page") String page) {
        if (LOG.isDebugEnabled()){
            LOG.debug("Request Page is [{}]",page);
        }
        return page;
    }

}
