package action;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.ExamUser;
import com.opensymphony.xwork2.ActionSupport;
import com.service.Impl.UserService;
import com.utils.something;
import com.utils.syslog;

public class AdminChangeInfoAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String setInfo() {	
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf8");
			String id = (String) request.getSession().getAttribute("adminId");
			
			String name = request.getParameter("user_name");
			String password = request.getParameter("user_password");
			String sex = request.getParameter("user_sex");
			String telephone = request.getParameter("user_telephone");
			String email = request.getParameter("user_email");
			
			UserService userService = new UserService();
			ExamUser examUser = userService.findById(ExamUser.class, id);
			if(!password.equals("")) {
				examUser.setUserPassword(password);
			}
			if(!name.equals("")) {
				examUser.setUserName(name);
			}
			if(!sex.equals("")) {
				examUser.setUserSex(sex);
			}
			if(!telephone.equals("")) {
				examUser.setUserTelephone(telephone);
			}
			if(!email.equals("")) {
				examUser.setUserEmail(email);
			}
			userService.update(examUser);
			
			request.getSession().setAttribute("admin", examUser);
			syslog.log.add(new something("管理员修改个人信息",new Date()));
			
			return "success";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}
	public String getInfo() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf8");
			
			String adminId = (String) request.getSession().getAttribute("adminId");
			System.out.println(adminId);
			if(request.getSession().getAttribute("admin") == null) {
				ExamUser user = new UserService().findById(ExamUser.class, adminId);
				request.getSession().setAttribute("admin", user);
			}

			return "getsuccess";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}
}
