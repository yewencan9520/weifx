package com.abc.platform.service;

import com.abc.platform.bean.JsonResult;
import org.springframework.web.multipart.MultipartFile;

public interface AddDaoService {

    JsonResult insertPic(MultipartFile file);

    int insertData();

}
