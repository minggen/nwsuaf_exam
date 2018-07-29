<%@page import="com.entity.ExamInformation"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--设置从服务器得到的数据  -->
<%
	ExamInformation examInformation = (ExamInformation)request.getAttribute("examInformation");
	String num = (String)request.getAttribute("num");
	int passNum = (int)request.getAttribute("passNum");
	String minNum = (String)request.getAttribute("minNum");
	String maxNum =(String)request.getAttribute("maxNum");
	String avgNum = (String)request.getAttribute("avgNum");

	String[] questions = examInformation.getExamQustions().split(",;|,");
	String[] compareNum = examInformation.getExamAnalysis().split(",");
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
	<div class="panel-header">试卷分析表</div>
	<div class="panel-body">
		<table class="table table-hover table-bordered table-striped ">
			<tr>
				<th colspan="2" class="center f20 fw700">试卷整体情况</th>
			</tr>
			<tr>
				<td class="col-4">总分</td>
				<td class="col-6">100</td>
			</tr>
			<tr>
				<td>选课人数</td>
				<td><%=request.getAttribute("subjectNum") %></td>
			</tr>
			
			
			<tr>
				<td>考试人数</td>
				<td><%=num %></td>
			</tr>
			<tr>
				<td>及格人数</td>
				<td><%=passNum %></td>
			</tr>
			<tr>
				<td>及格率</td>
				<td><%=(int)(((float)passNum/Float.parseFloat(num))*100) %>%</td>
			</tr>
			<tr>
				<td>最高分</td>
				<td><%=maxNum %></td>
			</tr>
			<tr>
				<td>最低分</td>
				<td><%=minNum.equals("-1")?0:minNum %></td>
			</tr>
			<tr>
				<td>平均分</td>
				<td><%=avgNum %></td>
			</tr>


		</table>
		<br />
		<table class="table table-hover table-bordered table-striped ">
			<tr>
				<th colspan="4" class="center f20 fw700"><%=examInformation.getExamName() %>&nbsp考试试卷分析</th>
			</tr>
			<tr>
				<th class="col-3">题目描述</th>
				<th class="col-3">答题人数</th>
				<th class="col-3">正确数</th>
				<th class="col-3">正确率</th>
			</tr>
			<%
				for(int i = 0 ;i< compareNum.length ;i++) {
			%>
			<tr>
				<th><%=questions[i] %></th>
				<th><%=num %></th>
				<th><%=compareNum[i] %></th>
				<th><%=(int)((Float.valueOf(compareNum[i])/Float.parseFloat(num))*100) %>%</th>
			</tr>
			<%
				}
			%>

		</table>

		<br />

	</div>
</div>
