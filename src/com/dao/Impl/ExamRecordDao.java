package com.dao.Impl;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.ExamRecord;
import com.utils.HibernateUtils;

public class ExamRecordDao extends BaseDaoImpl<ExamRecord> {
	@SuppressWarnings("unused")
	private Class<?> EntityClass;
	public ExamRecordDao() {

        ParameterizedType type = (ParameterizedType) getClass()
                .getGenericSuperclass();
        EntityClass = (Class<?>) type.getActualTypeArguments()[0];
    }
	
	@SuppressWarnings("unchecked")
	public List<String> findExamAnalysis(String hqlString) {
		Session session = null;
		Transaction tx = null;
		List<Object[]> list = null;
		List<String> strList = new ArrayList<String>();
		try{
			session =HibernateUtils.getSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hqlString);
			list = query.list();
			for(Object[] object:list){
				strList.add(object[0].toString());
				strList.add(object[1].toString());
				strList.add(object[2].toString());
				strList.add(object[3].toString());
			}
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx != null){
				tx.rollback();
			}
			
		}finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
		return strList;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> findExamBySub(String hqlString) {
		Session session = null;
		Transaction tx = null;
		List<Object[]> list = null;
		List<String> strList = new ArrayList<String>();
		try{
			session =HibernateUtils.getSession();
			tx = session.beginTransaction();
			Query query = session.createSQLQuery(hqlString);
			list = query.list();
			for(Object[] object:list){
				for(Object obj:object) {
					strList.add(obj.toString());
				}	
			}
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx != null){
				tx.rollback();
			}
			
		}finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
		return strList;
	}
	
}
