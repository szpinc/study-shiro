package org.szpinc.study.shiro.spring.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroRealm extends AuthenticatingRealm {

    private static final Logger LOG = LoggerFactory.getLogger(ShiroRealm.class);

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("token is [{}]",authenticationToken.hashCode());
        }
        return null;
    }
}
