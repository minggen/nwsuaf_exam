<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.*,com.entity.*"%>
<%
	List<ExamInformation> infList = (List<ExamInformation>)application.getAttribute("stuExam");
%>
<jsp:include page="./common/meta.jsp"></jsp:include>
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="bootstrap/css/bootstrapValidator.css">
<script type="text/javascript" src="jsp/lib/jquery/1.9.1/jquery.min.js"></script>
<script src="bootstrap/js/bootstrapValidator.min.js"></script>


<title>学生登录</title>
</head>
<style>
body {
	/*background-color: #323542;*/
	background-image: url("images/loginbg.jpg");
}

.config-all {
	background-color: snow;
	width: 500px;
	height: 600px;
	box-shadow: 5px -5px #afafaf;
	border-radius: 18px;
	filter: alpha(Opacity = 80);
	-moz-opacity: 0.8;
	opacity: 0.8;
}
#form_login{
margin-top: 50px; width: 90%; margin-left: 22px;
}
</style>
<body>
	<div class="container-fluid " id="bgcolor">
		<div class="row" style="margin-top: 100px;">
			<!--  <div class="col-md-4"></div> -->
			<div class="col-md-4 col-md-offset-4 config-all" >
				<form method="post" role="form" id="form_login" action="stuShow"
					style="">
					<h1 style="text-align: center; letter-spacing: 10px;">欢迎</h1>
					<div class="form-group" style="margin-top: 20px;">
						<div class="input-group input-group-lg">
							<div class="input-group-addon">
								<span class="glyphicon glyphicon-user"></span>
							</div>
							<input type="text" class="form-control" name="username"
								id="username" placeholder="账号" autocomplete="off">
						</div>

					</div>

					<div class="form-group" style="margin-top: 36px;">
						<div class="input-group input-group-lg">
							<div class="input-group-addon">
								<span class="glyphicon glyphicon-lock"></span>
							</div>
							<input type="password" class="form-control" name="password"
								id="password" placeholder="密码" autocomplete="off">
						</div>
					</div>

					<div class="form-group" style="margin-top: 36px;">
						<div class="input-group input-group-lg">
							<div class="input-group-addon">
								<span class="glyphicon glyphicon-blackboard"></span>
							</div>
							<select id="examid" name="examid" class="form-control" placeholder="试卷ID">
								<option>请选择考试场次</option>
								<%
									for(ExamInformation inf:infList) {
										String id = inf.getExamId();
										String name = inf.getExamName();
								 %>
								<option value="<%=id%>"><%=name %></option>
								<%
									}
								 %>
							</select>
						</div>
					</div>

					<div class="form-group " style="margin-top: 40px;">
						<button type="submit"
							class="btn btn-primary btn-lg btn-block btn-login"  disabled="disabled">
							<span class="glyphicon glyphicon-home"></span> 登录
						</button>
					</div>

					<%
						if (request.getParameter("fail") != null && request.getParameter("fail").equals("true")) {
					%>
					<div class="alert alert-danger">
						<a href="#" class="close" data-dismiss="alert"> &times; </a> <strong>错误！</strong>用户名或密码错误,请重新登录
					</div>
					<%
						}
					%>
				</form>

			</div>

		</div>

	</div>
	<script src="js/stu_login.js"></script>
	<jsp:include page="./common/importjs.jsp"></jsp:include>
	<jsp:include page="./common/footer.jsp"></jsp:include>