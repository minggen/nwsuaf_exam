<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">
		<!-- <dl id="menu-article">
			<dt><i class="Hui-iconfont">&#xe616;</i> 资讯管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a href="#" title="资讯管理">资讯管理</a></li>
				</ul>
			</dd>
		</dl> -->
		
		<dl id="menu-member">
			<dt><i class="Hui-iconfont">&#xe60d;</i> 题库维护<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a href="questionslist.action" title="浏览题库">浏览题库</a></li>
					<li><a href="jsp/teacher.jsp?op=addquestion" title="新增题目">新增题目</a></li>
					<li><a href="jsp/teacher.jsp?op=importquestions" title="批量导入">批量导入</a></li>					
				</ul>
			</dd>
		</dl>
		<dl id="menu-admin">
			<dt><i class="Hui-iconfont">&#xe62d;</i> 安排考试<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a href="jsp/teacher.jsp?op=newexam" title="新建考试">新建考试</a></li>
					<li><a href="lookupexamlist.action" title="考试管理">考试管理</a></li> 
					<!-- <li><a href="#" title="考试管理">考试管理</a></li> -->
					<!-- <li><a href="#" title="管理员列表">管理员列表</a></li> -->
				</ul>
			</dd>
		</dl>
		<dl id="menu-tongji">
			<dt><i class="Hui-iconfont">&#xe61a;</i> 结果统计<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a href="jsp/teacher.jsp?op=studentpic" title="统计图表">统计图表</a></li>
					<li><a href="jsp/teacher.jsp?op=studenttable" title="学生成绩表">学生成绩表</a></li>
					<li><a href="jsp/teacher.jsp?op=anexam" title="试卷分析">试卷分析</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-system">
			<dt><i class="Hui-iconfont">&#xe62e;</i> 学生导入<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a href="jsp/teacher.jsp?op=importstudents" title="批量导入">批量导入</a></li>
					<li><a href="jsp/teacher.jsp?op=importstudent" title="单个增加">单个增加</a></li>
				</ul>
			</dd>
		</dl>
	</div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" id="hiddenorplay" href="javascript:;" onClick="displaynavbar(this)"></a></div>
