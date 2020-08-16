package com.abc.Business.dao;

import com.abc.Business.bean.WxbCustomer;
import org.apache.ibatis.annotations.Param;


public interface UserDao {

    WxbCustomer findUser(@Param("username") String username, @Param("pwd") String pwd);

}
