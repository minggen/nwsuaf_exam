<%@page import="com.entity.ExamTofChoice"%>
<%@page import="com.entity.ExamSingleChoice"%>
<%@page import="com.entity.ExamMultiChoice"%>
<%@page import="com.entity.ExamInformation,java.util.List"%>
<%@page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ExamInformation examInformation = (ExamInformation)session.getAttribute("examInformation");
	String[] choiceList = ((ExamInformation)session.getAttribute("examInformation")).getExamChoice().split(";");
	List<String> mulList = (List<String>)session.getAttribute("mulList");
	List<String> singleList = (List<String>)session.getAttribute("singleList");
	List<String> tofList = (List<String>)session.getAttribute("tofList");
%>

<style>
.test {
	display: inline-block;
	margin-left: 8px;
	padding-left: 4px;
	padding-bottom: 4px;
	margin-top: 6px;
	width: 20px;
	height: 20px;
	border: 1px solid #000;
}

.f20 {
	font-size: 20px;
}

.f16 {
	font-size: 16px;
}
</style>
<script src="jsp/lib/layui/layui.js"></script>
<div class="layui-container">
	<form class="layui-col-md9 layui-form" action="showAnswer"
		method="post">

		<div class="panel panel-default">
			<%
				String[] singleChoice = choiceList[0].split(",");
			 %>
			<div class="panel-header f20">一、选择题&nbsp&nbsp共<%=singleChoice[0] %>道题&nbsp&nbsp每道题<%=singleChoice[1] %>分</div>
			<div class="panel-body">
				<%
					int i=0;
					for(String strSingle:singleList) {
						i++;
						String[] str = strSingle.split("@#");
				%>
				<div class="layui-form-item" id="xztt_<%=i%>">
					<p class="f16"><%=i%>、<%=str[1] %>
					</p>
					<div class="layui-input-block" style="margin-left: 20px;">
						<input 
							type="radio" id="xzt_<%=i%>" name="xzt_<%=i%>" lay-filter="radio"
							value="A" title="A、<%=str[2]%>"> <br> 
						<input
							type="radio" id="xzt_<%=i%>" name="xzt_<%=i%>" lay-filter="radio"
							value="B" title="B、<%=str[3]%>"> <br> 
						<input
							type="radio" id="xzt_<%=i%>" name="xzt_<%=i%>" lay-filter="radio"
							value="C" title="C、<%=str[4]%>"> <br> 
						<input
							type="radio" id="xzt_<%=i%>" name="xzt_<%=i%>" lay-filter="radio"
							value="D" title="D、<%=str[5]%>">
					</div>
				</div>
				<%
					}
				%>
			</div>
		</div>

		<div class="panel panel-default ">
			<%
				String[] multiChoice = choiceList[1].split(",");
			 %>
			<div class="panel-header f20">二、多选题&nbsp&nbsp共<%=multiChoice[0] %>道题&nbsp&nbsp每道题<%=multiChoice[1] %>分</div>
			<div class="panel-body">
				<%
					i=0;
					for(String strMulti:mulList) {
						i++;
						String[] str = strMulti.split("@#");
				%>
				<div style="margin-top: 6px;" id="dxtt_<%=i%>">
					<p class="f16"><%=i%>、<%=str[1]%>
					</p>
					<div style="margin-left: 20px;">
						<p style="padding-top: 6px;">
							<input type="checkbox" lay-filter="dxtchackbox" name="dxt_<%=i%>"
								value="A"> <label for="checkbox-1">A、<%=str[2]%></label>
						</p>
						<p style="padding-top: 6px;">
							<input type="checkbox" lay-filter="dxtchackbox" name="dxt_<%=i%>"
								value="B"> <label for="checkbox-1">B、<%=str[3]%></label>
						</p>
						<p style="padding-top: 6px;">
							<input type="checkbox" lay-filter="dxtchackbox" name="dxt_<%=i%>"
								value="C"> <label for="checkbox-1">C、<%=str[4]%></label>
						</p>
						<p style="padding-top: 6px;">
							<input type="checkbox" lay-filter="dxtchackbox" name="dxt_<%=i%>"
								value="D"> <label for="checkbox-1">D、<%=str[5]%></label>
						</p>
						<p style="padding-top: 6px;">
							<input type="checkbox" lay-filter="dxtchackbox" name="dxt_<%=i%>"
								value="E"> <label for="checkbox-1">E、<%=str[6]%></label>
						</p>
					</div>
				</div>

				<%
					}
				%>
			</div>
		</div>


		<div class="panel panel-default">
			<%
				String[] tofChoice = choiceList[2].split(",");
			 %>
			<div class="panel-header f20">三、判断题&nbsp&nbsp共<%=tofChoice[0] %>道题&nbsp&nbsp每道题<%=tofChoice[1] %>分</div>
			<div class="panel-body">
				<%
					i=0;
					for(String strTof:tofList) {
						i++;
						String[] str = strTof.split("@#");
				%>
				<div style="margin-top: 6px;" id="pdtt_<%=i%>">
					<span><%=i%>、<%=str[1]%></span>
					<span style="margin-left: 50px;"> 
						<input type="radio" name="pdt_<%=i%>" value="A" lay-filter="pdtinput" title=" ">
						<i class="layui-icon" style="margin-left: -30px;">&#xe618;</i>&nbsp;
						<input type="radio" name="pdt_<%=i%>" value="B" lay-filter="pdtinput" title=" "> 
						<i class="layui-icon" style="margin-left: -30px;">&#x1006;</i>
					</span>
				</div>

				<%
					}
				%>
			</div>
		</div>

		<div class="layui-form-item" style="margin-top: 50px;">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="examDemo">立即提交</button>

			</div>
		</div>
		<div class="modal fade" id="queren" tabindex="-1" role="dialog">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="mytitle">警告</h4>
					</div>
					<div class="modal-body">
						<p id="mywarningtext">rr</p>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">确认提交</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭，继续答题</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->

	</form>



	<div class="panel panel-default "
		style="width: 280px; margin-right: 0px; padding-right: 0px; position: fixed; right: 40px; margin-top: 0px;">
		<div class="panel-header">倒计时</div>

		<div style="padding-top: 10px; padding-bottom: 10px; text-align: c">

			<div id="timer" class="countdown"></div>

			<style>
