package com.abc.Business.service.Impl;

import com.abc.Business.bean.TreeNodeBean;
import com.abc.Business.dao.TreeNodeDao;
import com.abc.Business.service.TreeNodeDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreeNodeDaoServiceImpl implements TreeNodeDaoService {

    @Autowired
    private TreeNodeDao treeNodeDao;
    @Override
    public TreeNodeBean findTreeNodeByUsername(String username) {
        TreeNodeBean beans = treeNodeDao.findTreeNodeByUsername(username);
        return beans;
    }
}
