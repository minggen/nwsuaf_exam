package com.dao.Impl;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.BasicType;

import com.dao.IBaseDao;
import com.utils.GenericsUtils;
import com.utils.HibernateUtils;

public class BaseDaoImpl<T> implements IBaseDao<T>{
	@SuppressWarnings("unused")
	private Class<T> clazz ;
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
        clazz = GenericsUtils.getSuperClassGenricType(BasicType.class, 0);
    }
	@Override
	public void save(T o) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSession();
			transaction = session.beginTransaction();
			session.save(o);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if(transaction != null){
				transaction.rollback();
			}
			System.out.println("娣诲姞瀹炰綋澶辫触");
		}
	}
	@Override
	public void update(T o) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(o);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if(transaction != null){
				transaction.rollback();
			}
			System.out.println("娣诲姞鎴栨洿鏂板疄浣撳け璐�");
		}
	}

	@Override
	public void merge(T o) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSession();
			transaction = session.beginTransaction();
			session.merge(o);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if(transaction != null){
				transaction.rollback();
			}
			System.out.println("娣诲姞鎴栨洿鏂板疄浣撳け璐�");
		}
	}

	@Override
	public void delete(T o) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSession();
			transaction = session.beginTransaction();
			session.delete(o);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if(transaction != null){
				transaction.rollback();
			}
			System.out.println("娣诲姞鎴栨洿鏂板疄浣撳け璐�");
		}
	}

	
	@Override
	public T findById(Class<T> c, Serializable id){
		Session session = null;
		Transaction tx = null;
		T t = null;
		try{
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			t = (T)session.get(c, id);
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
		return t;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<T> c) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<T> list = null;
		try{
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("from "+c.getName());
			list = query.list();
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
		return list;
	}
	public int getCount(String hqlString) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		int number = 0;
		try{
			session =HibernateUtils.getSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hqlString);
			number = ((Number) query.uniqueResult()).intValue();
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
		return number;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByHQL(String hqlString) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<T> list = null;
		try{
			session =HibernateUtils.getSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hqlString);
			list = query.list();
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
		return list;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findBySQL(String sqlString) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<T> list = null;
		try{
			session =HibernateUtils.getSession();
			tx = session.beginTransaction();
			Query query = session.createSQLQuery(sqlString);
			list = query.list();
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
		return list;
	}
	
	

	@Override
	public void execute(String sql) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			Query query=session.createSQLQuery(sql);
			query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			
			if(tx!=null){
				tx.rollback();
			}
			
		}finally{
			session.close();
		}
	}
	@Override
	public void DeleteBySQL(String hqlString) {
		
		Session session = null;
		Transaction tx = null;
		try{
			session =HibernateUtils.getSession();
			tx = session.beginTransaction();
			Query query = session.createSQLQuery(hqlString);
			query.executeUpdate();
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
	}
	@Override
	public String getMax(String hqlString) {
		Session session = null;
		Transaction tx = null;
		String maxId = null;
		try{
			session =HibernateUtils.getSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hqlString);
			maxId = ((String) query.uniqueResult()).intern();
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
		return maxId;
	}
}
