package com.abc.Client.service.Impl;

import com.abc.Client.bean.WxbGood;
import com.abc.Client.bean.WxbOrder;
import com.abc.Client.dao.IndexDao;
import com.abc.Client.service.IndexDaoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

@Service
public class IndexDaoServiceImpl implements IndexDaoService {
    @Resource
    private IndexDao indexDao;

    /**
     * 查询所有的套餐集合
     */
    @Override
    public List<WxbGood> findAllSku() {
        List<WxbGood> allSku = indexDao.findAllSku();
        return allSku;
    }

    /**
     * 通过skuId查询套餐
     */
    @Override
    public WxbGood findSkuById(String skuId) {
        WxbGood sku = indexDao.findSkuById(skuId);
        return sku;
    }

    /**
     * 录单
     */
    @Override
    public void insertOrder(WxbOrder order) {
        order.setOrderTime(new Timestamp(System.currentTimeMillis()));
        order.setOrderId("or"+String.valueOf(new Random().nextInt(100000))+"der");
        indexDao.insertOrder(order);
    }
}
