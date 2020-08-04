package com.abc.weifx.dao;

import com.abc.weifx.bean.UserInfo;


public interface UserDao {

    UserInfo findUser(String username);

//    List<String> findPermission (String username);
//
//    String findRole (String username);
}
