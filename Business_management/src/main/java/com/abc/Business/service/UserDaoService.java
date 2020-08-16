package com.abc.Business.service;

import com.abc.Business.bean.WxbCustomer;

public interface UserDaoService {

    WxbCustomer findUser(String username,String pwd)throws Exception;
}
