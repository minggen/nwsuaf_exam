<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../common/meta.jsp"></jsp:include> 
<jsp:include page="../common/linkcss.jsp"></jsp:include> 
<div class="panel panel-default">
	<div class="panel-header">新增教师</div>
	<div class="panel-body">
	<form class="layui-form" action="subjectAdd" method="post">		
	
		<div class="layui-form-item">
			<label class="layui-form-label">科目姓名</label>
			<div class="layui-input-block">
				<input type="text" name="subjectName"  lay-verify="required"
					placeholder="科目名称" autocomplete="off" class="layui-input">
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
layui.use('form');
</script>
