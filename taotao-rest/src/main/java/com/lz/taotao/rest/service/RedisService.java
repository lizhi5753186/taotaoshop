package com.lz.taotao.rest.service;

import com.lz.taotao.common.pojo.TaotaoResult;

public interface RedisService {

	TaotaoResult syncContent(long contentCid);
}
