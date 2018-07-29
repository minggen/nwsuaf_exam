package action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.ExamSingleChoice;
import com.opensymphony.xwork2.ActionSupport;
import com.service.Impl.SingleChoiceService;
import com.utils.ReadExcelUtils;

public class TeacherSingleUpAction extends ActionSupport{  
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File myFile;
	   private String myFileContentType;
	   private String myFileFileName;
	   private List<ExamSingleChoice> list;
	   
	   public String execute()
	   {
	      SingleChoiceService singleService = new SingleChoiceService();  
	      try{     	    	 
			   //String teacherId = (String) ServletActionContext.getRequest().getSession().getAttribute("user");
	    	  HttpServletRequest request = ServletActionContext.getRequest(); 
	    	  String teacherId = (String) request.getSession().getAttribute("teacherId");
			   String suffix = myFileFileName.substring(myFileFileName.lastIndexOf(".") + 1);
			   if(suffix.equals("xls")) {;
				   try {
						list = ReadExcelUtils.readSinXls(myFile,teacherId);
				   } catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				   }
			   } else if(suffix.contentEquals("xlsx")){
					 try {
						list = ReadExcelUtils.readSinXlsx(myFile,teacherId);
					 } catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					 }
			   }
			   String nowId = singleService.getMaxId(teacherId);
				if(nowId == null) {
					nowId = "00000";
				}
				int number = Integer.parseInt(nowId.substring(nowId.length()-4));
			   for(ExamSingleChoice singleChoice:list) {	   
				   number++;
				   singleChoice.setScId("001"+teacherId+String.format("%04d", number));
				   singleService.save(singleChoice);
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