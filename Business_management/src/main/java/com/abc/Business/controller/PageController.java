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

    @RequestMapping("goodsAdd")
    public String togoodsAdd(){ return "goodsAdd"; }


}
