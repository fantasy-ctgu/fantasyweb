package com.ctgu.qmx.IBaseDao;

import java.util.List;

public interface IBaseDao<K,V> {
	public boolean doInsert(V v);
	public boolean doDelete(K k);
	public boolean doUpdate(V v);
	public V findById(K k);
	public List<V> findAll();
	public List<V> findAllPaging(String column,String keyWord,int currentPage,int pageSize);
	public int getAllContent();
}
