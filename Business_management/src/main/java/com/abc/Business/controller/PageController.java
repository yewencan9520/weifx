package com.abc.Business.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {

    @RequestMapping("login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("index")
    public String toindex(){ return "index"; }

    @RequestMapping("goods_info")
    public String toGoodInfo(){
        return "goods_info";
    }

    @RequestMapping("goods_add")
    public String toGoodAdd(){
        return "goods_add";
    }

}
