package com.abc.weifx.realm;

import com.abc.weifx.bean.UserInfo;
import com.abc.weifx.dao.UserDao;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Component
@Service
public class MyRealm extends AuthorizingRealm {

    @Resource
    private UserDao userDao;

    @Override
    public String getName() {
        return "myRealm";
    }

    /**
     * 授权：权限角色管理
     * @param principalCollection username
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Object username = principalCollection.getPrimaryPrincipal();
//        List<String> permissionList = userDao.findPermission(username.toString());
//        String role = userDao.findRole(username.toString());
        //将权限集合交给Shiro
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        simpleAuthorizationInfo.addStringPermissions(permissionList);
//        simpleAuthorizationInfo.addRole(role);
        return simpleAuthorizationInfo;
    }

    /**
     * 认证：登录
     * @param authenticationToken 包含用户的用户名和密码
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //用户名和密码
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        UserInfo userInfo = userDao.findUser(username);

        /**
         * 参数1：用户名
         * 参数2：密码
         * 参数3：realm的名称：唯一
         */
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userInfo.getUsername(),userInfo.getPassword(),getName());
        //将simpleAuthenticationInfo交给SecurityManager进行登录逻辑判断
        return simpleAuthenticationInfo;
    }
}
