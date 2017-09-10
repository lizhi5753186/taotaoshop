package com.lz.taotao.search.dao;

import org.apache.solr.client.solrj.SolrQuery;

import com.lz.taotao.search.pojo.SearchResult;

public interface SearchDao {

	SearchResult search(SolrQuery query) throws Exception;
}
