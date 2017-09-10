package com.lz.taotao.service;

import com.lz.taotao.common.pojo.EUTreeNode;

import java.util.List;

public interface ItemCatService {

	List<EUTreeNode> getCatList(long parentId);
}
