package com.abc.weifx;

import com.abc.weifx.bean.UserInfo;
import com.abc.weifx.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WeifxApplicationTests {

    @Autowired
    private UserDao userDao;
    @Test
    void contextLoads() {

        UserInfo admin = userDao.findUser("admin");
        System.out.println(admin);
    }

}
