<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%	
 	Map<String,String> map = new HashMap<String,String>();
 	if ( session.getAttribute("exam")!=null ) {
       	map = (Map<String,String>)session.getAttribute("exam");
	}
%>
<div>
	<form class="layui-form" action="importstudent" method="post">
		
		<div class="layui-form-item">
			<label class="layui-form-label">考试场次</label>
			<div class="layui-input-block">
				<select name="examid" lay-verify="required">
					<option value="">请选择考试场次</option>
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
		
		
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">学生账号</label>
			<div class="layui-input-block">
				<input type="text" name="sno" required lay-verify="required"
					placeholder="学生账号" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">学生姓名</label>
			<div class="layui-input-block">
				<input type="text" name="sname" required lay-verify="required"
					placeholder="学生姓名" autocomplete="off" class="layui-input">
			</div>
		</div>
		 <div class="layui-form-item">
			<label class="layui-form-label">学生密码</label>
			<div class="layui-input-block">
				<input type="text" name="spassword" required lay-verify="required"
					placeholder="学生密码" autocomplete="off" class="layui-input">
			</div>
		</div>
		
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="formDemo">立即导入</button>
				<button type="reset" class="layui-btn layui-btn-primary">取消重置</button>
			</div>
		</div>
	</form>
</div>

<script src="jsp/lib/layui/layui.js"></script>
<script>
layui.use('form');
</script>