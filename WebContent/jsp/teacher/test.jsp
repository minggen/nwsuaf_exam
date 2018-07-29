<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="jsp/lib/layui/layui.js"></script>

<div class="layui-tab">
	<ul class="layui-tab-title">
		<li class="layui-this">新增选择题</li>
		<li>新增多选题</li>
		<li>新增判断题</li>
	</ul>
	<div class="layui-tab-content" style="margin-left: 50px;margin-top: 30px;">
		<div class="layui-tab-item layui-show">

			<h2>用Excel方式导入选择题</h2>
			<div class="tm_batch_help"
				style="margin-left: 20px; margin-top: 20px;">
				<div>
					<img src="jsp/images/point_yellow.png" />
					使用Excel做为模板文件，请注意格式要求，并且文件编码必须为UTF8。
				</div>
				<div>
					<img src="jsp/images/point_green.png" /> <a
						href="files/template_questions_excel.zip" target="_blank"><strong>点击下载Excel格式模板</strong></a>
					请下载模板，并按照格式填写，填写完成后，上传文件即可完成导入。
				</div>
				<br>


				<form action="" method="post" id="form_txt_import">
						<span class="btn-upload form-group"> <input
						class="input-text upload-url radius " type="text"
						name="uploadfile-1" id="uploadfile-1" readonly><a
						href="javascript:void();" class="layui-btn"><i
							class="layui-icon">&#xe7a0;</i>浏览文件</a> <input type="file" multiple
						name="file-1" class="input-file size-L">
					</span> <br> <br>

					<div>
						<button type="submit" class="layui-btn" id="test1">
							<i class="layui-icon">&#xe67c;</i>上传文件
						</button>


						<button type="reset" class="layui-btn" id="test1">
							<i class="layui-icon">&#xe609;</i> 取消选择
						</button>
					</div>
				</form>
			</div>

		</div>

		<div class="layui-tab-item">
			<h2>用Excel方式导入多选题</h2>
			<div class="tm_batch_help"
				style="margin-left: 20px; margin-top: 20px;">
				<div>
					<img src="jsp/images/point_yellow.png" />
					使用Excel做为模板文件，请注意格式要求，并且文件编码必须为UTF8。
				</div>
				<div>
					<img src="jsp/images/point_green.png" /> <a
						href="files/template_questions_excel.zip" target="_blank"><strong>点击下载Excel格式模板</strong></a>
					请下载模板，并按照格式填写，填写完成后，上传文件即可完成导入。
				</div>
				<br>
				<form action="" method="post" id="form_txt_import">
					<span class="btn-upload form-group"> <input
						class="input-text upload-url radius " type="text"
						name="uploadfile-1" id="uploadfile-1" readonly><a
						href="javascript:void();" class="layui-btn"><i
							class="layui-icon">&#xe7a0;</i>浏览文件</a> <input type="file" multiple
						name="file-1" class="input-file size-L">
					</span> <br> <br>

					<div>
						<button type="submit" class="layui-btn" id="test1">
							<i class="layui-icon">&#xe67c;</i>上传文件
						</button>


						<button type="reset" class="layui-btn" id="test1">
							<i class="layui-icon">&#xe609;</i> 取消选择
						</button>
					</div>
				</form>
			</div>

		</div>
		<div class="layui-tab-item">
			<h2>用Excel方式导入判断题</h2>
			<div class="tm_batch_help"
				style="margin-left: 20px; margin-top: 20px;">
				<div>
					<img src="jsp/images/point_yellow.png" />
					使用Excel做为模板文件，请注意格式要求，并且文件编码必须为UTF8。
				</div>
				<div>
					<img src="jsp/images/point_green.png" /> <a
						href="files/template_questions_excel.zip" target="_blank"><strong>点击下载Excel格式模板</strong></a>
					请下载模板，并按照格式填写，填写完成后，上传文件即可完成导入。
				</div>
				<br>
				<form action="" method="post" id="form_txt_import">
					<span class="btn-upload form-group"> <input
						class="input-text upload-url radius " type="text"
						name="uploadfile-1" id="uploadfile-1" readonly><a
						href="javascript:void();" class="layui-btn"><i
							class="layui-icon">&#xe7a0;</i>浏览文件</a> <input type="file" multiple
						name="file-1" class="input-file size-L">
					</span> <br> <br>

					<div>
						<button type="submit" class="layui-btn" id="test1">
							<i class="layui-icon">&#xe67c;</i>上传文件
						</button>


						<button type="reset" class="layui-btn" id="test1">
							<i class="layui-icon">&#xe609;</i> 取消选择
						</button>
					</div>
				</form>
			</div>

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
