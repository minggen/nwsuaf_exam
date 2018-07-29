package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.ExamRecord;
import com.opensymphony.xwork2.ActionSupport;
import com.service.Impl.StudentService;

public class TeachertShowStuAction extends ActionSupport{
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
		List<ExamRecord> stuList = studentService.findByExamId(examId);
		
		request.setAttribute("stuList", stuList);
		request.setAttribute("examId", examId);
		
		return "result";
	}
}