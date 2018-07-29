package action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.ExamInformation;
import com.entity.ExamMultiChoice;
import com.entity.ExamRecord;
import com.entity.ExamSingleChoice;
import com.entity.ExamTofChoice;
import com.opensymphony.xwork2.ActionSupport;
import com.service.Impl.ExamInfoService;
import com.service.Impl.MultiChoiceService;
import com.service.Impl.SingleChoiceService;
import com.service.Impl.StudentService;
import com.service.Impl.TofChoiceService;

public class StuLoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String execute() {
		
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf8");
			
			if(request.getSession().getAttribute("student") == null) {
				ServletContext application = request.getSession().getServletContext();
				
				Calendar c = Calendar.getInstance();
				
				String stryear =   c.get(Calendar.YEAR)+"";
				String strmonth =(c.get(Calendar.MONTH)+1) > 9 ? ""+c.get(Calendar.MONTH)+1:"0"+(c.get(Calendar.MONTH)+1);
				String strday =c.get(Calendar.DATE) >9 ? c.get(Calendar.DATE)+"":"0"+c.get(Calendar.DATE);
				String date = stryear+"年"+strmonth+"月"+strday+"日";
				
				System.out.println(date);
				ExamInfoService examService = new ExamInfoService();
				
				if(application.getAttribute("stuDate")!=null) {
					String oldDate = (String) application.getAttribute("stuDate");
					if(!oldDate.equals(date)) {
						List<ExamInformation> infList = examService.getExam(date);
						System.out.println(infList.size());
						application.setAttribute("stuExam", infList);
						application.setAttribute("stuDate", date);
					}
				} else{
					
					List<ExamInformation> infList = examService.getExam(date);
					System.out.println("size:"+infList.size());
					application.setAttribute("stuExam", infList);
					application.setAttribute("stuDate", date);
				}
				
				if(request.getSession().getAttribute("student")==null) {
					request.getSession().setAttribute("exambegintime", new Date());
				}
				return "success";
			} else {
				
				return "jump";
			}

		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		System.out.println("error");
		return "error";
	}
	public String check() {
		
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf-8");
			String userNo = request.getParameter("username");
			String password = request.getParameter("password");
			String examId = request.getParameter("examid");

			StudentService studentService = new StudentService();
			List<ExamRecord> stuRecord = studentService.findRecord(userNo,password,examId);
			System.out.println(stuRecord.size());
			if(stuRecord.size() == 0){
				return "error";
			} else{
				ExamRecord examRecord = stuRecord.get(0);
				System.out.println(examRecord.getScoreSubmit());
				if(examRecord.getScoreSubmit() != -1.0) {
					return "error";
				}
				
				List<String> multiList = new ArrayList<String>();
				List<String> singleList = new ArrayList<String>();
				List<String> tofList = new ArrayList<String>();
				
				ExamInfoService examInfoService = new ExamInfoService();
				MultiChoiceService examMultiChoice = new MultiChoiceService();
				SingleChoiceService examSingleChoice = new SingleChoiceService();
				TofChoiceService examTofChoice = new TofChoiceService();
				
				ExamInformation examInformation = examInfoService.findById(ExamInformation.class, examId);
				
				
				String[] questionType = examInformation.getExamQustions().split(";");
				for(int i = 0 ;i< questionType.length ;i++ ){
					String[] str = questionType[i].split(",");
					if(i == 0) {
						for(int j = 0 ;j< str.length ;j++){
							ExamSingleChoice sc = examSingleChoice.findById(ExamSingleChoice.class, str[j]);
							singleList.add(sc.getScId()+"@#"+sc.getScQuestion()+"@#"+sc.getScAnswerA()+"@#"+sc.getScAnswerB()+"@#"+sc.getScAnswerC()+"@#"+sc.getScAnswerD());
						}					
					}
					if(i == 1) {
						for(int j = 0 ;j< str.length ;j++){
							ExamMultiChoice mc = examMultiChoice.findById(ExamMultiChoice.class, str[j]);
							multiList.add(mc.getMcId()+"@#"+mc.getMcQuestion()+"@#"+mc.getMcAnswerA()+"@#"+mc.getMcAnswerB()+"@#"+mc.getMcAnswerC()+"@#"+mc.getMcAnswerD()+"@#"+mc.getMcAnswerE());
							
						}
					}
					if(i == 2) {
						for(int j = 0 ;j< str.length ;j++){
							ExamTofChoice tc = examTofChoice.findById(ExamTofChoice.class, str[j]);
							tofList.add(tc.getTcId()+"@#"+tc.getTcQuestion());
						}
					}
				}
				
				request.getSession().setAttribute("student", examRecord);
				request.getSession().setAttribute("examInformation", examInformation);
				request.getSession().setAttribute("singleList", singleList);
				request.getSession().setAttribute("mulList", multiList);
				request.getSession().setAttribute("tofList", tofList);
				
				return "success";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "error";
	}
	
	
}
