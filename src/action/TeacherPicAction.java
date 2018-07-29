package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.service.Impl.StudentService;

public class TeacherPicAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String examId = request.getParameter("examid");
		
		StudentService studentService = new StudentService();
		
		int passNum = studentService.findPassCount(examId);
		int num = studentService.findExamCount(examId);
		int numArray[] = studentService.findCountByScore(examId);

		request.setAttribute("passNum", passNum);
		request.setAttribute("num", num);
		request.setAttribute("numArray", numArray);
		
		return "picresult";
	}
}
