<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.utils.*"%>
<%@page import="java.util.Properties" %>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css" />
<style>
</style>
<%! MonitorServiceImpl sysinfo =new MonitorServiceImpl(); 	%>
<% MonitorInfoBean bean = sysinfo.getMonitorInfoBean();
				Properties props = System.getProperties();
				Runtime r = Runtime.getRuntime();
			%>
<div style="margin-left: 40px; margin-right: 50px;">

	<div class="panel panel-success  mt-20">
		<div class="panel-header">系统情况</div>
		<div class="panel-body">
			<div>
				<p style="font-size: 16px;">
					系统：<span id="info"><%=bean.getOsName() %></span> &nbsp; 已不间断运行: <span
						id="running">6天22小时58分钟</span>
					<button onclick="ReBoot()" class="btn btn-success btn-xs"
						style="vertical-align: 1px; margin-left: 10px;">重启服务器</button>
					<button onclick="reWeb()" style="vertical-align: 1px;"
						class="btn btn-success btn-xs">关闭服务器</button>
				</p>
			</div>

		</div>
		<style>
.siteinfo-box {
	float: left;
	width: 350px;
	height: 150px;
	margin-right:100px;
	border-bottom: 1px solid #ddd;
	border-right: 1px solid #ddd;
	border-top: 1px solid #ddd;
}

.siteinfo-box-left {
	width: 30%;
	height: 100%;
	float: left;
	background: #19a97b;
	display: table;
}

.siteinfo-box-right {
	width: 70%;
	height: 100%;
	float: left;
	display: table;
}

.siteinfo-box-left-text {
	display: table-cell;
	vertical-align: middle;
	text-align: center;
	width: 100%;
}
</style>


		<hr size="12" style="height: 3px;">
		<div class="panel-body">
			<div style="width:1000px; height: 100px;">
				<div class="siteinfo-box box-shadow1">
					<div class="siteinfo-box-left">
						<div class="siteinfo-box-left-text">管理员</div>
					</div>

					<div class="siteinfo-box-right">
						<div class="siteinfo-box-left-text">
							<div>1个</div>
							<br>
							<div>
								<a class="btn" href="javascript:;" id="addadmin">添加</a>&nbsp;<a class="btn " href="javascript:;" id="delteadmin">删除</a>
							</div>
						</div>
					</div>


				</div>
				<div class="siteinfo-box box-shadow2" >
					<div class="siteinfo-box-left">
						<div class="siteinfo-box-left-text">教师</div>
					</div>
					<div class="siteinfo-box-right">
						<div class="siteinfo-box-left-text">
							<div>1个</div>
							<br>
							<div>
								<a class="btn ">添加</a>&nbsp;<a class="btn ">删除</a>
							</div>
						</div>
					</div>
				</div>
				
			</div>
			<br>
			<br>
			<br>
			<br>
		</div>

	</div>

	<br>
	
	<div class="panel panel-success  mt-20">
		<div class="panel-header">系统情况</div>
		<div class="panel-body">

			<table class="table table-hover table-bordered table-striped ">
			<!-- <tr>
				<th colspan="5" class="center f20 fw700">考试列表</th>
			</tr> -->
			
			<tr>
				<td class="col-2">操作系统</td>
				<td class="col-2"><%=bean.getOsName() %></td>
				
				<td class="col-2">cpu使用率</td>
				<td class="col-2"><%=bean.getCpuRatio()+"%" %></td>
		 	</tr>
			
			
			<tr>
				<td class="col-2">可使用内存</td>
				<td class="col-2"><%=bean.getTotalMemory()/ 1024L +"M" %></td>
				
				<td class="col-2">剩余内存</td>
				<td class="col-2"><%=bean.getFreeMemory()/ 1024L  +"M" %></td>
		 	</tr>
			
			<tr>
				<td class="col-2">最大可使用内存</td>
				<td class="col-2"><%=bean.getTotalMemory()/ 1024L +"M" %></td>
				
				<td class="col-2">剩余内存</td>
				<td class="col-2"><%=bean.getMaxMemory()/ 1024L  +"M" %></td>
		 	</tr>
		 	
		 	<tr>
				<td class="col-2">总的物理内存</td>
				<td class="col-2"><%=bean.getTotalMemorySize()/ 1024L +"M" %></td>
				
				<td class="col-2">剩余内存</td>
				<td class="col-2"><%=bean.getMaxMemory()/ 1024L  +"M" %></td>
		 	</tr>
		 	
		 	<tr>
				<td class="col-2">剩余的物理内存</td>
				<td class="col-2"><%=bean.getFreePhysicalMemorySize()/ 1024L +"M"%></td>
				
				<td class="col-2">剩余内存</td>
				<td class="col-2"><%=bean.getMaxMemory()/ 1024L  +"M" %></td>
		 	</tr>
		 	<tr>
				<td class="col-2">已使用的物理内存</td>
				<td class="col-2"><%=bean.getUsedMemory()/ 1024L  +"M" %></td>
				
				<td class="col-2">线程总数</td>
				<td class="col-2"><%=bean.getTotalThread() %></td>
		 	</tr>
		 	
		 	<tr>
				<td class="col-2">JVM可以使用的总内存</td>
				<td class="col-2"><%=r.totalMemory()/ 1024L  +"M" %></td>
				
				<td class="col-2">JVM可以使用的剩余内存</td>
				<td class="col-2"><%= r.freeMemory()/ 1024L  +"M" %></td>
			</tr>
			
			<tr>
				<td class="col-2">JVM可以使用的处理器个数</td>
				<td class="col-2"><%=r.availableProcessors() %></td>
				
				<td class="col-2">Java的运行环境版本</td>
				<td class="col-2"><%= props.getProperty("java.version") %></td>
			</tr>
			
			
			</table>

		</div>
	</div>
</div>




<!-- </section> -->
<script type="text/javascript">
$(".box-shadow2").mouseover(function(){	
	$(".box-shadow2").css("boxShadow","7px -6px 12px #FFD9E2");
	/*{"border-bottom":"1px solid #d00","border-right": "1px solid #ddd","border-top": "1px solid #ddd"}*/
});
$(".box-shadow2").mouseleave(function(){	
	$(".box-shadow2").css("boxShadow","0px 0px 0px #FFF2F6");
	/*{"border-bottom":"1px solid #d00","border-right": "1px solid #ddd","border-top": "1px solid #ddd"}*/
});
$(".box-shadow1").mouseover(function(){	
	$(".box-shadow1").css("boxShadow","7px -6px 12px #EDFFF5");
	/*{"border-bottom":"1px solid #d00","border-right": "1px solid #ddd","border-top": "1px solid #ddd"}*/
});
$(".box-shadow1").mouseleave(function(){	
	$(".box-shadow1").css("boxShadow","0px 0px 0px #FFF2F6");
	/*{"border-bottom":"1px solid #d00","border-right": "1px solid #ddd","border-top": "1px solid #ddd"}*/
});
</script>




