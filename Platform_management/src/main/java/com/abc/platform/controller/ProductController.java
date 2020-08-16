package com.abc.platform.controller;


import com.abc.platform.bean.JsonResult;
import com.abc.platform.bean.ResultOv;
import com.abc.platform.bean.WxbCustomer;
import com.abc.platform.bean.WxbGoods;
import com.abc.platform.service.ProductDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductDaoService ProductDaoService;

    /**
     * 商品信息管理
     */
    @RequestMapping("gInfo")
    public String goosInfo(Model model){
//        Integer currentpage = getcurrentpage(currentPage);
        List<WxbGoods>  allGoods = ProductDaoService.findAllGoods();
        model.addAttribute("page",allGoods);
        return "goodsInfo";
    }

    /**
     * 商品信息管理-新增
     */
    @RequestMapping("save")
    @ResponseBody
    public JsonResult saveData(@RequestBody ResultOv resultOv){
        JsonResult jsonResult = new JsonResult();
        try {
            ProductDaoService.insertData(resultOv);
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
    public JsonResult addProduct(MultipartFile file){
        JsonResult jsonResults = ProductDaoService.insertPic(file);
        return jsonResults;
    }

    /**
     * 商户信息管理
     */
    @RequestMapping("gUser")
    public String goodsUser(Model model){
        List<WxbCustomer> customer = ProductDaoService.findAllCustomer();
        model.addAttribute("customer",customer);
        return "goodsUser";
    }

    /**
     * 商户信息管理-新增商户
     */
    @RequestMapping("gUserAdd")
    @ResponseBody
    public JsonResult goodsUserAdd(@RequestBody WxbCustomer customer){
        JsonResult jsonResult = new JsonResult();
        try{
            ProductDaoService.insertUser(customer);
            jsonResult.setCode(0);
            jsonResult.setObj("新增成功");
            return jsonResult;
        }catch (Exception e){
            jsonResult.setCode(1);
            jsonResult.setObj("新增失败");
            return jsonResult;
        }
    }

    /**
     * 商户信息管理-修改商户之查询
     */
    @RequestMapping("gUserUpdate")
    public String goodsUserUpdate(String cId, Model model){
        WxbCustomer customer = ProductDaoService.findUserById(cId);
        model.addAttribute("upCus",customer);
        return "goodsUserUpdate";
    }
    /**
     * 商户信息管理-修改商户之保存
     */
    @RequestMapping("gUserSaveUpdate")
    @ResponseBody
    public JsonResult gUserSaveUpdate(@RequestBody WxbCustomer customer){
        JsonResult jsonResult = new JsonResult();
        try{
            ProductDaoService.updateUser(customer);
            jsonResult.setCode(0);
            jsonResult.setObj("修改成功");
            return jsonResult;
        }catch (Exception e){
            jsonResult.setCode(1);
            jsonResult.setObj("修改失败");
            return jsonResult;
        }
    }

    /**
     * 商户信息管理-删除商户
     */
    @RequestMapping("deleteUser")
    @ResponseBody
    public JsonResult deleteUser(String customerId){
        JsonResult jsonResult = new JsonResult();
        try{
            ProductDaoService.deleteUser(customerId);
            jsonResult.setCode(0);
            jsonResult.setObj("删除成功");
            return jsonResult;
        }catch (Exception e){
            jsonResult.setCode(1);
            jsonResult.setObj("删除失败");
            return jsonResult;
        }
    }

    /**
     * 套餐置顶操作
     */
    @RequestMapping("tops")
    @ResponseBody
    public JsonResult tops(String goodsId){
        JsonResult jsonResult = new JsonResult();
        try {
            int top=1;
            ProductDaoService.updateSkuTopById(top,goodsId);
            jsonResult.setCode(0);
            jsonResult.setObj("置顶操作成功");
            return jsonResult;
        }catch (Exception e){
            jsonResult.setCode(1);
            jsonResult.setObj("置顶操作失败");
            return jsonResult;
        }
    }
    /**
     * 套餐取消置顶操作
     */
    @RequestMapping("untops")
    @ResponseBody
    public JsonResult untops(String goodsId){
        JsonResult jsonResult = new JsonResult();
        try {
            int untop=0;
            ProductDaoService.updateSkuTopById(untop,goodsId);
            jsonResult.setCode(0);
            jsonResult.setObj("取消置顶操作成功");
            return jsonResult;
        }catch (Exception e){
            jsonResult.setCode(0);
            jsonResult.setObj("取消置顶操作失败");
            return jsonResult;
        }
    }
    /**
     * 套餐推荐操作
     */
    @RequestMapping("recomed")
    @ResponseBody
    public JsonResult recomed(String goodsId){
        JsonResult jsonResult = new JsonResult();
        try {
            int recomed=1;
            ProductDaoService.updateSkurecomedById(recomed,goodsId);
            jsonResult.setCode(0);
            jsonResult.setObj("推荐操作成功");
            return jsonResult;
        }catch (Exception e){
            jsonResult.setCode(0);
            jsonResult.setObj("推荐操作失败");
            return jsonResult;
        }
    }
    /**
     * 套餐取消推荐操作
     */
    @RequestMapping("unrecomed")
    @ResponseBody
    public JsonResult unrecomed(String goodsId){
        JsonResult jsonResult = new JsonResult();
        try {
            int unrecomed=0;
            ProductDaoService.updateSkurecomedById(unrecomed,goodsId);
            jsonResult.setCode(0);
            jsonResult.setObj("取消推荐操作成功");
            return jsonResult;
        }catch (Exception e){
            jsonResult.setCode(0);
            jsonResult.setObj("取消推荐操作失败");
            return jsonResult;
        }
    }
    /**
     * 套餐上架操作
     */
    @RequestMapping("states")
    @ResponseBody
    public JsonResult states(String goodsId){
        JsonResult jsonResult = new JsonResult();
        try {
            int states=1;
            ProductDaoService.updateSkustatesById(states,goodsId);
            jsonResult.setCode(0);
            jsonResult.setObj("上架操作成功");
            return jsonResult;
        }catch (Exception e){
            jsonResult.setCode(0);
            jsonResult.setObj("上架操作失败");
            return jsonResult;
        }
    }
    /**
     * 套餐下架操作
     */
    @RequestMapping("unstates")
    @ResponseBody
    public JsonResult unstates(String goodsId){
        JsonResult jsonResult = new JsonResult();
        try {
            int unstates=2;
            ProductDaoService.updateSkustatesById(unstates,goodsId);
            jsonResult.setCode(0);
            jsonResult.setObj("下架操作成功");
            return jsonResult;
        }catch (Exception e){
            jsonResult.setCode(0);
            jsonResult.setObj("下架操作失败");
            return jsonResult;
        }
    }
//
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
