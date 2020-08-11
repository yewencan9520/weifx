package com.abc.weifx.dao;


import com.abc.weifx.bean.WxbCustomer;

public interface UserDao {

    WxbCustomer findUser(String username);

//    List<String> findPermission (String username);
//
//    String findRole (String username);
}
