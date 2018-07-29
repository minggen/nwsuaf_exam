package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.ExamInformation;
import com.entity.ExamSubject;
import com.entity.ExamSystem;
import com.entity.ExamUser;
import com.opensymphony.xwork2.ActionSupport;
import com.service.Impl.ExamInfoService;
import com.service.Impl.SubjectService;
import com.service.Impl.SystemService;
import com.service.Impl.UserService;

public class LoginCheckAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passwd) {
		this.password = passwd;
	}

	public String check() {		
		try {
			System.out.println("a");
			UserService userService = new UserService();
			SubjectService subjectService = new SubjectService();
			ExamInfoService examInfoService = new ExamInfoService();
			List<String> subjectlist = new ArrayList<String>();
			List<ExamInformation> infList = new ArrayList<ExamInformation>();
			Map<String, String> infMap = new HashMap<String, String>();
				
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf8");
			HttpSession session = request.getSession();
			ServletContext application = session.getServletContext();
			if(application.getAttribute("subjects") == null) {
				
				List<ExamSubject> listExamSubject = subjectService.findAll(ExamSubject.class);
				for(ExamSubject subject:listExamSubject){
					subjectlist.add(subject.getSubjectName());
				}
				application.setAttribute("examSubject", subjectlist);
			}
			
			List<ExamUser> userList = userService.checkUser(username, password);
			if(userList.size() == 0) {
				return "fail";
			} else {
				ExamUser user = userList.get(0);
				
				if(application.getAttribute("systemName") == null || application.getAttribute("systemNote")==null) {
					SystemService systemService = new SystemService();
					List<ExamSystem> examSystemList = (systemService.findAll(ExamSystem.class));
					ExamSystem examSystem = examSystemList.get(0);
					application.setAttribute("systemName", examSystem.getSysName());
					application.setAttribute("systemNote", examSystem.getSysNotes());
				}
				if((user.getUserIsAdmin()).equals("1")){
					session.setAttribute("adminId", user.getUserId());
					session.setAttribute("admin", user);
					return "admin";
				} else{;
					infList = examInfoService.findEntityByName(ExamInformation.class, "teacherId", user.getUserId());
					for(ExamInformation information:infList){
						infMap.put(information.getExamId(), information.getExamName());
					}
					
					session.setAttribute("exam", infMap);
					session.setAttribute("teacherId", user.getUserId());
					session.setAttribute("teacher", user);
					return "teacher";
				}	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return "fail";
	}

}
