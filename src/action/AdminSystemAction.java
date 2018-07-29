package action;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.ExamSystem;
import com.opensymphony.xwork2.ActionSupport;
import com.service.Impl.SystemService;

@SuppressWarnings("serial")
public class AdminSystemAction extends ActionSupport {
	public String getInfo() {
		
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf8");	
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String time = df.format(new Date());
			request.setAttribute("systemTime", time);
			
			return "success";
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}
	public String setInfo() {
		
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf8");
			ServletContext application = request.getSession().getServletContext();
			
			String systemName = request.getParameter("systemname");
			String systemNote = request.getParameter("systemnote");
			
			SystemService systemService = new SystemService();
			ExamSystem examSystem = systemService.findById(ExamSystem.class, "1");
			
			if(!systemName.equals("")){
				examSystem.setSysName(systemName);
				application.setAttribute("systemName", systemName);
			}
			if(!systemNote.equals("")) {
				examSystem.setSysNotes(systemNote);
				application.setAttribute("systemNote", systemNote);
			}
			systemService.update(examSystem);
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String time = df.format(new Date());
			request.setAttribute("systemTime", time);
			
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}
}
