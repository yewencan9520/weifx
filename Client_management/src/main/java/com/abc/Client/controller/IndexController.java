package com.abc.Client.controller;

import com.abc.Client.bean.WxbGood;
import com.abc.Client.service.IndexDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private IndexDaoService indexDaoService;
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

}
