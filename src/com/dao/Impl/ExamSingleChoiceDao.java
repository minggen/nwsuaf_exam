package com.dao.Impl;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.ExamSingleChoice;
import com.utils.HibernateUtils;

public class ExamSingleChoiceDao extends BaseDaoImpl<ExamSingleChoice> {
	@SuppressWarnings("unused")
	private Class<?> EntityClass;
	public ExamSingleChoiceDao() {

        ParameterizedType type = (ParameterizedType) getClass()
                .getGenericSuperclass();
        EntityClass = (Class<?>) type.getActualTypeArguments()[0];
    }
	
	@SuppressWarnings("unchecked")
	public List<String> findSinBySQL(String sqlString,int num) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<Object[]> list = null;
		List<String> strList = new ArrayList<String>();
		try{
			session =HibernateUtils.getSession();
			tx = session.beginTransaction();
			Query query = session.createSQLQuery(sqlString);
			query.setMaxResults(num);
			query.setFirstResult(0);
			list = query.list();
			for(Object[] object:list){
				String str = "";
				str+=object[0].toString()+";";
				str+=object[1].toString()+";";
				strList.add(str);
			}
			tx.commit();
		}catch(Exception e){
			
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
