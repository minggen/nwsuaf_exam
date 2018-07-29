<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%	
 	Map<String,String> map = new HashMap<String,String>();
 	if ( session.getAttribute("exam")!=null ) {
       	map = (Map<String,String>)session.getAttribute("exam");
	}
%>
<div>
	<form class="layui-form" action="importstudents" enctype="multipart/form-data" method="post">
		<h1 style="margin-left: 20px;">导入学生信息</h1>
		<div class="tm_batch_help"
			style="margin-left: 20px; margin-top: 20px;">
			<div>
				<img src="jsp/images/point_yellow.png" />
				使用Excel做为模板文件，请注意格式要求，并且文件编码必须为UTF8。
			</div>
			<div>
				<img src="jsp/images/point_green.png" /> <a
					href="files/学生导入模板.zip" target="_blank"><strong>下载Excel格式模板</strong></a>
				请下载模板，并按照格式填写，填写完成后，上传文件即可完成导入。
			</div>

	


		</div>
		<div class="layui-form-item" style="margin-top: 20px;">
			<label class="layui-form-label">考试场次</label>
			<div class="layui-input-block">
				<select name="city">
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
			<label class="layui-form-label">选择文件</label>
			<div class="layui-input-block">
				<!-- <button type="button" class="layui-btn" id="test1">
					<i class="layui-icon">&#xe67c;</i>上传文件
				</button> -->
				<span class="btn-upload form-group"> <input
						class="input-text upload-url radius " type="text"
						name="file1" id="file1" readonly><a
						href="javascript:void();" class="layui-btn"><i
							class="layui-icon">&#xe7a0;</i>浏览文件</a> 
							
							<input type="file" multiple
						name="myFile" class="input-file size-L">
					</span>
			</div>
		</div>


		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="formDemo">立即导入</button>
				<button type="reset" class="layui-btn layui-btn-primary">取消重置</button>
			</div>
		</div>
	</form>
	<!-- <form action="importstudents" method="post" enctype="multipart/form-data" >
      <label for="myFile">Upload your file</label>
      <input type="file" name="myFile" />
      <input type="submit" value="Upload"/>
   </form> -->
   
</div>

<script src="jsp/lib/layui/layui.js"></script>
<script>
	layui.use('form');
</script>