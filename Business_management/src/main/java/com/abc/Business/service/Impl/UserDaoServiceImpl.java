package com.abc.Business.service.Impl;

import com.abc.Business.bean.WxbCustomer;
import com.abc.Business.dao.UserDao;
import com.abc.Business.service.UserDaoService;
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
