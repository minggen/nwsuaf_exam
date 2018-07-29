<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	 	
	 	if ( session.getAttribute("adminId")==null ) {
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
				
				
				if(request.getParameter("op").equals("teacherslist")) {%>
					<jsp:include page="./admin/teacherslist.jsp"></jsp:include> 
				<%} %>
				
				<%if(request.getParameter("op").equals("addteacher")) {%>
					<jsp:include page="./admin/addteacher.jsp"></jsp:include>
				<%} %>
				
				<%if(request.getParameter("op").equals("delteacher")) {%>
					<%-- <jsp:include page="./admin/delteacher.jsp"></jsp:include> --%>
					删除老师
				<%} %>
				
				<%if(request.getParameter("op").equals("systeminfo")) {%>
					<jsp:include page="./admin/systeminfo.jsp"></jsp:include> 
				<%} %>
				
				<%if(request.getParameter("op").equals("systemlog")) {%>
					<jsp:include page="./admin/systemlog.jsp"></jsp:include> 
				<%} %>
				
				<%if(request.getParameter("op").equals("changeinfo")) {%>
					<jsp:include page="./admin/changeinfo.jsp"></jsp:include> 
				<%} %>
				
				<%if(request.getParameter("op").equals("systemsetting")) {%>
					<jsp:include page="./admin/systemsetting.jsp"></jsp:include> 
				<%} %>
				<%if(request.getParameter("op").equals("addsubject")) {%>
					<jsp:include page="./admin/addsubject.jsp"></jsp:include> 
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
	
	$('#info').on('click', function(){
	    layer.open({
	        type: 2,
	        title: '个人信息',
	        maxmin: true,
	        shadeClose: true, //点击遮罩关闭层
	        area : ['800px' , '520px'],
	        content: 'jsp/admin/changeinfo.jsp',
	        end: function () {
                location.reload();
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);
            }
	      });
	    });
	$('#addadmin').on('click', function(){
	    layer.open({
	        type: 2,
	        title: '增加管理员',
	        maxmin: true,
	        shadeClose: true, //点击遮罩关闭层
	        area : ['800px' , '520px'],
	        closeBtn: 1,
	        content: 'jsp/admin/addadmin.jsp',
	        
	      });
	    });
	
		layer.closeAll(); 
</script>
<jsp:include page="./common/footer.jsp"></jsp:include>
