package com.abc.platform.service.Impl;

import com.abc.platform.bean.*;
import com.abc.platform.dao.ProductDao;
import com.abc.platform.service.ProductDaoService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

@Service
public class ProductDaoServiceImpl implements ProductDaoService {

    @Resource
    private ProductDao ProductDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void insertData(ResultOv resultOv) throws Exception{
        logs(resultOv);
        String gId = String.valueOf(new Random().nextInt(100000000));
        WxbGoods wxbGood = resultOv.getWxbGood();
        wxbGood.setGoodsId(gId);
        AddProduct(wxbGood);
        AddSku(resultOv.getSku2List(),wxbGood.getGoodsId());
    }

    /**
     * 商品信息管理首页+分页
     */
    @Override
    public List<PageInfo> pageGInfo(Integer currentPage) {
        List<PageInfo> pages = ProductDao.findAllGoodsByPage(currentPage);
        return pages;
    }

    /**
     * 套餐置顶/取消置顶操作
     */
    @Override
    public int updateSkuTopById(int top,String goodsId) {
        int top1 = ProductDao.updateSkuTopById(top, goodsId);
        return top1;
    }
    /**
     * 套餐推荐/取消推荐操作
     */
    @Override
    public int updateSkurecomedById(int recomed,String goodsId) {
        int recomeds = ProductDao.updateSkurecomedById(recomed, goodsId);
        return recomeds;
    }
    /**
     * 套餐上架下架操作
     */
    @Override
    public int updateSkustatesById(int state,String goodsId) {
        int states = ProductDao.updateSkustatesById(state, goodsId);
        return states;
    }

    @Override
    public List<WxbCustomer> findAllCustomer() {
        List<WxbCustomer> customer = ProductDao.findAllCustomer();
        return customer;
    }

    @Override
    public void insertUser(WxbCustomer customer) {
        String cId = String.valueOf(new Random().nextInt(10000000));
        customer.setCustomerId(cId);
        customer.setCreatetime(new Timestamp(System.currentTimeMillis()));
        ProductDao.insertUser(customer);
    }

    /**
     * 新增商品信息
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void AddProduct(WxbGoods wxbGood){
        ProductDao.insertAddProduct(wxbGood);
    }

    /**
     * 新增套餐信息
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void AddSku(List<WxbGoodSku2> sku2List,String goodsId){
        ProductDao.insertAddSku(sku2List,goodsId);
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


}
