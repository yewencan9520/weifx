package com.abc.Client.service;

import com.abc.Client.bean.JsonResult;
import org.springframework.web.multipart.MultipartFile;

public interface AddDaoService {

    JsonResult insertPic(MultipartFile file);

    int insertData();

}
