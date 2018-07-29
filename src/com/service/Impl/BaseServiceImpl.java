package com.service.Impl;

import java.io.Serializable;
import java.util.List;

import com.dao.IBaseDao;
import com.dao.Impl.BaseDaoImpl;
import com.service.IBaseService;

public class BaseServiceImpl<T> implements IBaseService<T> {

	private IBaseDao<T> baseDao = new BaseDaoImpl<T>();
	
	public void save(T o) {
		try {
			baseDao.save(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void update(T o) {
		try {
			baseDao.update(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void delete(T o){
		try {
			baseDao.delete(o);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	public void merge(T o){
		try {
			baseDao.merge(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public T findById(Class<T> c, Serializable id) {
		return baseDao.findById(c, id);
	}
	public List<T> findAll(Class<T> c){ 
		return baseDao.findAll(c);
	}
	
	public List<T> findEntityByName(Class<T> c, String columnName,String columnValue){
		String hqlString="from "+c.getName()+" where "+columnName+"='"+columnValue+"'";
		List<T>EntityList=baseDao.findByHQL(hqlString);
		return EntityList;
		
	}
	
	public List<T> findByHQL(String hqlString){
		return baseDao.findByHQL(hqlString);		
	}
	
	public List<T> findBySQL(String sqlString){
		return baseDao.findBySQL(sqlString);		
	}
	
	public IBaseDao<T> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(IBaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	public void execute(String sql){
			baseDao.execute(sql);
	}
	

}
