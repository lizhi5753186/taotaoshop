package com.lz.taotao.search.service;

import com.lz.taotao.search.pojo.SearchResult;

public interface SearchService {

	SearchResult search(String queryString, int page, int rows) throws Exception;
}
