package com.abc.platform;

import com.abc.platform.bean.*;
import com.abc.platform.dao.OrderDao;
import com.abc.platform.dao.ProductDao;
import com.abc.platform.dao.RoleDao;
import com.abc.platform.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

@SpringBootTest
class PlatformApplicationTests {

    @Autowired
    private UserDao userDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private OrderDao orderDao;
    @Test
    void contextLoads() {

        UserInfo admin = userDao.findUser("admin");
        System.out.println(admin);
    }

    @Test
    public void random(){
        Random random = new Random();
        int i = random.nextInt(100000000);
        System.out.println(i);
    }
    @Test
    public void AddDao(){
        WxbGoods wxbGood = new WxbGoods();
        wxbGood.setGoodsId("1");
        wxbGood.setTypeId("2");
        wxbGood.setGoodsName("hahaha");
        wxbGood.setGoodsPic1("test1");
        wxbGood.setGoodsPic2("test2");
        wxbGood.setGoodsPic3("test3");
        System.out.println(wxbGood);
        productDao.insertAddProduct(wxbGood);

    }
    @Resource
    private RoleDao roleDao;
    @Test
    public void findAllRole(){
        List<SysRole> rolePage = roleDao.findRolePage();
        for (SysRole sysRole : rolePage) {
            System.out.println("===============================");
            System.out.println(sysRole);
        }

    }
    @Test
    public void findAllGoodsByPage(){
        List<WxbGoods>  allGoods = productDao.findAllGoods();
        System.out.println(allGoods);
    }

    @Test
    public void updata(){
        productDao.updateSkustatesById(1,"16344265");
    }

    @Test
    public void findAllCustomer(){
        List<WxbCustomer> customer = productDao.findAllCustomer();
        System.out.println(customer);
    }
    @Test
    public void getTime(){
        Timestamp time = new Timestamp(System.currentTimeMillis());
        System.out.println(time);
    }

    @Test
    public void findAllOrder(){
        List<WxbOrder> allOrder = orderDao.findAllOrder();
        System.out.println(allOrder);
    }

}
