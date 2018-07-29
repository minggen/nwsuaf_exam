package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.ExamInformation;
import com.opensymphony.xwork2.ActionSupport;
import com.service.Impl.ExamInfoService;

public class TeacherExamListAction  extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		String teacherId = (String) request.getSession().getAttribute("teacherId");

		List<ExamInformation> examInfList = new ExamInfoService().getExamOrderByTeacher(teacherId);
		request.setAttribute("examList", examInfList);

		return "result";
	}
}
