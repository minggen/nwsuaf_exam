<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>管理系统</title>
</head>


<body>

<!-- 
	引入导航栏
 -->
<jsp:include page="./admin/admin_nav.jsp"></jsp:include>
<!-- 
	引入右侧功能
 -->
 <jsp:include page="./admin/admin_menu.jsp"></jsp:include>	
 

<section class="Hui-article-box">
	<nav class="breadcrumb"><i class="Hui-iconfont"></i> <a href="/" class="maincolor">去首页</a> </nav>
	<div class="Hui-article">
		<article class="cl pd-20">
			<%if(request.getParameter("op")!=null){
				
				if(request.getParameter("op").equals("teacherlist")) {%>
				<jsp:include page="./admin/teacherslist.jsp"></jsp:include>
				<%} %>
				
				<%if(request.getParameter("op").equals("addteacher")) {%>
					<jsp:include page="./admin/addteacher.jsp"></jsp:include>
				<%} %>
				
				<%if(request.getParameter("op").equals("delteacher")) {%>
					<%-- <jsp:include page="./admin/delteacher.jsp"></jsp:include> --%>
					删除老师
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
<jsp:include page="./common/footer.jsp"></jsp:include>
