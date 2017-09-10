package com.lz.taotao.rest.service;

import com.lz.taotao.entity.TbContent;

import java.util.List;

public interface ContentService {

	List<TbContent> getContentList(long contentCid);
}
