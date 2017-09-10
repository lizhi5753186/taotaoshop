package com.lz.taotao.service;

import com.lz.taotao.common.pojo.EUDataGridResult;
import com.lz.taotao.common.pojo.EUTreeNode;
import com.lz.taotao.common.pojo.TaotaoResult;
import com.lz.taotao.entity.TbContent;

import java.util.List;

public interface ContentService {

	TaotaoResult insertContent(TbContent content);
	EUDataGridResult GetContentList(int page, int rows, long categorId);
}