.countdown {
	text-align: center;
	color: #19a97b;
	font-size: 30px;
}
</style>
		</div>

		<div class="panel-header">一、选择题</div>

		<div style="padding-top: 10px; padding-bottom: 10px;">


			<%
				for (i = 1; i <= singleList.size(); i++) {
			%>

			<span class="test xzt_<%=i%>"><a href="javascript:void(0)"
				onclick="document.getElementById('xztt_<%=i%>').scrollIntoView();"
				calss="layui-btn  layui-btn-primary "><%=i%></a></span>
			<%
				}
			%>


		</div>

		<div class="panel-header">二、多选题</div>

		<div style="padding-top: 10px; padding-bottom: 10px;">


			<%
				for (i = 1; i <= mulList.size(); i++) {
			%>

			<span class="test dxt_<%=i%>"><a href="javascript:void(0)"
				onclick="document.getElementById('dxtt_<%=i%>').scrollIntoView();"
				calss="layui-btn  layui-btn-primary "><%=i%></a></span>
			<%
				}
			%>


		</div>



		<div class="panel-header">三、判断题</div>

		<div style="padding-top: 10px; padding-bottom: 10px;">


			<%
				for (i = 1; i <= tofList.size(); i++) {
			%>

			<span class="test pdt_<%=i%>"><a href="javascript:void(0)"
				onclick="document.getElementById('pdtt_<%=i%>').scrollIntoView();"
				calss="layui-btn  layui-btn-primary "><%=i%></a></span>
			<%
				}
			%>



		</div>

	</div>
</div>


<script>
	layui.use('form', function() {
		var form = layui.form;
		form.on('radio(radio)', function(data) {
			var str = data.elem.name;
			$("." + str).css("background-color", "#19a97b");
			console.log(data.elem.id); //得到radio原始DOM对象
			console.log(data.value); //被点击的radio的value值

		});

		form.on('checkbox(dxtchackbox)', function(data) {
			var str = data.elem.name;
			if(this.checked){
				$("." + str).css("background-color", "#19a97b");
			}
			else{
				var count=0;
				$("input[name='"+str+"']").each(function(){
					if(this.checked){count+=1;}
				})
				if(count==0)
				$("." + str).css("background-color", "#ffffff");	
			}
		});


		form.on('radio(pdtinput)', function(data) {
			var str = data.elem.name;
			$("." + str).css("background-color", "#19a97b");

			console.log(data.elem.id); //得到radio原始DOM对象
			console.log(data.value); //被点击的radio的value值

		});
		form.on('submit(examDemo)', function(data) {
			//layer.msg(JSON.stringify(data.field));
			console.log(getJsonLength(data.field));
			var length = getJsonLength(data.field);
			if(length<count){
				$("#mywarningtext").text("总共有"+count+"道题目,你还剩"+(count-length)+"道没有完成");
				$('#queren').modal("show");
			}
			if(length>=count){
				$("#mywarningtext").text("你已经完成了所有题目");
				$('#queren').modal("show");
			}
			
			/*else
			{
				`	
			}*/
			return false;
		});

	});

	function getJsonLength(jsonData) {
		var jsonLength = 0;
		for ( var item in jsonData) {
			jsonLength++;
		}
		return jsonLength;
	}
	
	var count=<%=mulList.size()+singleList.size()+tofList.size()%>;
	var interval = 1000;
	
	<%
		Date begin = (Date)session.getAttribute("exambegintime");
		Date now =new Date();
		long diedtime=0;
		
		if(begin!=null){
			diedtime = now.getTime() - begin.getTime();
			diedtime /=1000;
		}
		String  str=examInformation.getExamTime();
		int hour = Integer.valueOf(str.substring(0,2));
		int min =  Integer.valueOf(str.substring(3, 5));
		int second = Integer.valueOf(str.substring(6,8));
		
		int leftsecond = hour*3600+min*60+second-(int)diedtime+20;
		
		System.out.println(hour+","+min+","+second+","+leftsecond);
		
	%>
	var leftsecond = <%=leftsecond%>; 
	function ShowCountDown(divname) {
		leftsecond = leftsecond - 1;

		var hour = Math.floor((leftsecond) / 3600);
		var minute = Math.floor((leftsecond - hour * 3600) / 60);
		var second = Math.floor(leftsecond - hour * 3600 - minute * 60);
		var cc = document.getElementById(divname);
		cc.innerHTML = (hour < 10 ? "0" + hour : hour) + ":"
				+ (minute < 10 ? "0" + minute : minute) + ":"
				+ (second < 10 ? "0" + second : second);
	}
	window.setInterval(function() {
		ShowCountDown('timer');
	}, interval);
</script>
