package com.abc.Client;

import com.abc.Client.bean.WxbOrder;
import com.abc.Client.dao.IndexDao;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ClientApplicationTests {

    @Resource
    private IndexDao indexDao;
    @Test
    void contextLoads() {
    }
    @Test
    public void order(){
        WxbOrder wxbOrder = new WxbOrder();
        wxbOrder.setOrderId("1");
        wxbOrder.setAddress("2222");
        wxbOrder.setGoodsId("2222");
        wxbOrder.setSkuId("0000000");
        indexDao.insertOrder(wxbOrder);
    }

}
