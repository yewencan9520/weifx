package com.abc.platform.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {

    @RequestMapping("login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("index")
    public String toindex() {
        return "index";
    }

    @RequestMapping("gUserAdd")
    public String toGoodInfo() {
        return "goodsUserAdd";
    }

    @RequestMapping("goodsAdd")
    public String toGoodAdd() {
        return "goodsAdd";
    }

}
