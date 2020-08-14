package com.abc.Client.service;

import com.abc.Client.bean.WxbCustomer;

public interface UserDaoService {

    WxbCustomer findUser(String username);
}
