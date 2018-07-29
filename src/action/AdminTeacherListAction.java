package action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.ExamUser;
import com.opensymphony.xwork2.ActionSupport;
import com.service.Impl.UserService;

public class AdminTeacherListAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() {
		
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf8");
			if(request.getSession().getAttribute("userList") == null) {
				UserService userService = new UserService();
				List<ExamUser> userList = userService.getTeacher();
				
				request.getSession().setAttribute("userList", userList);
				
			}
			return "success";
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}
}
