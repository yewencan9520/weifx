package com.abc.weifx.service.Impl;

import com.abc.weifx.bean.TreeNodeBean;
import com.abc.weifx.dao.TreeNodeDao;
import com.abc.weifx.service.TreeNodeDaoService;
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
