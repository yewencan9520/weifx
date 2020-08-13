package com.abc.Business.dao;


import com.abc.Business.bean.UserInfo;

public interface UserDao {

    UserInfo findUser(String username);

}
