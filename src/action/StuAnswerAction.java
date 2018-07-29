package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.ExamInformation;
import com.entity.ExamRecord;
import com.opensymphony.xwork2.ActionSupport;
import com.service.Impl.StudentService;
import com.utils.ToStringUtils;

public class StuAnswerAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String showAnswer() {
		try {
			HttpServletRequest request=ServletActionContext.getRequest();
			
			StudentService studentService = new StudentService();		
			//存储单选多选判断个数分值
			String[] choiceList = ((ExamInformation)request.getSession().getAttribute("examInformation")).getExamChoice().split(";");
			String[] singleChoice = choiceList[0].split(",");
			String[] multiChoice = choiceList[1].split(",");
			String[] tofChoice = choiceList[2].split(",");		
			//存储提交答案
			String[] singleStr = new String[Integer.parseInt(singleChoice[0])];
			String[] multiStr = new String[Integer.parseInt(multiChoice[0])];
			String[] tofStr = new String[Integer.parseInt(tofChoice[0])];		
			//记录提交答案
			String submitAnswer = "";
			
			double score = 0;
			int singleNum = 0;
			int multiNum = 0;
			int tofNum = 0;
			
			for(int i = 1 ;i<= Integer.parseInt(singleChoice[0]) ;i++) {
				singleStr[i-1] = request.getParameter("xzt_"+i);
				submitAnswer+=singleStr[i-1]+",";
			}
			submitAnswer+=";";
			for(int i = 1 ;i<= Integer.parseInt(multiChoice[0]) ;i++) {
				if(request.getParameterValues("dxt_"+i) == null) {
					multiStr[i-1] = null;
				} else{
					multiStr[i-1] = ToStringUtils.getString(request.getParameterValues("dxt_"+i));
				}
				submitAnswer+=multiStr[i-1]+",";
			}
			submitAnswer+=";";
			for(int i = 1 ;i<= Integer.parseInt(tofChoice[0]) ;i++) {
				tofStr[i-1] = request.getParameter("pdt_"+i);
				submitAnswer+=tofStr[i-1]+",";
			}

			//获得正确答案
			ExamInformation examInf = (ExamInformation)request.getSession().getAttribute("examInformation");
			String[] answer = examInf.getExamAnswer().split(";");
			String compare = "";
			
			//比较单选题答案
			String[] answerSingle = answer[0].split(",");
			for(int i = 0 ; i< answerSingle.length ;i++ ) {
				if(answerSingle[i].equals(singleStr[i])){
					score+=Double.parseDouble(singleChoice[1]);
					singleNum++;
					compare+=1+",";
				}else{
					compare+=0+",";
				}
			}
			compare+=";";
			
			String[] answerMulti= answer[1].split(",");
			System.out.println(answerMulti.length+" "+multiStr.length);
			for(int i = 0 ; i< answerMulti.length ;i++ ) {
				if(answerMulti[i].equals(multiStr[i])){
					score+=Double.parseDouble(multiChoice[1]);
					multiNum++;
					compare+=1+",";
				}else{
					compare+=0+",";
				}
			}
			compare+=";";
			String[] answerTof= answer[2].split(",");
			for(int i = 0 ; i< answerTof.length ;i++ ) {
				if(answerTof[i].equals(tofStr[i])){
					score+=Double.parseDouble(tofChoice[1]);
					tofNum++;
					compare+=1+",";
				}else{
					compare+=0+",";
				}
			}
			compare+=";";
			System.out.println(compare);
			//存储学生答案
			ExamRecord record = (ExamRecord)request.getSession().getAttribute("student");
			record.setAnswerSubmit(submitAnswer);
			record.setScoreSubmit(score);
			record.setStudentCompare(compare);
			studentService.update(record);			
			
			request.setAttribute("score", score);
			request.setAttribute("singleNum", singleNum);
			request.setAttribute("multiNum", multiNum);
			request.setAttribute("tofNum", tofNum);
			request.setAttribute("singleAll", singleChoice[0]);
			request.setAttribute("multiAll", multiChoice[0]);
			request.setAttribute("tofAll", tofChoice[0]);
			
			return "ok";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "error";

	}
}
