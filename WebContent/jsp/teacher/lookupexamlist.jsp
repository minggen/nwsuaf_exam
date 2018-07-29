<%@page import="com.entity.ExamInformation"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	List<ExamInformation> examInList = (List<ExamInformation>)request.getAttribute("examList");
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

<script src="jsp/lib/layui/layui.js"></script>

<!--设置从服务器得到的数据  -->
<div class="panel panel-default">
	<div class="panel-header">考试列表</div>
	<div class="panel-body">
		<table class="table table-hover table-bordered table-striped ">
			<tr>
				<th colspan="5" class="center f20 fw700">考试列表</th>
			</tr>
			
			<tr>
				<th class="col-2">考试场次ID</th>
				<th class="col-2">考试名称</th>
				<th class="col-2">科目名称</th>
				<th class="col-2">开考时间</th>
				<th class="col-2">考试时长</th>
			</tr>
			<% 
				for(ExamInformation examInformation:examInList){
			%>
			<tr>
				<th><%=examInformation.getExamId() %></th>
				<th><%=examInformation.getExamName() %></th>
				<th><%=examInformation.getSubjectName() %></th>
				<th><%=examInformation.getExamBeginTime() %></th>
				<th><%=examInformation.getExamTime() %></th>
			</tr>
			
			<%} %>

		</table>

		<br />

	</div>
</div>

