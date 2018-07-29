package com.service.Impl;

import java.util.List;

import com.dao.Impl.ExamTofChoiceDao;
import com.entity.ExamTofChoice;

public class TofChoiceService extends BaseServiceImpl<ExamTofChoice> {
	public int getCount(String teacherId) {
		String hql = "select count(*) from ExamTofChoice as tc where teacherId='"+teacherId+"'";	
		return getBaseDao().getCount(hql);
	}
	public String getMaxId(String teacherId) {
		String hql = "select max(tcId) from ExamTofChoice as sc where teacherId='"+teacherId+"'";	
		return getBaseDao().getMax(hql); 
	}
	
	public List<String> getQuestions(int num,String teacherId,String subjectName) {
		String hql = "select tc_id,tc_answer_correct from exam_tofChoice where teacher_id ='"+teacherId+"' and subject_name='"+subjectName+"'";
		return new ExamTofChoiceDao().findSinBySQL(hql,num);
	}
	public void deleteTof(String tofId) {
		String sql = "delete from exam_tofChoice where tc_id = '"+tofId+"'";
		getBaseDao().DeleteBySQL(sql);
	}
	
	public void deleteByTeacher(String teacherId) {
		String hql = "delete from exam_tofChoice where teacher_id = '"+teacherId+"'";
		getBaseDao().DeleteBySQL(hql);
	}
}
