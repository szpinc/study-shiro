package org.szpinc.study.shiro.spring.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.szpinc.study.shiro.spring.entity.User;
import org.szpinc.study.shiro.spring.service.UserService;

public class ShiroRealm extends AuthenticatingRealm {

    private static final Logger LOG = LoggerFactory.getLogger(ShiroRealm.class);
    @Autowired
    private UserService userService;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;

        String username = token.getUsername();

        char[] password = token.getPassword();

        User user = userService.getUserByUsername(username);

        if (user == null) {
            LOG.info("用户不存在[{}]",username);
            throw new UnknownAccountException("用户不存在");
        }

        return new SimpleAuthenticationInfo(username,user.getPassword(),ByteSource.Util.bytes(username),getName());
    }
}
