package com.lz.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.taotao.common.pojo.EUDataGridResult;
import com.lz.taotao.common.pojo.EUTreeNode;
import com.lz.taotao.common.pojo.TaotaoResult;
import com.lz.taotao.common.utils.HttpClientUtil;
import com.lz.taotao.entity.*;
import com.lz.taotao.mapper.TbContentMapper;
import com.lz.taotao.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 内容管理
 * <p>Title: ContentServiceImpl</p>
 * <p>Description: </p>

 * @author	lizhi
 * @date	2015年9月8日上午11:09:53
 * @version 1.0
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${REST_CONTENT_SYNC_URL}")
	private String REST_CONTENT_SYNC_URL;
	
	
	@Override
	public TaotaoResult insertContent(TbContent content) {
		//补全pojo内容
		content.setCreated(new Date());
		content.setUpdated(new Date());
		contentMapper.insert(content);
		
		//添加缓存同步逻辑
		try {
			HttpClientUtil.doGet(REST_BASE_URL + REST_CONTENT_SYNC_URL + content.getCategoryId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return TaotaoResult.ok();
	}

	@Override
	public EUDataGridResult GetContentList(int page, int rows, long categorId) {
		//创建查询条件
		TbContentExample example = new TbContentExample();
		//分页处理
		PageHelper.startPage(page, rows);

		TbContentExample.Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categorId);
		//根据条件查询
		List<TbContent> list = contentMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbContent> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
}
