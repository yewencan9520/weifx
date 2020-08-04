package com.abc.platform;

import com.abc.platform.bean.UserInfo;
import com.abc.platform.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class PlatformApplicationTests {

    @Autowired
    private UserDao userDao;
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

}
