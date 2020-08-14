package com.abc.Client.controller;


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

    @RequestMapping("office")
    public String toOffice(){
        return "office";
    }

    @RequestMapping("myOrder")
    public String tomyOrder(){
        return "myOrder";
    }

    @RequestMapping("order")
    public String toOrder(){
        return "order";
    }

    @RequestMapping("orderClose")
    public String toOrderClose(){
        return "orderClose";
    }

    @RequestMapping("CloseMoney")
    public String toCloseMoney(){
        return "CloseMoney";
    }

    @RequestMapping("pay")
    public String toPay(){
        return "pay";
    }


}
