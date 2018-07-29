package action;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.ExamUser;
import com.opensymphony.xwork2.ActionSupport;
import com.service.Impl.UserService;
import com.utils.something;
import com.utils.syslog;

@SuppressWarnings("serial")
public class AdminAddTeacherAction extends ActionSupport {
	public String execute() {
		
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf8");
			
			Calendar now = Calendar.getInstance();
			String nowId = new UserService().getMaxId(now.get(Calendar.YEAR));
			if(nowId == null) {
				nowId = "00000";
			}
			int number = Integer.parseInt(nowId.substring(nowId.length()-4));
			number++;
			
			String userId = now.get(Calendar.YEAR)+"02"+String.format("%04d", number);
			String userPassword = request.getParameter("user_password");
			String userName = request.getParameter("user_name");
			String userSex = request.getParameter("user_sex");
			String userTel = request.getParameter("user_telephone");
			String userEmail = request.getParameter("user_email");
			
			UserService userService = new UserService();
			ExamUser user = new ExamUser(userId,userPassword,userName,userSex,userTel,userEmail,"0");
			userService.save(user);
			if(request.getSession().getAttribute("userList") != null) {
				@SuppressWarnings("unchecked")
				List<ExamUser> userList = (List<ExamUser>) request.getSession().getAttribute("userList");
				userList.add(user);
			}
			
			syslog.log.add(new something("新增一个老师",new Date()));
			
			return "success";
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}
}
