package com.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T> {
	//添加
	public void save(T o);
	//修改
	public void update(T o);
	
	//合并
	public void merge(T o);
	
	//删除
	public void delete(T o);
	
	//根据实体ID查询
	public T findById(Class<T> c, Serializable id) ;
	
	//查询全部
	public List<T> findAll(Class<T> c) ;
	
	//根据HQL语句查询
	public List<T> findByHQL(String hqlString) ;
	
	//根据SQL语句查询
	public List<T> findBySQL(String sqlString) ;
	
	
	public int getCount(String hqlString);
	
	public String getMax(String hqlString);
	
	//执行sql语句
	public void execute(String sql) ;
	void DeleteBySQL(String hqlString);
	
}
