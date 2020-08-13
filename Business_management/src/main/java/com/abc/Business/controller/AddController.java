package com.abc.Business.controller;


import com.abc.Business.bean.JsonResult;
import com.abc.Business.bean.ResultOv;
import com.abc.Business.service.AddDaoService;
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
