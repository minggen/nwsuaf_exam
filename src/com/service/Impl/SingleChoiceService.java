package com.service.Impl;

import java.util.List;

import com.dao.Impl.ExamSingleChoiceDao;
import com.entity.ExamSingleChoice;

public class SingleChoiceService extends BaseServiceImpl<ExamSingleChoice> {
	public int getCount(String teacherId) {
		String hql = "select count(*) from ExamSingleChoice as sc where teacherId='"+teacherId+"'";	
		return getBaseDao().getCount(hql);
	}
	public String getMaxId(String teacherId) {
		String hql = "select max(scId) from ExamSingleChoice as sc where teacherId='"+teacherId+"'";	
		return getBaseDao().getMax(hql); 
	}
	public List<String> getQuestions(int num,String teacherId,String subjectName) {
		//String hql = "select sc_id,sc_answer_correct from exam_singleChoice WHERE teacher_id = '"+teacherId+"' and subject_name='"+subjectName+"' and "+"sc_id >= ((SELECT MAX(sc_id) FROM exam_singleChoice WHERE teacher_id = '"+teacherId+"' and subject_name='"+subjectName+"')-(SELECT MIN(sc_id) FROM exam_singleChoice WHERE teacher_id = '"+teacherId+"' and subject_name='"+subjectName+"')) * RAND() + (SELECT MIN(sc_id) FROM exam_singleChoice WHERE teacher_id = '"+teacherId+"' and subject_name='"+subjectName+"') limit "+num;
		String hql1 = "select sc_id,sc_answer_correct from exam_singleChoice where teacher_id ='"+teacherId+"' and subject_name='"+subjectName+"'";
		System.out.println(num); 
		List<String> strList =  new ExamSingleChoiceDao().findSinBySQL(hql1,num);
		System.out.println(strList.size());
		 return strList;
	}
	
	public void deleteSingle(String singleId) {
		String hql = "delete from exam_singleChoice where sc_id = '"+singleId+"'";
		getBaseDao().DeleteBySQL(hql);
	}
	
	public void deleteByTeacher(String teacherId) {
		String hql = "delete from exam_singleChoice where teacher_id = '"+teacherId+"'";
		getBaseDao().DeleteBySQL(hql);
	}
}
