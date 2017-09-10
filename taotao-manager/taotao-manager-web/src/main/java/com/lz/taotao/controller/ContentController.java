package com.lz.taotao.controller;

import com.lz.taotao.common.pojo.EUDataGridResult;
import com.lz.taotao.common.pojo.TaotaoResult;
import com.lz.taotao.entity.TbContent;
import com.lz.taotao.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 内容管理Controller
 * <p>Title: ContentController</p>
 * <p>Description: </p>
 * @author	李志
 * @date	2017年7月27日上午11:13:52
 * @version 1.0
 */
@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult insertContent(TbContent content) {
		TaotaoResult result = contentService.insertContent(content);
		return result;
	}

	@RequestMapping("/query/list")
	@ResponseBody
	public EUDataGridResult getContentList(Integer page, Integer rows, long categoryId) {
		EUDataGridResult result = contentService.GetContentList(page,rows, categoryId);
		return result;
	}
}
