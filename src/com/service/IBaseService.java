package com.service;

import java.io.Serializable;
import java.util.List;



public interface IBaseService<T> {
	//���
	public void save(T o) ;
	
	//�޸�
	public void update(T o)  ;
	
	//�ϲ�
	public void merge(T o) ;
	
	//ɾ��
	public void delete(T o) ;
	
	//����ʵ��ID��ѯ
	public T findById(Class<T> c, Serializable id);
	
	//��ѯȫ��
	public List<T> findAll(Class<T> c) ;
	
	//����HQL����ѯ
	public List<T> findByHQL(String hqlString) ;
	
	//����SQL����ѯ
	public List<T> findBySQL(String sqlString) ;
	
	//ִ��SQL
	public void execute (String sql) ;

}
