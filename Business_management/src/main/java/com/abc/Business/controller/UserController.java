package com.abc.Business.controller;


import com.abc.Business.bean.JsonResult;
import com.abc.Business.bean.TreeNodeBean;
import com.abc.Business.service.TreeNodeDaoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private TreeNodeDaoService treeNodeDaoService;

    @RequestMapping("login")
    @ResponseBody
    public JsonResult login(String username,String password){
        JsonResult jsonResult = new JsonResult();
        try {
            Subject subject = SecurityUtils.getSubject();
            Md5Hash pwd = new Md5Hash(password);
            //password先进行MD5加密之后
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, pwd.toHex());
            //登录成功就不会有异常
            subject.login(usernamePasswordToken);
            jsonResult.setCode(0);
            jsonResult.setObj("page/index");
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
