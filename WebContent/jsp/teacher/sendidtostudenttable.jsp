
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%	
 	Map<String,String> map = new HashMap<String,String>();
 	if ( session.getAttribute("exam")!=null ) {
       	map = (Map<String,String>)session.getAttribute("exam");
	}
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

<!--获取请求参数  -->
<form class="layui-form" action="studenttable" method="post">
	<div class="layui-form-item">
		<label class="layui-form-label">考试ID</label>
		<div class="layui-input-block">
			<select name="examid" lay-verify="required">
				<option value=""></option>
				<%
					for(Map.Entry<String,String> entry : map.entrySet()){
						String id = entry.getKey();
						String name = entry.getValue();
				 %>
				 	<option value="<%=id%>"><%=name%></option>
				 <%
				 	}
				 %>
			</select>
		</div>
	</div>
	<div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit lay-filter="*">立即查询</button>
    </div>
    <!--去服务器查询考试信息在下面进行显示-->
  </div>
</form>
<script src="jsp/lib/layui/layui.js"></script>
<script>
//Demo
layui.use('form', function(){
  var form = layui.form; 
});

</script>
