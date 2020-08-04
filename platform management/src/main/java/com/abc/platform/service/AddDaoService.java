package com.abc.platform.service;

import com.abc.platform.bean.JsonResult;
import com.abc.platform.bean.ResultOv;
import org.springframework.web.multipart.MultipartFile;

public interface AddDaoService {

    JsonResult insertPic(MultipartFile file);

    void insertData(ResultOv resultOv) throws Exception;

}
