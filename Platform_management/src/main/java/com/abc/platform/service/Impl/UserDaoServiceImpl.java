package com.abc.platform.service.Impl;

import com.abc.platform.bean.UserInfo;
import com.abc.platform.service.UserDaoService;
import com.abc.platform.dao.UserDao;
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
