package com.abc.Client.controller;

import com.abc.Client.bean.JsonResult;
import com.abc.Client.bean.WxbGood;
import com.abc.Client.bean.WxbOrder;
import com.abc.Client.service.IndexDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private IndexDaoService indexDaoService;
//    @RequestMapping("toIndex")
//    public String toIndex(){
//        return "index";
//    }
    @RequestMapping("toOffice")
    public String findAllSku(Model model){
        List<WxbGood> allSku = indexDaoService.findAllSku();
        model.addAttribute("allSku",allSku);
        return "office";
    }
    @RequestMapping("toOfficeInfo")
    public String officeInfo(String skuId,Model model){
        WxbGood sku = indexDaoService.findSkuById(skuId);
        model.addAttribute("sku",sku);
        return "officeInfo";
    }
    @RequestMapping("toOrder")
    public String order(String skuId,String goodsName,String goodsPic1,String skuPrice,Model model){
        WxbGood wxbGood = new WxbGood();
        wxbGood.setSkuId(skuId);
        wxbGood.setGoodsName(goodsName);
        wxbGood.setGoodsPic1(goodsPic1);
        wxbGood.setSkuPrice(skuPrice);
        model.addAttribute("wxbGood",wxbGood);
        return "order";
    }
    @RequestMapping("saveOrder")
    @ResponseBody
    public JsonResult saveOrder(@RequestBody WxbOrder wxbOrder){
        JsonResult jsonResult = new JsonResult();
        try {
            indexDaoService.insertOrder(wxbOrder);
            jsonResult.setCode(0);
            jsonResult.setObj("订单提交成功");
            return jsonResult;
        }catch (Exception e){
            jsonResult.setCode(1);
            jsonResult.setObj("订单提交失败，请稍后再试");
            return jsonResult;
        }
    }

}
