package com.abc.Client.service.Impl;

import com.abc.Client.bean.TreeNodeBean;
import com.abc.Client.dao.TreeNodeDao;
import com.abc.Client.service.TreeNodeDaoService;
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
