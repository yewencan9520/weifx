package com.abc.platform.dao;

import com.abc.platform.bean.WxbGood;
import com.abc.platform.bean.WxbGoodSku2;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddDao {

    int insertAddProduct(WxbGood wxbGood);

    int insertAddSku(@Param("sku2List") List<WxbGoodSku2> sku2List, @Param("goodsId") String goodsId);


}
