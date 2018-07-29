package action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.ExamMultiChoice;
import com.opensymphony.xwork2.ActionSupport;
import com.service.Impl.MultiChoiceService;
import com.utils.ReadExcelUtils;

public class TeacherMutiUpAction extends ActionSupport{  
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File myFile;
	   private String myFileContentType;
	   private String myFileFileName;
	   private List<ExamMultiChoice> list;
	   
	   public String execute()
	   {
	      MultiChoiceService multiChoiceService = new MultiChoiceService();
	      try{	     	    	 
			   //String teacherId = (String) ServletActionContext.getRequest().getSession().getAttribute("user");
			  HttpServletRequest request = ServletActionContext.getRequest(); 
	    	  String teacherId = (String) request.getSession().getAttribute("teacherId");
			   String suffix = myFileFileName.substring(myFileFileName.lastIndexOf(".") + 1);
			   if(suffix.equals("xls")) {;
				   try {
						list = ReadExcelUtils.readMulXls(myFile,teacherId);
				   } catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				   }
			   } else if(suffix.contentEquals("xlsx")){
					 try {
						list = ReadExcelUtils.readMulXlsx(myFile,teacherId);
					 } catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					 }
			   }
			   String nowId = multiChoiceService.getMaxId(teacherId);
				if(nowId == null) {
					nowId = "00000";
				}
				int number = Integer.parseInt(nowId.substring(nowId.length()-4));
			   for(ExamMultiChoice multiChoice:list) {
				   number++;
				   multiChoice.setMcId("002"+teacherId+String.format("%04d", number));
				   multiChoiceService.save(multiChoice);
			   }
		   }catch(Exception e){
			   e.printStackTrace();
			   return ERROR;
		   }
	      
	      //将学生名单存数据�?
	      
	      return "success";
	   }
	   public File getMyFile() {
	      return myFile;
	   }
	   public void setMyFile(File myFile) {
	      this.myFile = myFile;
	   }
	   public String getMyFileContentType() {
	      return myFileContentType;
	   }
	   public void setMyFileContentType(String myFileContentType) {
	      this.myFileContentType = myFileContentType;
	   }
	   public String getMyFileFileName() {
	      return myFileFileName;
	   }
	   public void setMyFileFileName(String myFileFileName) {
	      this.myFileFileName = myFileFileName;
	   }
}  