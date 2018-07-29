package action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.ExamMultiChoice;
import com.entity.ExamRecord;
import com.entity.ExamSingleChoice;
import com.entity.ExamTofChoice;
import com.opensymphony.xwork2.ActionSupport;
import com.service.Impl.MultiChoiceService;
import com.service.Impl.SingleChoiceService;
import com.service.Impl.StudentsUploadService;
import com.service.Impl.TofChoiceService;
import com.utils.something;
import com.utils.syslog;

public class TeacherAction	extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public String questionslist(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf8");
			HttpSession session = request.getSession();
			String userId = (String) session.getAttribute("teacherId");
			System.out.println(userId);
			//String userId = "2017020011";
			if(userId == null) {
				//请先登录
				List<String> multiList = new ArrayList<>();
				List<String> singleList= new ArrayList<>();
				List<String> tofList= new ArrayList<>();
				multiList.add("多选题");
				singleList.add("单选题");
				tofList.add("判断题");
				request.setAttribute("multichoice", multiList);
				request.setAttribute("singlechoice", singleList);
				request.setAttribute("tofChoice", tofList);
			} else {
				//String username = "2017020011";
				MultiChoiceService multiService = new MultiChoiceService();
				SingleChoiceService singleService = new SingleChoiceService();
				TofChoiceService tofService = new TofChoiceService();
				
				List<ExamMultiChoice> multiList = multiService.findEntityByName(ExamMultiChoice.class, "teacher_id", userId);
				List<ExamSingleChoice> singleList= singleService.findEntityByName(ExamSingleChoice.class, "teacher_id", userId);
				List<ExamTofChoice> tofList= tofService.findEntityByName(ExamTofChoice.class, "teacher_id", userId);
				
				request.setAttribute("multichoice", multiList);
				request.setAttribute("singlechoice", singleList);
				request.setAttribute("tofChoice", tofList);	
			}
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}
	
	public String add_one_radio() {
		try {
			System.out.println("shoudao");
			syslog.log.add(new something("导入单选题",new Date()));
			
			SingleChoiceService singleService = new SingleChoiceService();
			ExamSingleChoice examSingleChoice;
			HttpServletRequest request = ServletActionContext.getRequest(); 
	    	String teacherId = (String) request.getSession().getAttribute("teacherId");

			String questionId;
			String subjectName;
			String isShare;
			String question;
			String answerA;
			String answerB;
			String answerC;
			String answerD;
			String answerCorrect;
			String analysis;

			request.setCharacterEncoding("utf8");
			//String teacherId = session.getAttribute("user").toString();
			String nowId = singleService.getMaxId(teacherId);
			if(nowId == null) {
				nowId = "00000";
			}
			int number = Integer.parseInt(nowId.substring(nowId.length()-4));
			number++;
			questionId = "001"+teacherId+String.format("%04d", number);
			
			subjectName = request.getParameter("subjectName").toString();
			question = request.getParameter("question").toString();
			answerA = request.getParameter("answerA").toString();
			answerB = request.getParameter("answerB").toString();
			answerC = request.getParameter("answerC").toString();
			answerD = request.getParameter("answerD").toString();
			answerCorrect = request.getParameter("answerCorrect").toString();
			analysis = request.getParameter("analysis").toString();
			isShare = request.getParameter("isShare");
			if (isShare==null) {
				isShare="off";
			}
			
			examSingleChoice = new ExamSingleChoice(questionId, teacherId, subjectName, question, answerA, answerB, answerC, answerD, answerCorrect, analysis, isShare);
			singleService.save(examSingleChoice);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "ok";
	}
	
	public String add_one_checkbox() {
		try {
			syslog.log.add(new something("导入多选题",new Date()));
			
			MultiChoiceService multiChoiceService = new MultiChoiceService();
			ExamMultiChoice examChoice;
			String teacherId;
			String questionId;
			String subjectName;
			String isShare;
			String question;
			String answerA;
			String answerB;
			String answerC;
			String answerD;
			String answerE;
			String []answerCorrect;
			String analysis;
			String correct = "";
			
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf8"); 
	    	teacherId = (String) request.getSession().getAttribute("teacherId");
			
	    	String nowId = multiChoiceService.getMaxId(teacherId);
	    	if(nowId == null) {
				nowId = "00000";
			}
			int number = Integer.parseInt(nowId.substring(nowId.length()-4));
			number++;
			questionId = "002"+teacherId+String.format("%04d", number);
			
			subjectName = request.getParameter("subjectName").toString();
			question = request.getParameter("question").toString();
			answerA = request.getParameter("answerA").toString();
			answerB = request.getParameter("answerB").toString();
			answerC = request.getParameter("answerC").toString();
			answerD = request.getParameter("answerD").toString();
			answerE = request.getParameter("answerE").toString();
			answerCorrect = request.getParameterValues("answerCorrect");//+request.getParameter("answerCorrectb")+request.getParameter("answerCorrectc")+request.getParameter("answerCorrectd")+request.getParameter("answerCorrecte");
			analysis = request.getParameter("analysis").toString();
			isShare = request.getParameter("isShare");
			if (isShare==null) {
				isShare="off";
			}
			correct = "";
			for (int i = 0; i < answerCorrect.length; i++) {
				correct += answerCorrect[i];
			}
			
			examChoice = new ExamMultiChoice(questionId, teacherId, subjectName, question, answerA, answerB, answerC, answerD,answerE, correct, analysis, isShare);
			multiChoiceService.save(examChoice);
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "error";
	}
	
	
	public String trueorfalse() {
		try {
			syslog.log.add(new something("导入判断题",new Date()));
			
			TofChoiceService tofChoiceService = new TofChoiceService();
			ExamTofChoice tofChoice;
			
			String teacherId;
			String questionId;
			String subjectName;
			String isShare;
			String question;
			String answerCorrect;
			String analysis;
			
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf8");
			teacherId = (String) request.getSession().getAttribute("teacherId");
			//teacherId = request.getAttribute("teacher").toString();
			
			String nowId = tofChoiceService.getMaxId(teacherId);
			if(nowId == null) {
				nowId = "00000";
			}
			int number = Integer.parseInt(nowId.substring(nowId.length()-4));
			number++;
			questionId = "003"+teacherId+String.format("%04d", number);
			
			subjectName = request.getParameter("subjectName").toString();	
			question = request.getParameter("question").toString();		
			answerCorrect = request.getParameter("answerCorrect");
			analysis = request.getParameter("analysis").toString();
			isShare = request.getParameter("isShare");
			if (isShare==null) {
				isShare="off";
			}
			
			tofChoice = new ExamTofChoice(questionId, teacherId, subjectName, question, answerCorrect, analysis, isShare);
			tofChoiceService.save(tofChoice);
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "error";
	}
	
	
	public String importstudent() {
		System.out.println("导入学生");
		try {
			syslog.log.add(new something("导入学生",new Date()));
			
			StudentsUploadService studentsUploadService = new StudentsUploadService();
			
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf8");
			String examid = request.getParameter("examid");
			String sname = request.getParameter("sname");
			String sno = request.getParameter("sno");
			String spassword = request.getParameter("spassword");

			ExamRecord record = new ExamRecord();
			record.setExamId(examid);
			record.setStudentName(sname);
			record.setStudentNo(sno);
			record.setStudentPassword(spassword);
			record.setScoreSubmit(-1.0);
			
			studentsUploadService.save(record);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "ok";
	}
}
