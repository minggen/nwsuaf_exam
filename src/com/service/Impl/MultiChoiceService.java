package com.service.Impl;

import java.util.List;

import com.dao.Impl.ExamMultiChoiceDao;
import com.entity.ExamMultiChoice;

public class MultiChoiceService extends BaseServiceImpl<ExamMultiChoice> {
	public int getCount(String teacherId) {
		String hql = "select count(*) from ExamMultiChoice as mc where teacherId='"+teacherId+"'";	
		return getBaseDao().getCount(hql);
	}
	public String getMaxId(String teacherId) {
		String hql = "select max(mcId) from ExamMultiChoice as sc where teacherId='"+teacherId+"'";	
		return getBaseDao().getMax(hql); 
	}
	
	public List<String> getQuestions(int num,String teacherId,String subjectName) {
		//String hql = "select mc_id,mc_answer_correct from exam_multiChoice WHERE teacher_id = '"+teacherId+"' and subject_name='"+subjectName+"' and "+"mc_id >= ((SELECT MAX(mc_id) FROM exam_multiChoice WHERE teacher_id = '"+teacherId+"' and subject_name='"+subjectName+"')-(SELECT MIN(mc_id) FROM exam_multiChoice WHERE teacher_id = '"+teacherId+"' and subject_name='"+subjectName+"')) * RAND() + (SELECT MIN(mc_id) FROM exam_multiChoice WHERE teacher_id = '"+teacherId+"' and subject_name='"+subjectName+"') limit "+num;
		String hql1 = "select mc_id,mc_answer_correct from exam_multiChoice where teacher_id ='"+teacherId+"' and subject_name='"+subjectName+"'";
		return new ExamMultiChoiceDao().findSinBySQL(hql1,num);
	}
	
	public void deleteMulti(String multiId) {
		String hql = "delete from exam_multiChoice where mc_id = '"+multiId+"'";
		getBaseDao().DeleteBySQL(hql);
	}
	
	public void deleteByTeacher(String teacherId) {
		String hql = "delete from exam_multiChoice where teacher_id = '"+teacherId+"'";
		getBaseDao().DeleteBySQL(hql);
	}
}
