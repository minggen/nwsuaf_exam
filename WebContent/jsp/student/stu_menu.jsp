<%@page import="com.utils.GetStringNum"%>
<%@page import="com.entity.ExamInformation"%>
<%@page import="com.entity.ExamRecord"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ExamRecord record = (ExamRecord)session.getAttribute("student");
	ExamInformation examInformation = (ExamInformation)session.getAttribute("examInformation");
	String examId = record.getExamId();
	String userNo = record.getStudentNo();
	String userName = record.getStudentName();
	String subject = examInformation.getSubjectName();
	String beginTime = examInformation.getExamBeginTime();
	String examTime = examInformation.getExamTime();
 %>
<script src="jsp/lib/layui/layui.js"></script>

<aside class="Hui-aside">
	<div class="panel panel-default" style="text-align: center;">
			<div class="panel-header">考试场次</div>
						<%=examId %>
			<div class="panel-header">准考证号</div>
					<%=userNo %>
			<div class="panel-header">考生姓名</div>
					<%=userName %>
			<div class="panel-header">考试科目</div>
					<%=subject %>
			<div class="panel-header">考试时间</div>
					开始时间：<%=beginTime %>
			<div class="panel-header">试题总分:100</div>					
	</div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" id="hiddenorplay" href="javascript:;" onClick="displaynavbar(this)"></a></div>

 
 




<script>
layui.use(['util', 'laydate', 'layer'], function(){
  var util = layui.util
  ,laydate = layui.laydate
  ,layer = layui.layer;
});
</script>


