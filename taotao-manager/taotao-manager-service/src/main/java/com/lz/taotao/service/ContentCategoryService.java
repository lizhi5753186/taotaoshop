package com.lz.taotao.service;

import com.lz.taotao.common.pojo.EUTreeNode;
import com.lz.taotao.common.pojo.TaotaoResult;

import java.util.List;

public interface ContentCategoryService {

	List<EUTreeNode> getCategoryList(long parentId);
	TaotaoResult insertContentCategory(long parentId, String name);
}
