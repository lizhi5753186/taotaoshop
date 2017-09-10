package com.lz.taotao.order.service;

import java.util.List;

import com.lz.taotao.common.pojo.TaotaoResult;
import com.lz.taotao.entity.TbOrder;
import com.lz.taotao.entity.TbOrderItem;
import com.lz.taotao.entity.TbOrderShipping;

public interface OrderService {

	TaotaoResult createOrder(TbOrder order, List<TbOrderItem> itemList, TbOrderShipping orderShipping);
}
