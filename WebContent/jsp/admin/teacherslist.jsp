<%@page import="java.util.List"%>
<%@page import="com.entity.ExamUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% 
 	List<ExamUser> userList = (List<ExamUser>)session.getAttribute("userList");
 %>
	<div class="panel panel-default">
		<div class="panel-header">老师列表</div>
                        <table class="table table-striped table-hover table-bordered table-responsive" style=" table-layout:fixed;">
                            <thead>
                                <tr >
                                    <th width="2%"></th>
                                    <th width="4%">教师id</th>
                                    <th width="10px;">教师姓名</th>
                                    <th width="10px;">性别</th>
                                    <th width="4%">教师邮箱</th>
                                    <th width="15px">教师手机号</th>
                                   	<th width="6%"></th>
                                </tr>
                            </thead>
                            <tbody>
                            	<%
                            		int i=0;
                            		for(ExamUser examUser: userList){ 
                            			i++;
                            	%>
                                <tr>
                                    <td ><%=i %></td>
                                    <td><%=examUser.getUserId() %></td>
                                    <td><%=examUser.getUserName() %></td>
                                    <td><%=examUser.getUserSex() %></td>
                                    <td><%=examUser.getUserEmail() %></td>
                                    <td><%=examUser.getUserTelephone() %></td>
                                      
                                    <td>
                                        <div class="btn-group">
                                        <!-- request里获取题目及id -->
                                            <a href="javascript:if(confirm('确定要删除吗？')) window.location.replace('delete_teacher?id=<%=examUser.getUserId() %>&ti=<%=i %>')" class="btn btn-danger">删除</a>
                                        </div>
                                    </td>
                                </tr>
								<% }%>
                            </tbody>
                        </table>
                        
                                     
                        
               </div>
                    
 
<script src="jsp/lib/layui/layui.js"></script>

