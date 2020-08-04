package com.abc.weifx.dao;

import com.abc.weifx.bean.TreeNodeBean;


public interface TreeNodeDao {

    TreeNodeBean findTreeNodeByUsername(String username);

}
