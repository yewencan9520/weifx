package com.abc.Client.dao;

import com.abc.Client.bean.TreeNodeBean;


public interface TreeNodeDao {

    TreeNodeBean findTreeNodeByUsername(String username);

}
