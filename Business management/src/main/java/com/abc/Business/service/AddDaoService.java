package com.abc.Business.service;

import com.abc.Business.bean.JsonResult;
import org.springframework.web.multipart.MultipartFile;

public interface AddDaoService {

    JsonResult insertPic(MultipartFile file);

    int insertData();

}
