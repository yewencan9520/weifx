package com.abc.Business.controller;


import com.abc.Business.bean.JsonResult;
import com.abc.Business.bean.WxbCustomer;
import com.abc.Business.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @RequestMapping("Blogin")
    @ResponseBody
    public JsonResult login(String username, String password, HttpSession session){
        JsonResult jsonResult = new JsonResult();
        try {
            WxbCustomer user = userDaoService.findUser(username,password);
            session.setAttribute("user",user);
            jsonResult.setCode(0);
            jsonResult.setObj(user.getCustomerId());
            return jsonResult;
        }catch (Exception e){
            jsonResult.setCode(1);
            jsonResult.setObj("账号或密码错误，请重新登陆！");
            return jsonResult;
        }
    }

}
