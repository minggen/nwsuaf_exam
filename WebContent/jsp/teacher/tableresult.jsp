
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*,com.entity.*"%>
<%
	String examName = ((Map<String,String>)session.getAttribute("exam")).get((String)request.getAttribute("examId"));
	List<ExamRecord> recordList = (List<ExamRecord>)request.getAttribute("stuList");
%>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css" />
<style>
.center {
	text-align: center;
}

.f20 {
	font-size: 20px;
}

.fw700 {
	font-weight: 700;
}
</style>

<div class="panel panel-default">
	<div class="panel-header">数据表</div>
	<div class="panel-body">
		<table class="table table-hover table-bordered table-striped ">
			<tr>
				<th colspan="4" class="center f20 fw700"><%=examName %></th>
			</tr>
			<tr>
				<th class="col-3">准考证号</th>
				<th class="col-3">姓名</th>
				<th class="col-3">考试ID</th>
				<th class="col-3">成绩</th>
			</tr>				
			
			<%
				for(ExamRecord stuRecord:recordList) {
					String str = null;
					if(stuRecord.getScoreSubmit() != -1.0){
						str = String.valueOf(stuRecord.getScoreSubmit());
					} else{
						str = "该考生未参加考试";
					}
					
			%>
			<tr>
				<th><%=stuRecord.getStudentNo() %></th>
				<th><%=stuRecord.getStudentName() %></th>
				<th><%=stuRecord.getExamId() %></th>
				<th><%=str %></th>
			</tr>	
			<%} %>
			
		</table>
	</div>
</div>



<!-- <script type="text/javascript" src="jsp/lib/jquery/1.9.1/jquery.min.js"></script> -->
<!-- <script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->

