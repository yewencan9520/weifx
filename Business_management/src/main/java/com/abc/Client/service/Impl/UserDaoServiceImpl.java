package com.abc.Client.service.Impl;

import com.abc.Client.bean.WxbCustomer;
import com.abc.Client.dao.UserDao;
import com.abc.Client.service.UserDaoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserDaoServiceImpl implements UserDaoService {

    @Resource
    private UserDao userDao;
    @Override
    public WxbCustomer findUser(String username) {
        WxbCustomer user = userDao.findUser(username);
        return user;
    }
}
