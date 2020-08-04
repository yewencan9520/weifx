package com.abc.platform.dao;

import com.abc.platform.bean.UserInfo;


public interface UserDao {

    UserInfo findUser(String username);

//    List<String> findPermission (String username);
//
//    String findRole (String username);
}
