<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">
		
		<dl id="menu-tongji">
			<dt><i class="Hui-iconfont">&#xe61a;</i> 系统信息<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a href="jsp/admin.jsp?op=systeminfo" title="系统信息">系统信息</a></li>
				</ul>
			</dd>
		</dl>
		
		<dl id="menu-system">
			<dt><i class="Hui-iconfont">&#xe62e;</i> 系统管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a href="system_getInfo" title="系统设置">系统设置</a></li>
					<li><a href="jsp/admin.jsp?op=systemlog" title="系统日志">系统日志</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-member">
			<dt><i class="Hui-iconfont">&#xe60d;</i> 老师管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a href="teacherList" title="老师列表">老师列表</a></li>
					<li><a href="jsp/admin.jsp?op=addteacher" title="新增老师">新增老师</a></li>					
				</ul>
			</dd>
		</dl>
		<dl >
			<dt><i class="Hui-iconfont">&#xe636;</i> 科目管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
				
					<li><a href="jsp/admin.jsp?op=addsubject" title="新增老师">新增科目</a></li>					
				</ul>
			</dd>
		</dl>
		
		<dl id="menu-admin">
			<dt><i class="Hui-iconfont">&#xe62d;</i> 管理员管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a href="change_getInfo" title="修改个人信息">修改个人信息</a></li>
					
				</ul>
			</dd>
		</dl>
		
	</div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" id="hiddenorplay" href="javascript:;" onClick="displaynavbar(this)"></a></div>

