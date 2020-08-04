package com.abc.weifx.service;

import com.abc.weifx.bean.JsonResult;
import org.springframework.web.multipart.MultipartFile;

public interface AddDaoService {

    JsonResult insertPic(MultipartFile file);

    int insertData();

}
