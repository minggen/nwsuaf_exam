<%@page import="com.entity.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<ExamMultiChoice> mulList = (List<ExamMultiChoice>)request.getAttribute("multichoice");
	List<ExamSingleChoice> singleList = (List<ExamSingleChoice>)request.getAttribute("singlechoice");
	List<ExamTofChoice> tofList = (List<ExamTofChoice>)request.getAttribute("tofChoice");
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-header">一、选择题</div>
                   <table class="table table-striped table-hover table-bordered table-responsive" style=" table-layout:fixed;">
                       <thead>
                           <tr >
                               	<th width="2%"></th>
                               	<th width="5%">科目</th>
                               	<th width="50%">题目描述</th>
                               	<th width="10px">答案</th>
                              	<th width="6%"></th>
                           </tr>
                       </thead>
                       <tbody>
                       		
                       		<%
                       			int i = 0;
                       			for(ExamSingleChoice sinChoice:singleList) {
                       				i++;
                       				String subjectName = sinChoice.getSubjectName();
                       				String question = sinChoice.getScQuestion();
                       				String answerA = sinChoice.getScAnswerA();
                       				String answerB = sinChoice.getScAnswerB();
                       				String answerC = sinChoice.getScAnswerC();
                       				String answerD = sinChoice.getScAnswerD();
                       				String answer = sinChoice.getScAnswerCorrect();
                       				String analysis = sinChoice.getScAnalysis();
                       		 %>
                       		 <tr>
                       		 	<td style="text-align: center"><%=i %></td>
                       		 	<td style="text-align: center"><%=subjectName %></td>
                               	<td> 
                               		<%=question %><br>
                               		A:<%=answerA %><br>
                               		B:<%=answerB %><br>
                               		C:<%=answerC %><br>
                               		D:<%=answerD %><br>
                               		解析：<%=analysis %>
                               	</td>
                               	<td><%=answer %></td>
                               	<td>
                                   <div class="btn-group">
                                   <!-- request里获取题目及id -->
                                       <a href="delete_question?id=<%=sinChoice.getScId() %>" class="btn btn-danger">删除</a>
                                   </div>
                               </td>
                              </tr>
                       		 <%
                       		 	}
                       		  %>
                       </tbody>
                   </table>
                   
                   
                   <div class="panel-header">二、多选题</div>
                   <table class="table table-striped table-hover table-bordered table-responsive" style=" table-layout:fixed;">
                       <thead>
                           <tr >
                               <th width="2%"></th>
                               <th width="5%">科目</th>
                               <th width="50%">题目描述</th>
                               <th width="10px;">答案</th>
                              	<th width="6%"></th>
                           </tr>
                       </thead>
                       <tbody>
                         	<%
                       			i = 0;
                       			for(ExamMultiChoice sinChoice:mulList) {
                       				i++;
                       				String subjectName = sinChoice.getSubjectName();
                       				String question = sinChoice.getMcQuestion();
                       				String answerA = sinChoice.getMcAnswerA();
                       				String answerB = sinChoice.getMcAnswerB();
                       				String answerC = sinChoice.getMcAnswerC();
                       				String answerD = sinChoice.getMcAnswerD();
                       				String answerE = sinChoice.getMcAnswerE();
                       				String answer = sinChoice.getMcAnswerCorrect();
                       				String analysis = sinChoice.getMcAnalysis();
                       		 %>
                       		 <tr>
                       		 	<td style="text-align: center"><%=i %></td>
                       		 	<td style="text-align: center"><%=subjectName %></td>
                               	<td> 
                               		<%=question %><br>
                               		A:<%=answerA %><br>
                               		B:<%=answerB %><br>
                               		C:<%=answerC %><br>
                               		D:<%=answerD %><br>
                               		E:<%=answerE %><br>
                               		解析：<%=analysis %>
                               	</td>
                               	<td><%=answer %></td>
                               	<td>
                                   <div class="btn-group">
                                   <!-- request里获取题目及id -->
                                       <a href="delete_question?id=<%=sinChoice.getMcId() %>" class="btn btn-danger">删除</a>
                                   </div>
                               </td>
                              </tr>
                       		 <%
                       		 	}
                       		  %>
                       </tbody>
                   </table>
                   
                   
                    <div class="panel-header">三、判断题（A为正确，B为错误）</div>
                   <table class="table table-striped table-hover table-bordered table-responsive" style=" table-layout:fixed;">
                       <thead>
                           <tr >
                               <th width="2%"></th>
                               <th width="5%">科目</th>
                               <th width="50%">题目描述</th>
                               <th width="10px;">答案</th>
                              	<th width="6%"></th>
                           </tr>
                       </thead>
                       <tbody>
                       		<%
                       			i = 0;
                       			for(ExamTofChoice sinChoice:tofList) {
                       				i++;
                       				String subjectName = sinChoice.getSubjectName();
                       				String question = sinChoice.getTcQuestion();;
                       				String answer = sinChoice.getTcAnswerCorrect();
                       				String analysis = sinChoice.getTcAnalysis();
                       		 %>
                       		 <tr>
                       		 	<td style="text-align: center"><%=i %></td>
                       		 	<td style="text-align: center"><%=subjectName %></td>
                               	<td> 
                               		<%=question %><br>
                               		解析：<%=analysis %>
                               	</td>
                               	<td><%=answer %></td>
                               	<td>
                                   <div class="btn-group">
                                   <!-- request里获取题目及id -->
                                       <a href="javascript:if(confirm('确定要删除吗？')) window.location.replace('delete_question?id=<%=sinChoice.getTcId() %>')" class="btn btn-danger">删除</a>
                                   </div>
                               </td>
                              </tr>
                       		 <%
                       		 	}
                       		  %>
                       </tbody>
                   </table> 
               </div>
                    
 
<script src="jsp/lib/layui/layui.js"></script>



</body>
</html>