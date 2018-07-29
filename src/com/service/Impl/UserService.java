package com.service.Impl;

import java.util.List;

import com.entity.ExamUser;

public class UserService extends BaseServiceImpl<ExamUser> {
	public List<ExamUser> checkUser(String username ,String password) {
		String hql = "From ExamUser where userId='"+username+"' and userPassword='"+password+"'";
		return findByHQL(hql);
	}
	public List<ExamUser> getTeacher() {
		String hql = "From ExamUser where userIsAdmin = '0' order by userId";
		return findByHQL(hql);
	}
	
	public int getTeacherCount(int year) {
		String hql = "select count(*) From ExamUser where userId like '"+year+"02%'";
		return getBaseDao().getCount(hql);
	}
	public void deleteTeacher(String teacherId) {
		String hql = "delete From ExamUser where userId = '"+teacherId+"'";
		getBaseDao().DeleteBySQL(hql);
	}
	
	public String getMaxId(int year) {
		
		String hql = "select max(userId) from ExamUser where userId like '"+year+"02%'";	
		return getBaseDao().getMax(hql); 
	}
}
