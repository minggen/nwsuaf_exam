<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.entity.*" %>
<%

	
	String examName = ((ExamInformation)session.getAttribute("examInformation")).getExamName();
	String examId = ((ExamInformation)session.getAttribute("examInformation")).getExamId();
	String stuId = ((ExamRecord)session.getAttribute("student")).getStudentNo();
	String stuName = ((ExamRecord)session.getAttribute("student")).getStudentName();
%>
<!-- meat
	meta信息
 -->
<jsp:include page="../common/meta.jsp"></jsp:include>
<!-- end meat -->

<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css" />

<title>考试结果</title>
</head>
<body>
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
	<div class="container">

		<div class="row" style="margin-top: 100px;">
			<div class="col-md-6 col-md-offset-3">
				<table class="table table-hover table-bordered table-striped f20">
					<tr>
						<td colspan="2" class="center f20 fw700"><%=examName %></td>
					</tr>

					<tr>
						<th>准考证号:</th>
						<td><%=stuId %></td>
					</tr>

					<tr>
						<th>姓名</th>
						<td><%=stuName %></td>
					</tr>
					<tr>
						<th>成绩</th>
						<td class="success"><%=(Double)request.getAttribute("score") %>分</td>
					</tr>
					<tr>
						<th>考试ID</th>
						<td><%=examId %></td>
					</tr>
					<tr>
						<td colspan="2" class="center f20 fw700">考试详情</td>
					</tr>
					<tr>
						<td colspan="2">
							
							<table class="table table-bordered ">
								
									<tr>
										<td>试题类型</td>
										<td>题目总数</td>
										<td>正确数目</td>
									</tr>
								
									<tr>
										<td>选择题</td>
										<td><%=(String)request.getAttribute("singleAll") %></td>
										<td><%=(int)request.getAttribute("singleNum") %></td>
									</tr>
									<tr>
										<td>多选题</td>
										<td><%=(String)request.getAttribute("multiAll") %></td>
										<td><%=(int)request.getAttribute("multiNum") %></td>
									</tr>
									<tr>
										<td>判断题</td>
										<td><%=(String)request.getAttribute("tofAll") %></td>
										<td><%=(int)request.getAttribute("tofNum") %></td>
									</tr>
								
							</table>


						</td>
					</tr>

				</table>


			</div>
		</div>
	</div>
	<%
		session.removeAttribute("student");
		session.removeAttribute("student");
		session.removeAttribute("examInformation");
		session.removeAttribute("singleList");
		session.removeAttribute("mulList");
		session.removeAttribute("tofList");
	
	 %>
</body>
<script type="text/javascript" src="jsp/lib/jquery/1.9.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>

