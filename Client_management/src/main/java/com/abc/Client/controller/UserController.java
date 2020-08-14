package com.abc.Client.controller;


import com.abc.Client.bean.JsonResult;
import com.abc.Client.bean.TreeNodeBean;
import com.abc.Client.service.TreeNodeDaoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private TreeNodeDaoService treeNodeDaoService;

    @RequestMapping("Clogin")
    @ResponseBody
    public JsonResult login(String username, String password, HttpSession session){
        JsonResult jsonResult = new JsonResult();
        try {
            Subject subject = SecurityUtils.getSubject();
            Md5Hash pwd = new Md5Hash(password);
            //password先进行MD5加密之后
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, pwd.toHex());
            //登录成功就不会有异常
            subject.login(usernamePasswordToken);
            session.setAttribute("username",username);
            jsonResult.setCode(0);
            jsonResult.setObj(username);
            return jsonResult;
        }catch (Exception e){
            jsonResult.setCode(1);
            jsonResult.setObj("账号或密码错误，请重新登陆！");
            return jsonResult;
        }
    }

    @RequestMapping("tree")
    @ResponseBody
    public TreeNodeBean treeNode(){
//        String username = SecurityUtils.getSubject().getPrincipal().toString();
        TreeNodeBean beans = treeNodeDaoService.findTreeNodeByUsername("admin");
        return beans;
    }

}
