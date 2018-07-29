<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script src="jsp/lib/layui/layui.js"></script>

<div class="layui-tab">
  <ul class="layui-tab-title">
    <li class="layui-this">新增选择题</li>
    <li>新增多选题</li>
    <li>新增判断题</li>
  </ul>
  <div class="layui-tab-content">
    <div class="layui-tab-item layui-show">
			<jsp:include page="add_one_radio.jsp"></jsp:include>
	</div>
	
    <div class="layui-tab-item">
		<jsp:include page="add_one_checkbox.jsp"></jsp:include>
	</div>
    <div class="layui-tab-item">
    	<jsp:include page="trueorfalse.jsp"></jsp:include>
    </div>
  </div>
</div>
 
<script>
//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
  var element = layui.element;
  
  //…
});
</script>


<script>
//一般直接写在一个js文件中
layui.use(['layer', 'form'], function(){
  var layer = layui.layer
  ,form = layui.form;
  
  layer.msg('增加题目');
});
</script> 