package com.lz.taotao.service;

import com.lz.taotao.common.pojo.EUDataGridResult;
import com.lz.taotao.common.pojo.TaotaoResult;
import com.lz.taotao.entity.TbItem;

public interface ItemService {

	TbItem getItemById(long itemId);
	EUDataGridResult getItemList(int page, int rows);
	TaotaoResult createItem(TbItem item, String desc, String itemParam) throws Exception;
}
