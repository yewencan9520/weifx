package com.abc.weifx.service.Impl;

import com.abc.weifx.bean.WxbCustomer;
import com.abc.weifx.dao.UserDao;
import com.abc.weifx.service.UserDaoService;
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
