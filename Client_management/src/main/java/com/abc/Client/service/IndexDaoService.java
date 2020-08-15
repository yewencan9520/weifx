package com.abc.Client.service;


import com.abc.Client.bean.WxbGood;
import com.abc.Client.bean.WxbOrder;

import java.util.List;

public interface IndexDaoService {

    List<WxbGood> findAllSku();

    WxbGood findSkuById(String skuId);

    void insertOrder(WxbOrder order);
}
