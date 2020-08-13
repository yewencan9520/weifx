package com.abc.Client.service;

import com.abc.Client.bean.WxbGood;

import java.util.List;

public interface IndexDaoService {

    List<WxbGood> findAllSku();

    WxbGood findSkuById(String skuId);
}
