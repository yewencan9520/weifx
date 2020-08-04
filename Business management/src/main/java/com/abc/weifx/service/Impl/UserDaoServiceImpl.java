package com.abc.weifx.service.Impl;

import com.abc.weifx.bean.UserInfo;
import com.abc.weifx.dao.UserDao;
import com.abc.weifx.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDaoServiceImpl implements UserDaoService {

    @Autowired
    private UserDao userDao;
    @Override
    public UserInfo findUser(String username) {
        UserInfo user = userDao.findUser(username);
        return user;
    }
}
