package com.abc.Client.dao;


import com.abc.Client.bean.UserInfo;

public interface UserDao {

    UserInfo findUser(String username);

}
