package com.abc.Client.realm;

import com.abc.Client.bean.WxbMemeber;
import com.abc.Client.dao.UserDao;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
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

    /**
     * 授权：权限角色管理
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        Object username = principalCollection.getPrimaryPrincipal();
//        List<String> permissionList = userDao.findPermission(username.toString());
//        String role = userDao.findRole(username.toString());
        //将权限集合交给Shiro
//        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        simpleAuthorizationInfo.addStringPermissions(permissionList);
//        simpleAuthorizationInfo.addRole(role);
        return null;
    }

    /**
     * 认证：登录
     * 包含用户的用户名和密码
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //用户名和密码
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        WxbMemeber user = userDao.findUser(username);
        //参数1：用户名/参数2：密码/参数3：realm的名称：唯一
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getAccount(),user.getPassword(),"myRealm");
        //将simpleAuthenticationInfo交给SecurityManager进行登录逻辑判断
         return simpleAuthenticationInfo;
    }
}
