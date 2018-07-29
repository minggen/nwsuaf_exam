<%@page import="com.entity.ExamUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	ExamUser user = (ExamUser)session.getAttribute("admin");
%>

<jsp:include page="../common/meta.jsp"></jsp:include> 
<jsp:include page="../common/linkcss.jsp"></jsp:include> 

<div class="panel panel-default">
	<div class="panel-header">修改个人信息</div>
	<div class="panel-body">
	<form class="layui-form" action="change_setInfo" method="post">

		 <div class="layui-form-item">
			<label class="layui-form-label">ID</label>
			<div class="layui-input-block">
				<input type="text" name="user_id"  value="<%=user.getUserId() %>"
					 class="layui-input " disabled="disabled">
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">密码</label>
			<div class="layui-input-block">
				<input type="password" name="user_password" 
					placeholder="如果要修改，请输入新密码" autocomplete="off" class="layui-input">
			</div>
		</div>
		
		
		<div class="layui-form-item">
			<label class="layui-form-label">姓名</label>
			<div class="layui-input-block">
				<input type="text" name="user_name" 
					placeholder="<%=user.getUserName() %>" autocomplete="off" class="layui-input">
			</div>
		</div>
		
	<%-- 	<div class="layui-form-item">
			<label class="layui-form-label">/label>
			<div class="layui-input-block">
				<input type="text" name="user_sex" lay-verify="sex"
					placeholder="<%=user.getUserSex() %>" autocomplete="off" class="layui-input">
			
 
 			</div>
 			
		</div> --%>
		<div class="layui-form-item">
			<label class="layui-form-label">性别</label>
			<div class="layui-input-block">
				<select name="user_sex"  >
				<%-- <%if(user.getUserName().equals("男")){ %> --%>
					<option value="男">男</option>
					<option value="女">女</option>
					<%-- <%}else{ %>
					<option value="女">女</option>
					<option value="男">男</option>
					<%} %> --%>
				</select>
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">电话</label>
			<div class="layui-input-block">
				<input type="text" name="user_telephone" lay-verify="phone"
					placeholder="<%=user.getUserTelephone() %>" autocomplete="off" class="layui-input">
			</div>
		</div>
		
		
		<div class="layui-form-item">
			<label class="layui-form-label">邮箱</label>
			<div class="layui-input-block">
				<input type="text" name="user_email" lay-verify="required|email"
					placeholder="<%=user.getUserEmail() %>" autocomplete="off" class="layui-input">
			</div>
		</div>
		
		<div class="layui-form-item">
		<div class="layui-input-block">
			<button class="layui-btn"  lay-filter="formDemo" lay-submit >修改</button>
		</div>
	</div>
	</form>
</div>
</div>

<script src="jsp/lib/layui/layui.js"></script>
<script>
layui.use('form',function(){
	var form = layui.form;
	form.verify({
		 sex: ['男'|'女', '密码必须6到12位']
	  });
	
		  
});
</script>
