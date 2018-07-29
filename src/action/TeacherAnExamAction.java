package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.ExamInformation;
import com.entity.ExamRecord;
import com.opensymphony.xwork2.ActionSupport;
import com.service.Impl.ExamInfoService;
import com.service.Impl.StudentService;

public class TeacherAnExamAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		//得到客户端传过来的考试id
		//分析考试将数据返回
		HttpServletRequest request = ServletActionContext.getRequest();
		String examId = request.getParameter("examid");
		if(request.getAttribute("examInformation") == null) {
			StudentService studentService = new StudentService();
			
			int passNum = studentService.findPassCount(examId);
			List<String> anaList = studentService.findExamAnalysis(examId);
			
			int subjectNum = studentService.findExamCount(examId);
			request.setAttribute("subjectNum", subjectNum);

			
			ExamInfoService examInfoService = new ExamInfoService();
			ExamInformation examInformation = examInfoService.findById(ExamInformation.class, examId);
			
			String[] choice = examInformation.getExamChoice().split(";|,");
			
			int choiceNum = Integer.valueOf(choice[0])+Integer.valueOf(choice[2])+Integer.valueOf(choice[4]);
			int compareNum[] = new int[choiceNum];
			if(examInformation.getExamAnalysis()==null) {
				List<ExamRecord> recordList = new StudentService().findEntityByName(ExamRecord.class, "exam_id", examId);
				for(ExamRecord examRecord:recordList) {
					if(examRecord.getStudentCompare() != null) {
						String[] compare = examRecord.getStudentCompare().split(",;|,");
						for(int i = 0 ;i< choiceNum ;i++ ){
							compareNum[i] += Integer.valueOf(compare[i]);
						}
					}
					
				}
				String compare="";
				for(int i = 0 ;i< choiceNum ;i++ ){
					compare+=String.valueOf(compareNum[i])+",";
				}
				examInformation.setExamAnalysis(compare);
				examInfoService.update(examInformation);
			}

			request.setAttribute("num", anaList.get(0));
			request.setAttribute("avgNum", anaList.get(1));
			request.setAttribute("maxNum", anaList.get(2));
			request.setAttribute("minNum", anaList.get(3));
			request.setAttribute("passNum", passNum);
			request.setAttribute("examInformation", examInformation);
		}

		return "result";
	}
}
