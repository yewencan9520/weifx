package com.abc.Client.service.Impl;

import com.abc.Client.bean.WxbGood;
import com.abc.Client.dao.IndexDao;
import com.abc.Client.service.IndexDaoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IndexDaoServiceImpl implements IndexDaoService {
    @Resource
    private IndexDao indexDao;
    @Override
    public List<WxbGood> findAllSku() {
        List<WxbGood> allSku = indexDao.findAllSku();
        return allSku;
    }

    @Override
    public WxbGood findSkuById(String skuId) {
        WxbGood sku = indexDao.findSkuById(skuId);
        return sku;
    }
}
