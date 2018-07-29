package com.service.Impl;

import java.util.List;

import com.dao.Impl.ExamRecordDao;
import com.entity.ExamRecord;

public class StudentService extends BaseServiceImpl<ExamRecord> {
	public List<ExamRecord> findRecord(String userno,String password,String examId) {
		String hql = "from ExamRecord where studentNo='"+userno+"' and studentPassword='"+password+"' and examId='"+examId+"'";
		return getBaseDao().findByHQL(hql);
	}
	public int findPassCount(String examId) {
		String hql = "select count(*) from ExamRecord where examId='"+examId+"' and scoreSubmit>='60'";
		return getBaseDao().getCount(hql);
	}
	public int findExamCount(String examId) {
		String hql = "select count(*) from ExamRecord where examId='"+examId+"'";
		return getBaseDao().getCount(hql);
	}
	
	public List<String> findExamAnalysis(String examId) {
		String hql = "select count(*),avg(scoreSubmit),max(scoreSubmit),min(scoreSubmit) from ExamRecord where examId='"+examId+"' and scoreSubmit <> '-1'";
		return new ExamRecordDao().findExamAnalysis(hql);
	}

	
	public List<ExamRecord> findByExamId(String examId) {
		String hqlString="from ExamRecord where examId ='"+examId+"' order by scoreSubmit desc";
		return getBaseDao().findByHQL(hqlString);
	}
	
	public int[] findCountByScore(String examId) {
		
		String hqlString = "SELECT "+ 
				"sum(CASE when score_submit<0 then 1 else 0 end)," +
				"sum(CASE when score_submit>=0 and score_submit<50 then 1 else 0 end)," +
				"sum(CASE when score_submit>=50 and score_submit<60 then 1 else 0 end),"+
				"sum(CASE when score_submit>=60 and score_submit<70 then 1 else 0 end),"+
				"sum(CASE when score_submit>=70 and score_submit<80 then 1 else 0 end),"+ 
				"sum(CASE when score_submit>=80 and score_submit<90 then 1 else 0 end),"+
				"sum(CASE when score_submit>=90 and score_submit<=100 then 1 else 0 end)"+
			" from exam_record where exam_id='"+examId+"'";

		
		List<String> strList = new ExamRecordDao().findExamBySub(hqlString);
		int num[] = new int[strList.size()];
		for(int i = 0 ;i< strList.size() ;i++) {
			num[i] = Integer.valueOf(strList.get(i));
		}
		
		return num;
	}
}
