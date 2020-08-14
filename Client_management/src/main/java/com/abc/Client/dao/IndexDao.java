package com.abc.Client.dao;

import com.abc.Client.bean.WxbGood;
import com.abc.Client.bean.WxbOrder;

import java.util.List;

public interface IndexDao {

    List<WxbGood> findAllSku();

    WxbGood findSkuById(String skuId);

    void insertOrder(WxbOrder order);

}
