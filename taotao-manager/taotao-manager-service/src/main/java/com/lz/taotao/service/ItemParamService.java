package com.lz.taotao.service;

import com.lz.taotao.common.pojo.TaotaoResult;
import com.lz.taotao.entity.TbItemParam;

public interface ItemParamService {

	TaotaoResult getItemParamByCid(long cid);
	TaotaoResult insertItemParam(TbItemParam itemParam);
}
