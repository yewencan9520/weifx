package com.abc.Client.controller;


import com.abc.Client.bean.JsonResult;
import com.abc.Client.bean.ResultOv;
import com.abc.Client.service.AddDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class AddController {

    @Autowired
    private AddDaoService addDaoService;

    @RequestMapping("save")
    @ResponseBody
    public JsonResult saveData(ResultOv resultOv){
        JsonResult jsonResult = new JsonResult();
//        productDaoService.insertData(copy_form);
        return jsonResult;
    }

    @RequestMapping("upload")
    @ResponseBody
    public JsonResult addProduct(MultipartFile file){
        JsonResult jsonResults = addDaoService.insertPic(file);
        return jsonResults;
    }

}
