<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%	
 	List<String> list = new ArrayList<String>();
 	if ( application.getAttribute("examSubject")!=null ) {
       	list = (List<String>)application.getAttribute("examSubject");
	}	
%>
<div>
	<form class="layui-form" action="trueorfalse" method="post">
		
		<div class="layui-form-item">
			<label class="layui-form-label">所属科目</label>
			<div class="layui-input-block">
				<select name="subjectName" lay-verify="required">
					<option value=""></option>
					<%
						for(int i = 0; i< list.size() ;i++ ){
							String value = (String)list.get(i);
					 %>
					 <option value="<%=value%>"><%=value%></option>
					 <%
					 	}
					 %>
				</select>
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">是否共享</label>
			<div class="layui-input-block">
				<input type="checkbox" name="isShare" lay-skin="switch">
			</div>
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">题目描述</label>
			<div class="layui-input-block">
				<textarea name="question" placeholder="请输入内容" lay-verify="required" class="layui-textarea"></textarea>
			</div>
		</div>
		

		<div class="layui-form-item">
			<label class="layui-form-label">题目答案</label>
			<div class="layui-input-block">
				<select name="answerCorrect" lay-verify="required">
					<option value=""></option>
					<option value="A">正确</option>
					<option value="B">错误</option>
				</select>
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">答案解析</label>
			<div class="layui-input-block">
				<input type="text" name="analysis" required lay-verify="required"
					placeholder="请输入答案解析" autocomplete="off" class="layui-input">
			</div>
		</div>
		
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
</div>