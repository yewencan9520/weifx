package com.abc.Business.service;

import com.abc.Business.bean.JsonResult;
import com.abc.Business.bean.ResultOv;
import com.abc.Business.bean.WxbCustomer;
import com.abc.Business.bean.WxbGoods;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductDaoService {

    JsonResult insertPic(MultipartFile file);

    void insertData(ResultOv resultOv) throws Exception;

    List<WxbGoods> findAllGoodsById(String customerId);

    void insertUser(WxbCustomer customer);

}
