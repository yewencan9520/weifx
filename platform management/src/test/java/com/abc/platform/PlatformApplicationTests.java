package com.abc.platform;

import com.abc.platform.bean.UserInfo;
import com.abc.platform.bean.WxbGood;
import com.abc.platform.dao.AddDao;
import com.abc.platform.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class PlatformApplicationTests {

    @Autowired
    private UserDao userDao;
    private AddDao addDao;
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
        WxbGood wxbGood = new WxbGood();
        wxbGood.setGoodsId("1");
        wxbGood.setTypeId("2");
        wxbGood.setGoodsName("hahaha");
        wxbGood.setGoodsPic1("test1");
        wxbGood.setGoodsPic2("test2");
        wxbGood.setGoodsPic3("test3");
        System.out.println(wxbGood);
        addDao.insertAddProduct(wxbGood);

    }

}
