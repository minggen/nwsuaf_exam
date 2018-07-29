<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../common/meta.jsp"></jsp:include> 
<jsp:include page="../common/linkcss.jsp"></jsp:include> 
<div class="panel panel-default">
	<div class="panel-header">新增教师</div>
	<div class="panel-body">
	<form class="layui-form" action="teacherAdd" method="post">		
	
		<div class="layui-form-item">
			<label class="layui-form-label">教师姓名</label>
			<div class="layui-input-block">
				<input type="text" name="user_name"  lay-verify="required"
					placeholder="教师姓名" autocomplete="off" class="layui-input">
			</div>
		</div>
	
		<div class="layui-form-item">
			<label class="layui-form-label">教师密码</label>
			<div class="layui-input-block">
				<input type="text" name="user_password"  lay-verify="required"
					placeholder="请输入密码" autocomplete="off" class="layui-input">
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">性别</label>
			<div class="layui-input-block">
				<select name="user_sex"  lay-verify="required">			
					<option value="男">男</option>
					<option value="女">女</option>
				</select>
			</div>
		</div>
		
		
		<div class="layui-form-item">
			<label class="layui-form-label">教师电话</label>
			<div class="layui-input-block">
				<input type="text" name="user_telephone"  lay-verify="required|phone"
					placeholder="教师电话" autocomplete="off" class="layui-input">
			</div>
		</div>
		
		
		<div class="layui-form-item">
			<label class="layui-form-label">教师邮箱</label>
			<div class="layui-input-block">
				<input type="text" name="user_email"  lay-verify="email"
					placeholder="教师邮箱" autocomplete="off" class="layui-input">
			</div>
		</div>
		
		<div class="layui-form-item">
		<div class="layui-input-block">
			<button class="layui-btn"  lay-filter="formDemo" lay-submit="">立即提交</button>
			<button type="reset" class="layui-btn layui-btn-primary">重置</button>
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
