package com.abc.Business.dao;

import com.abc.Business.bean.WxbCustomer;


public interface UserDao {

    WxbCustomer findUser(String username);

}
