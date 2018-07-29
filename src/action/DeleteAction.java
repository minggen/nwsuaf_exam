package action;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.ExamInformation;
import com.entity.ExamUser;
import com.opensymphony.xwork2.ActionSupport;
import com.service.Impl.ExamInfoService;
import com.service.Impl.MultiChoiceService;
import com.service.Impl.SingleChoiceService;
import com.service.Impl.TofChoiceService;
import com.service.Impl.UserService;

public class DeleteAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String teacher() {
		
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf8");
			
			String teacherId = request.getParameter("id");
			int ti = Integer.parseInt(request.getParameter("ti"));		
			
			UserService userService = new UserService();
			ExamUser user = userService.findById(ExamUser.class, teacherId);
			userService.delete(user);
			
			new ExamInfoService().deleteExam(teacherId);
			new SingleChoiceService().deleteByTeacher(teacherId);
			new MultiChoiceService().deleteByTeacher(teacherId);
			new TofChoiceService().deleteByTeacher(teacherId);
			
			@SuppressWarnings("unchecked")
			List<ExamUser> userList = (List<ExamUser>) request.getSession().getAttribute("userList");
			userList.remove(ti-1);
			request.getSession().setAttribute("userList", userList);
			
			return "success";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}
	public String question() {
		
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf8");
			
			String question = request.getParameter("id");
			
			if(Pattern.matches("001.*", question)) {
				SingleChoiceService singleChoiceService = new SingleChoiceService();
				singleChoiceService.deleteSingle(question);
				return "question";
			} else if(Pattern.matches("002.*", question)) {
				MultiChoiceService singleChoiceService = new MultiChoiceService();
				singleChoiceService.deleteMulti(question);
				return "question";
			} else if(Pattern.matches("003.*", question)) {
				TofChoiceService singleChoiceService = new TofChoiceService();
				singleChoiceService.deleteTof(question);
				return "question";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}
	public String exam() {

		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf8");
			String examId = request.getParameter("id");
			
			ExamInformation examInformation = new ExamInfoService().findById(ExamInformation.class, examId);
			@SuppressWarnings("unused")
			String[] choice = examInformation.getExamQustions().split(";");
			
			return "exam";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return "error";
	}
}
