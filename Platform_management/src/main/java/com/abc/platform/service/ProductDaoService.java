package com.abc.platform.service;

import com.abc.platform.bean.JsonResult;
import com.abc.platform.bean.ResultOv;
import com.abc.platform.bean.WxbCustomer;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductDaoService {

    JsonResult insertPic(MultipartFile file);

    void insertData(ResultOv resultOv) throws Exception;

    List<PageInfo> pageGInfo(Integer currentPage);

    int updateSkuTopById(@Param("top") int top, @Param("goodsId") String goodsId);

    int updateSkurecomedById(@Param("recomed") int recomed,@Param("goodsId") String goodsId);

    int updateSkustatesById(@Param("state") int state,@Param("goodsId") String goodsId);

    List<WxbCustomer> findAllCustomer();

    void insertUser(WxbCustomer customer);

}
