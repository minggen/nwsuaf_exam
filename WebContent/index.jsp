<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>首页</title>


<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap/css/modern-business.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="jsp/lib/layui/css/layui.css" />
<style>
body {
	background-color: snow;
}

.carousel-item h3, p {
	color: #000000;
}
</style>
</head>

<body>


	<nav
		class="navbar fixed-top navbar-expand-lg navbar-dark  fixed-top" style="background-color: #19a97b;">
		<div class="container">
			<a class="navbar-brand" href="#">OnLineExam V2.0</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="#"><i class="layui-icon">&#xe60b;</i> 关于</a></li>
					<li class="nav-item"><a class="nav-link" href="#">注册</a></li>
					<li class="nav-item"><a class="nav-link" target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=919767736&site=qq&menu=yes"><i class="layui-icon">&#xe613;</i>联系我</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<header>
		<div id="carouselExampleIndicators" class="carousel slide"
			data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carouselExampleIndicators" data-slide-to="0"
					class="active"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner" role="listbox">
				<!-- Slide One - Set the background image for this slide in the line below -->
				<div class="carousel-item active"
					style="background-image: url('images/txg.png')">
					<div class="carousel-caption d-none d-md-block ">
						
					</div>
				</div>
				<!-- Slide Two - Set the background image for this slide in the line below -->
				<div class="carousel-item"
					style="background-image: url('images/txg2.png')">
					<div class="carousel-caption d-none d-md-block">
						
					</div>
				</div>
				<!-- Slide Three - Set the background image for this slide in the line below -->
				<div class="carousel-item"
					style="background-image: url('images/loginxg.jpg')">
					<div class="carousel-caption d-none d-md-block">
					<!-- 	<h3>运行效果</h3>
						<p>This is a description for the third slide.</p> -->
					</div>
				</div>
			</div>
			<a class="carousel-control-prev" href="#carouselExampleIndicators"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</header>



	<div class="container">
		<div class="row" style="margin-top: 10px;">
			<div class="col-md-3"></div>
			<div class="col-md-3">
				<a href="./stuLogin.action" class="btn btn-success btn-lg">我是学生</a>
			</div>
			<div class="col-md-3">
					<a href="ppt/ppt.html" class="btn btn-success btn-lg">答辩ppt</a>
			</div>
			<div class="col-md-3">
				<a href="./jsp/ad_login.jsp" class="btn btn-success btn-lg">老师管理员</a>
			</div>

		</div>

		<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 30px;">
			<legend><strong>日程:</strong></legend>
		</fieldset>
		<ul class="layui-timeline">
			<li class="layui-timeline-item"><i
				class="layui-icon layui-timeline-axis"></i>
				<div class="layui-timeline-content layui-text">
					<div class="layui-timeline-title">2018年1月1日，进行测试</div>
				</div></li>
			<li class="layui-timeline-item"><i
				class="layui-icon layui-timeline-axis"></i>
				<div class="layui-timeline-content layui-text">
					<div class="layui-timeline-title">2017年12月15日，开始进行编码</div>
				</div></li>
			<li class="layui-timeline-item"><i
				class="layui-icon layui-timeline-axis"></i>
				<div class="layui-timeline-content layui-text">
					<div class="layui-timeline-title">2017年12月15日，开始进行编码</div>
				</div></li>
			<li class="layui-timeline-item"><i
				class="layui-icon layui-timeline-axis"></i>
				<div class="layui-timeline-content layui-text">
					<div class="layui-timeline-title">2017年12月5日，开始系统设计</div>
				</div></li>
			<li class="layui-timeline-item"><i
				class="layui-icon layui-timeline-axis"></i>
				<div class="layui-timeline-content layui-text">
					<div class="layui-timeline-title">2017年12月1日，开始需求分析</div>
				</div></li>
			<li class="layui-timeline-item"><i
				class="layui-icon layui-anim layui-anim-rotate layui-anim-loop layui-timeline-axis"></i>
				<div class="layui-timeline-content layui-text">
					<div class="layui-timeline-title">更久前，开始构思考试系统结构</div>
				</div></li>
		</ul>


		<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 30px;">
			<legend><strong>小组成员</strong></legend>
		</fieldset>

		<div class="row">
			<div class="col-lg-4 mb-4">
				<div class="card h-100">
					<h4 class="card-header">王明根</h4>
					<div class="card-body">
						<p class="card-text">需求分析，数据库设计，前端页面设计，部分文档编写，前端页面编码<!-- (老师，学生，管理员各种功能页面) --> ，前后端整合</p>
					</div>
				</div>
			</div>


			<div class="col-lg-4 mb-4">
				<div class="card h-100">
					<h4 class="card-header">朱丹</h4>
					<div class="card-body">
						<p class="card-text">参与需求分析，完成用例图，参与总体设计，教师模块设计，学生登录页面设计及测试
</p>
					</div>
					
				</div>
			</div>

			<div class="col-lg-4 mb-4">
				<div class="card h-100">
					<h4 class="card-header">韩晴</h4>
					<div class="card-body">
						<p class="card-text">需求分析文字部分，设计分析教师模块，考试提交页面，测试用例管理员教师登录部分
</p>
					</div>
					
				</div>
			</div>

			<div class="col-lg-4 mb-4">
				<div class="card h-100">
					<h4 class="card-header">李柯君</h4>
					<div class="card-body">
						<p class="card-text">数据库的设计,后端开发，ssh框架的搭建,代码的书写，dao层，service层，aciton层实现,前后端数据交互接口整合
</p>
					</div>
					
				</div>
			</div>

			<div class="col-lg-4 mb-4">
				<div class="card h-100">
					<h4 class="card-header">韩硕</h4>
					<div class="card-body">
						<p class="card-text">管理员部分设计文档的编写和设计文档的整理；参与系统功能的分析讨论；参与数据库部分的设计；部分网页的设计和前端代码的编写；教师的单个导入学生功能的测试；
</p>
					</div>
					
				</div>
			</div>
			<div class="col-lg-4 mb-4">
				<div class="card h-100">
					<h4 class="card-header">齐丽丽</h4>
					<div class="card-body">
						<p class="card-text">学生设计部分文档 新建考试界面,PPT(学生效果部分),增加题目测试用例</p>
					</div>
					
				</div>
			</div>

			<div class="col-lg-4 mb-4">
				<div class="card h-100">
					<h4 class="card-header">宋道航</h4>
					<div class="card-body">
						<p class="card-text">完善需求分析说明书内容及格式，完善设计文档部分内容及格式，参与总体设计及部分设计的分析讨论，测试登录界面与题库方面测试，编写相关测试文档
</p>
					</div>
					
				</div>
			</div>

			<div class="col-lg-4 mb-4">
				<div class="card h-100">
					<h4 class="card-header">欧阳杨</h4>
					<div class="card-body">
						<p class="card-text">提供可下载的试题模板，并将上传的试题文件数据导入至数据库
						</p>
					</div>
					
				</div>
			</div>

			<div class="col-lg-4 mb-4">
				<div class="card h-100">
					<h4 class="card-header">刘洋</h4>
					<div class="card-body">
						<p class="card-text">参与系统功能分析的讨论。参与网页前端设计。编写文档，并对学生功能进行测试。
</p>
					</div>
					
				</div>
			</div>
		</div>


	</div>



	
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; wmg 2017</p>
		</div>	
	</footer>
	
	
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="jsp/lib/layui/layui.js"></script>

</body>

</html>
