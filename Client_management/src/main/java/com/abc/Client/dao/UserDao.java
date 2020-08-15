package com.abc.Client.dao;


import com.abc.Client.bean.WxbMemeber;

public interface UserDao {

    WxbMemeber findUser(String account);

}
