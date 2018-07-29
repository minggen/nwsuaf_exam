package com.service.Impl;

import com.entity.ExamInformation;
import java.util.List;

public class ExamInfoService extends BaseServiceImpl<ExamInformation> {
	public int getCountByTeacher(String teacherId) {
		String hql = "select count(*) from ExamInformation as inf where teacherId='"+teacherId+"'";	
		return getBaseDao().getCount(hql);
	}
	public int getCountBySubject(String subjectName) {
		String hql = "select count(*) from ExamInformation as inf where subjectName='"+subjectName+"'";	
		return getBaseDao().getCount(hql);
	}
	public List<ExamInformation> getExam(String date) {
		String hql = "from ExamInformation as inf where examBeginTime like '%"+date+"%'";
		return getBaseDao().findByHQL(hql);
	}
	public List<ExamInformation> getExamOrderByTeacher(String teacherId) {
		String hql = "from ExamInformation as inf where teacherId='"+teacherId+"'"+" order by examBeginTime desc";
		return getBaseDao().findByHQL(hql);
	}
	public void deleteExam(String teacherId) {
		String hql = "delete from exam_information where teacher_id = '"+teacherId+"'";
		getBaseDao().DeleteBySQL(hql);
	}
}
