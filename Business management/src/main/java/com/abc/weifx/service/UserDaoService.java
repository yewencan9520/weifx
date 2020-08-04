package com.abc.weifx.service;

import com.abc.weifx.bean.UserInfo;

public interface UserDaoService {

    UserInfo findUser(String username);
}
