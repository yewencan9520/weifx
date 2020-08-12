package com.abc.Client.dao;


import com.abc.Client.bean.WxbCustomer;

public interface UserDao {

    WxbCustomer findUser(String username);

}
