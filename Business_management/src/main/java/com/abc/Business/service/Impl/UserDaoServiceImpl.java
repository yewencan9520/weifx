package com.abc.Business.service.Impl;

import com.abc.Business.Exception.UserLoginException;
import com.abc.Business.bean.WxbCustomer;
import com.abc.Business.dao.UserDao;
import com.abc.Business.service.UserDaoService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserDaoServiceImpl implements UserDaoService {
    @Resource
    private UserDao userDao;

    @Override
    public WxbCustomer findUser(String username,String password)throws Exception {
        String pwd = new Md5Hash(password).toHex();
        WxbCustomer user = userDao.findUser(username,pwd);
        if(user!=null){
            return user;
        }else {
            throw new UserLoginException();
        }
    }
}
