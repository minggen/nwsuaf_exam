package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ExitAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String teacher(){
		HttpServletRequest request=ServletActionContext.getRequest();;
		
		try {
			request.getSession().removeAttribute("teacherId");
			System.out.println("remove");
			return "index";
		}catch(Exception e){
			
		}
		return "error";
		
	}
	public String admin(){
		HttpServletRequest request=ServletActionContext.getRequest();;
		
		try {
			request.getSession().removeAttribute("adminId");
			System.out.println("remove");
			return "index";
		}catch(Exception e){
			
		}
		return "error";
	}
	public String student(){
		HttpServletRequest request=ServletActionContext.getRequest();;
		
		try {
			request.getSession().removeAttribute("student");
			System.out.println("remove");
			return "student";
		}catch(Exception e){
			
		}
		return "error";
	}
		
}
