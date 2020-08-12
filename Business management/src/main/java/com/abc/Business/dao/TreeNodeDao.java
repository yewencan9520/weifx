package com.abc.Business.dao;

import com.abc.Business.bean.TreeNodeBean;


public interface TreeNodeDao {

    TreeNodeBean findTreeNodeByUsername(String username);

}
