package com.abc.Business.controller;


import com.abc.Business.bean.JsonResult;
import com.abc.Business.bean.ResultOv;
import com.abc.Business.bean.WxbCustomer;
import com.abc.Business.bean.WxbGoods;
import com.abc.Business.service.ProductDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductDaoService productDaoService;

    @RequestMapping("toIndex")
    public String toIndex(HttpSession session, Model model) {
        WxbCustomer user = (WxbCustomer) session.getAttribute("user");
        model.addAttribute("cUser", user);
        return "index";
    }

    /**
     * 商品信息管理
     */
    @RequestMapping("gInfo")
    public String goodsInfo(String customerId, Model model) {
//        Integer currentpage = getcurrentpage(currentPage);
        List<WxbGoods> pageInfo = productDaoService.findAllGoodsById(customerId);
        model.addAttribute("page", pageInfo);
        return "goodsInfo";
    }

    /**
     * 商品信息管理-新增
     */
    @RequestMapping("save")
    @ResponseBody
    public JsonResult saveData(@RequestBody ResultOv resultOv) {
        JsonResult jsonResult = new JsonResult();
        try {
            productDaoService.insertData(resultOv);
            jsonResult.setCode(0);
            jsonResult.setObj("新增成功");
        } catch (Exception e) {
            jsonResult.setCode(1);
            jsonResult.setObj("新增失败，请检查！");
        }
        return jsonResult;
    }

    /**
     * 商品信息管理-新增-图片上传操作
     */
    @RequestMapping("upload")
    @ResponseBody
    public JsonResult addProduct(MultipartFile file) {
        JsonResult jsonResults = productDaoService.insertPic(file);
        return jsonResults;
    }

    /**
     * 商户信息管理-新增商户
     */
    @RequestMapping("gUserAdd")
    @ResponseBody
    public JsonResult goodsUserAdd(@RequestBody WxbCustomer customer) {
        JsonResult jsonResult = new JsonResult();
        try {
            productDaoService.insertUser(customer);
            jsonResult.setCode(0);
            jsonResult.setObj("新增成功");
            return jsonResult;
        } catch (Exception e) {
            jsonResult.setCode(1);
            jsonResult.setObj("新增失败");
            return jsonResult;
        }
    }

//    /**
//     *判断currentpage值
//     */
//    public Integer getcurrentpage(String currentPage){
//        if(currentPage==null){
//            currentPage="0";
//        }
//        Integer currentPage1=Integer.parseInt(currentPage);
//        return currentPage1;
//    }
}
