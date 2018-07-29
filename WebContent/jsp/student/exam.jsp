<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

 %>
<!-- meat
	meta信息
 -->
<jsp:include page="../common/meta.jsp"></jsp:include>
<!-- end meat -->

<!-- 
导入页面公共css
 -->
<jsp:include page="../common/linkcss.jsp"></jsp:include>
<!-- 
单个页面所用css放在这下面
 -->
<title>学生</title>
</head>


<body>

<!-- 
	nav
 -->
<jsp:include page="./stu_nav.jsp"></jsp:include>
<!-- 
	引入考试信息栏目
 -->
 <jsp:include page="./stu_menu.jsp"></jsp:include>	
 

<section class="Hui-article-box">
	<div class="Hui-article">
		<article class="cl pd-20">
			<jsp:include page="./stu_questions.jsp"></jsp:include>
			
		</article>
	</div>
</section>


<jsp:include page="../common/importjs.jsp"></jsp:include>

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

<jsp:include page="../common/footer.jsp"></jsp:include>
    