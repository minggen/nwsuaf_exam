<%@page import="com.utils.something"%>
<%@page import="java.util.List"%>
<%@page import="com.utils.syslog"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<ul class="layui-timeline">
 
<% 
List<something> mlis = syslog.log;
for(something sth:mlis){%>
  <li class="layui-timeline-item">
    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
    <div class="layui-timeline-content layui-text">
      <h3 class="layui-timeline-title"><%=sth.date.toString() %></h3>
      <p>
	        <%=sth.sth %>
      </p>
    </div>
  </li>
  <%} %>
</ul>