package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.ExamSubject;
import com.opensymphony.xwork2.ActionSupport;
import com.service.Impl.SubjectService;

public class AdminNewSubject extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String newSubject() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf8");
			
			String subjectName = request.getParameter("subjectName");
			System.out.println(subjectName);
			SubjectService subService = new SubjectService();
			int num = subService.findCount();
			num++;
			System.out.println(num);
			ExamSubject subject = new ExamSubject();
			subject.setSubjectId(String.format("%03d", num));
			subject.setSubjectName(subjectName);
			
			subService.save(subject);
			@SuppressWarnings("unchecked")
			List<String> subjectList = (List<String>) request.getSession().getServletContext().getAttribute("examSubject"); 
			System.out.println(subjectList.size());
			subjectList.add(subjectName);
			request.getSession().getServletContext().setAttribute("examSubject",subjectList); 
			
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			return "error";
		}

}
	}
