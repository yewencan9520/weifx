package com.abc.weifx.service;

import com.abc.weifx.bean.WxbCustomer;

public interface UserDaoService {

    WxbCustomer findUser(String username);
}
