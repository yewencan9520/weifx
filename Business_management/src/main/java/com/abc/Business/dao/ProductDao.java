package com.abc.Business.dao;


import com.abc.Business.bean.WxbCustomer;
import com.abc.Business.bean.WxbGoodSku2;
import com.abc.Business.bean.WxbGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDao {

    void insertAddProduct(WxbGoods wxbGoods);

    void insertAddSku(@Param("list") List<WxbGoodSku2> list, @Param("goodsId") String goodsId);

    List<WxbGoods> findAllGoodsById(String customerId);

    void insertUser(WxbCustomer customer);

}
