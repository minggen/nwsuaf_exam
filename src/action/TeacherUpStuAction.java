package action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.entity.ExamRecord;
import com.opensymphony.xwork2.ActionSupport;
import com.service.Impl.StudentsUploadService;
import com.utils.ReadExcelUtils;

public class TeacherUpStuAction extends ActionSupport{  
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File myFile;
	   private String myFileContentType;
	   private String myFileFileName;
	   
	   List<ExamRecord> list = null;
	   StudentsUploadService studentsUploadService = new StudentsUploadService();

	   public String execute()
	   {
		  
		  try {
			  HttpServletRequest request = ServletActionContext.getRequest();
			  request.setCharacterEncoding("utf8");
			  String examId = request.getParameter("city");
			  System.out.println(examId);
		      //获取examId
		      String userId = (String) request.getSession().getAttribute("teacherId");

		      System.out.println(userId);
			 
			  String suffix = myFileFileName.substring(myFileFileName.lastIndexOf(".") + 1);
			  if(suffix.equals("xls")) {;
				 	try {
					list = ReadExcelUtils.readStuXls(myFile,examId);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  } else if(suffix.contentEquals("xlsx")){
				 try {
					list = ReadExcelUtils.readStuXlsx(myFile,examId);
				 } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				 }
			  }
			  for(ExamRecord record:list) {
				 studentsUploadService.save(record);
			  }
			  return "success";
		  } catch (Exception e1) {
			  // TODO Auto-generated catch block
			  e1.printStackTrace();
		  }
	      return "error";
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