package com.abc.platform.dao;

import com.abc.platform.bean.WxbGood;
import com.abc.platform.bean.WxbGoodSku2;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddDao {

    void insertAddProduct(WxbGood wxbGood);

    void insertAddSku(@Param("list") List<WxbGoodSku2> list, @Param("goodsId") String goodsId);


}
