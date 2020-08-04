package com.abc.platform.dao;

import com.abc.platform.bean.TreeNodeBean;


public interface TreeNodeDao {

    TreeNodeBean findTreeNodeByUsername(String username);

}
