<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<script src="jsp/lib/layui/layui.js"></script>

<form class="layui-form" action="newExam" method="post">
	<div class="layui-form-item">
		<label class="layui-form-label">考试名称</label>
		<div class="layui-input-block">
			<input type="text" name="examname" id="examname"  required lay-verify="required"
				placeholder="请输入考试名称" autocomplete="off" class="layui-input">
		</div>
	</div>
	
	<div class="layui-form-item">
		<label class="layui-form-label">考试科目</label>
		<div class="layui-input-block">
			<select name="examsubject"  required  lay-verify="required">
					<option value=""></option>
		
					<%
					ArrayList<String> list = (ArrayList)application.getAttribute("examSubject");
					if(list!=null)
					for(int i=0;i<list.size();i++) {%>
					 <option value="<%=list.get(i)%>"><%=list.get(i)%></option>
					
					<%} %>
					
					
			</select>
		</div>
	</div>
	


	<div class="layui-form-item">
		<label class="layui-form-label">开考时间</label>
		<div class="layui-input-block">
			<input type="text" class="layui-input" name="begintime" lay-verify="required" id="begintime" placeholder="点击选择开考时间">
			
		</div>
	</div>
	
	<div class="layui-form-item">
		<label class="layui-form-label">考试时长</label>
		<div class="layui-input-block">
			<input type="text" class="layui-input" name="begintoendtime" lay-verify="required" id="begintoendtime" placeholder="点击选择考试时长">
		</div>
	</div>
	
	<div class="layui-form-item">
		<label class="layui-form-label">单选题个数</label>
		<div class="layui-input-block">
			<input type="text" name="xzt_count"  lay-verify="number" class="layui-input" placeholder="请输入单选题个数">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">单选题分值</label>
		<div class="layui-input-block">
			<input type="text" name="xzt_score"   lay-verify="number"
				placeholder="请输入每个单选题分值" autocomplete="off" class="layui-input">
		</div>
	</div>

	<div class="layui-form-item">
		<label class="layui-form-label">多选题个数</label>
		<div class="layui-input-block">
			<input type="text" name="dxt_count"  lay-verify="number" class="layui-input" placeholder="请输入多选题个数">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">多选题分值</label>
		<div class="layui-input-block">
			<input type="text" name="dxt_score"   lay-verify="number"
				placeholder="请输入每个多选题分值" autocomplete="off" class="layui-input">
		</div>
	</div>
		
	<div class="layui-form-item">
		<label class="layui-form-label">判断题个数</label>
		<div class="layui-input-block">
			<input type="text" name="tof_count"  lay-verify="number" class="layui-input" placeholder="请输入判断题个数">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">判断题分值</label>
		<div class="layui-input-block">
			<input type="text" name="tof_score"  lay-verify="number"
				placeholder="请输入每个判断题分值" autocomplete="off" class="layui-input">
		</div>
	</div>
	
	<div class="layui-form-item">
		<div class="layui-input-block">
			<button class="layui-btn"  lay-filter="formDemo" lay-submit="">立即提交</button>
			<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		</div>
	</div>
</form>
<script>
layui.use('form', function(){
  var form = layui.form;
  
  //监听提交
  form.on('submit(formDemo)', function(data){
  //  layer.msg(JSON.stringify(data.field));
    return true;
  });
});
layui.use('laydate', function(){
	  var laydate = layui.laydate; 
	  //执行一个laydate实例
	  laydate.render({
	    elem: '#begintime' //指定元素
	    ,type:'datetime'
	    ,format: 'yyyy年MM月dd日 HH时mm分ss秒' //可任意组合
	  });
	  laydate.render({
		    elem: '#begintoendtime' //指定元素
		    ,type:'time'
		    ,format: 'HH时mm分ss秒' //可任意组合
		  });
	});


</script>