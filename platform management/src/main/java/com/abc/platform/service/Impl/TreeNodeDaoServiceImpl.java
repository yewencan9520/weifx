package com.abc.platform.service.Impl;

import com.abc.platform.bean.TreeNodeBean;
import com.abc.platform.service.TreeNodeDaoService;
import com.abc.platform.dao.TreeNodeDao;
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
