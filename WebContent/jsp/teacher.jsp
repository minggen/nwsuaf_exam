<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	 	
	 	if ( session.getAttribute("teacherId")==null ) {
	        response.sendRedirect("../index.jsp"); 
		 }
	 	 System.out.print("ok");
%>
<!-- meat
	meta信息
 -->
<jsp:include page="./common/meta.jsp"></jsp:include>
<!-- end meat -->

<!-- 
导入页面公共css
 -->
<jsp:include page="./common/linkcss.jsp"></jsp:include>
<!-- 
单个页面所用css放在这下面
 -->
<title>教师用户</title>
</head>


<body>

<!-- 
	引入导航栏
 -->
<jsp:include page="./teacher/teacher_nav.jsp"></jsp:include>
<!-- 
	引入右侧功能
 -->
 <jsp:include page="./teacher/teacher_menu.jsp"></jsp:include>	
 

<section class="Hui-article-box">
	<nav class="breadcrumb"><i class="Hui-iconfont"></i> <a href="/" class="maincolor">去首页</a> </nav>
	<div class="Hui-article">

		<article class="cl pd-20">
			<%if(request.getParameter("op")!=null){
				
				if(request.getParameter("op").equals("importquestions")) {%>
				
				<jsp:include page="./teacher/importquestions.jsp"></jsp:include>
				<%} %>
				
				<%if(request.getParameter("op").equals("addquestion")) {%>
					<jsp:include page="./teacher/addquestion.jsp"></jsp:include>
				<%} %>
				
				<%if(request.getParameter("op").equals("newexam")) {%>
					 <jsp:include page="./teacher/newexam.jsp"></jsp:include>
					
				<%} %>
				
				<%if(request.getParameter("op").equals("importstudents")) {%>
					 <jsp:include page="./teacher/importstudents.jsp"></jsp:include>
					
				<%} %>
				
				<%if(request.getParameter("op").equals("importstudent")) {%>
					 <jsp:include page="./teacher/importstudent.jsp"></jsp:include>
					
				<%} %>
				
				<%if(request.getParameter("op").equals("questionslist")) {%>
					 <jsp:include page="./teacher/questionslist.jsp"></jsp:include>
					
				<%} %>
				
				<%if(request.getParameter("op").equals("success")) {%>
					表单提交成功
				<%} %>
				
				<%if(request.getParameter("op").equals("error")) {%>
					提交异常
				<%} %>
				
				<%if(request.getParameter("op").equals("studentpic")) {%>
					<jsp:include page="./teacher/sendidtopic.jsp"></jsp:include>
				<%} %>
				
				<%if(request.getParameter("op").equals("picresult")) {%>
					 <jsp:include page="./teacher/picresult.jsp"></jsp:include>
				
				<%} %>
				
				<%if(request.getParameter("op").equals("studenttable")) {%>
					 <jsp:include page="./teacher/sendidtostudenttable.jsp"></jsp:include>
					
				<%} %>
				<%if(request.getParameter("op").equals("tableresult")) {%>
					 <jsp:include page="./teacher/tableresult.jsp"></jsp:include>
					
				<%} %>
				
				<%if(request.getParameter("op").equals("anexam")) {%>
					 <jsp:include page="./teacher/sendidtoanexam.jsp"></jsp:include>
				<%} %>
				
				<%if(request.getParameter("op").equals("anexamresult")) {%>
					 <jsp:include page="./teacher/anexamresult.jsp"></jsp:include>
				<%} %>
				
				<%if(request.getParameter("op").equals("lookupexamlist")) {%>
					 <jsp:include page="./teacher/lookupexamlist.jsp"></jsp:include>
				<%} %>
				
			<%} %>
		</article>
	</div>
</section>


<jsp:include page="./common/importjs.jsp"></jsp:include>

<script type="text/javascript">
	$(document).ready(function(){
		    var ii = layer.load();
		    //此处用setTimeout演示ajax的回调
		    setTimeout(function(){
		      layer.close(ii);
		    }, 1000);
	})
	   
</script>
<script>
//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
  var element = layui.element;
  
  //…
});
</script>

<jsp:include page="./common/footer.jsp"></jsp:include>
    