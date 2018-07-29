package action;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.ExamInformation;
import com.entity.ExamSubject;
import com.opensymphony.xwork2.ActionSupport;
import com.service.Impl.ExamInfoService;
import com.service.Impl.MultiChoiceService;
import com.service.Impl.SingleChoiceService;
import com.service.Impl.SubjectService;
import com.service.Impl.TofChoiceService;

public class TeacherNewExamAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String execute() {
		
		HttpServletRequest request=ServletActionContext.getRequest();
		try {
			System.out.println("hello");
			ExamInfoService examInfoService = new ExamInfoService();
			SubjectService subjectService = new SubjectService();
			ExamInformation examInformation;
			List<ExamSubject> subjectList;
			
			request.setCharacterEncoding("utf8");
			String teacherId = (String) request.getSession().getAttribute("teacherId");
			String examSubject = request.getParameter("examsubject");
			
			subjectList = subjectService.findEntityByName(ExamSubject.class, "subjectName", examSubject);
			String subjectId = subjectList.get(0).getSubjectId();
			int number = examInfoService.getCountByTeacher(teacherId);
			number++;
			
			Calendar now = Calendar.getInstance();
			
			String examId = now.get(Calendar.YEAR)+teacherId+subjectId+String.format("%03d", number);
			
			String examName = request.getParameter("examname");
			String beginTime = request.getParameter("begintime");
			String beginToEndTime = request.getParameter("begintoendtime");
			String xztCount = request.getParameter("xzt_count");
			String xztScore = request.getParameter("xzt_score");
			String dxtCount = request.getParameter("dxt_count");
			String dxtScore = request.getParameter("dxt_score");
			String tofCount = request.getParameter("tof_count");	
			String tofScore = request.getParameter("tof_score");
			String examChoice = xztCount+","+xztScore+";"+dxtCount+","+dxtScore+";"+tofCount+","+tofScore;
			String examQuestions = "";
			String examAnswer="";
			
			List<String> singleList = new SingleChoiceService().getQuestions(Integer.parseInt(xztCount),teacherId,examSubject);
			List<String> multiList = new MultiChoiceService().getQuestions(Integer.parseInt(dxtCount),teacherId,examSubject);
			List<String> tofList = new TofChoiceService().getQuestions(Integer.parseInt(tofCount),teacherId,examSubject);
			System.out.println(multiList.size());
			for(String singleStr:singleList) {
				examQuestions+=singleStr.split(";")[0]+",";
				examAnswer+=singleStr.split(";")[1]+",";
			}
			examQuestions+=";";
			examAnswer+=";";
			for(String multiStr:multiList) {
				examQuestions+=multiStr.split(";")[0]+",";
				examAnswer+=multiStr.split(";")[1]+",";
			}
			examQuestions+=";";
			examAnswer+=";";
			for(String tofStr:tofList) {
				examQuestions+=tofStr.split(";")[0]+",";
				examAnswer+=tofStr.split(";")[1]+",";
			}
			
			examInformation = new ExamInformation();
			examInformation.setExamId(examId);
			examInformation.setExamName(examName);
			examInformation.setTeacherId(teacherId);
			examInformation.setSubjectName(examSubject);
			examInformation.setExamBeginTime(beginTime);
			examInformation.setExamTime(beginToEndTime);	
			examInformation.setExamChoice(examChoice);
			examInformation.setExamAnswer(examAnswer);
			examInformation.setExamQustions(examQuestions);
			
			examInfoService.save(examInformation);
			
			@SuppressWarnings("unchecked")
			Map<String,String> map = (Map<String, String>) request.getSession().getAttribute("exam");
			map.put(examInformation.getExamId(), examInformation.getExamName());
			request.getSession().setAttribute("exam", map);
			
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "error";
	}
}
