package com.service.Impl;

import com.entity.ExamSubject;

public class SubjectService extends BaseServiceImpl<ExamSubject> {
	public int findCount() {
		String hql = "select count(*) from ExamSubject as inf ";
		return getBaseDao().getCount(hql);
	}
}
