package com.abc.platform.service.Impl;

import com.abc.platform.bean.JsonResult;
import com.abc.platform.bean.ResultOv;
import com.abc.platform.bean.WxbGood;
import com.abc.platform.bean.WxbGoodSku2;
import com.abc.platform.dao.AddDao;
import com.abc.platform.service.AddDaoService;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

@Service
public class AddDaoServiceImpl implements AddDaoService {

    @Autowired
    private AddDao addDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void insertData(ResultOv resultOv) throws Exception{
        logs(resultOv);
        String gId = String.valueOf(new Random().nextInt(100000000));
        WxbGood wxbGood = resultOv.getWxbGood();
        wxbGood.setGoodsId(gId);
        insertAddProduct(wxbGood);
        insertAddSku(resultOv.getSku2List(),wxbGood.getGoodsId());
    }

    /**
     * 新增商品信息
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void insertAddProduct(WxbGood wxbGood){
        addDao.insertAddProduct(wxbGood);
    }

    /**
     * 新增套餐信息
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void insertAddSku(List<WxbGoodSku2> sku2List,String goodId){
        addDao.insertAddSku(sku2List,goodId);
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void logs(Object obj){

    }

    /**
     * 新增图片到 nginx
     */
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
}
