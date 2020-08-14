package com.abc.Client.service;

import com.abc.Client.bean.TreeNodeBean;

public interface TreeNodeDaoService {

    TreeNodeBean findTreeNodeByUsername(String username);

}
