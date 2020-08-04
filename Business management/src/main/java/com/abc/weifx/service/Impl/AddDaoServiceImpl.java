package com.abc.weifx.service.Impl;

import com.abc.weifx.bean.JsonResult;
import com.abc.weifx.service.AddDaoService;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
public class AddDaoServiceImpl implements AddDaoService {

    @Override
    public int insertData() {

//        String title = copy_form.getSku_title().replace("|", "");
//        copy_form.setSku_title(title);
//        String cost = copy_form.getSku_cost().replace("|", "");
//        copy_form.setSku_cost(cost);
//        String pmoney = copy_form.getSku_pmoney().replace("|", "");
//        copy_form.setSku_pmoney(pmoney);
//        String price = copy_form.getSku_price().replace("|", "");
//        copy_form.setSku_price(price);
//
//        int size = productDao.insertProduct(copy_form);
        return 1;
    }

    @Override
    public JsonResult insertPic(MultipartFile file) {
        JsonResult jsonResult= new JsonResult();
        try {
            InputStream inputStream = file.getInputStream();
            FTPClient ftp = new FTPClient();
            //连接FTP服务器，默认端口是21
            ftp.connect("192.168.121.1",21);
            //匿名用户必须使用anonymous登录，密码是邮箱
            boolean login = ftp.login("anonymous", "1328662381@qq.com");
            int replyCode = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.out.println("获取响应失败");
                jsonResult.setCode(1);
                return jsonResult;
            }
            //设置接收文件类型为二进制文件
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            //服务器上创建images文件夹
            ftp.makeDirectory("images");
            //切换ftp默认文件夹
            ftp.changeWorkingDirectory("images");

            //将本地图片上传到ftp服务器上
            ftp.storeFile(file.getOriginalFilename(), inputStream);
            //退出登录
            ftp.logout();
            jsonResult.setCode(0);
            jsonResult.setObj("http://localhost/images/"+file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonResult;
    }

}
