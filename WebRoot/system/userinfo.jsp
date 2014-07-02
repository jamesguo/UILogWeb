<%@page import="ctrip.system.model.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<%
User u = (User) session.getAttribute("user");
if (u == null) {
	response.sendRedirect("login.jsp");
	return;
}
%>
  <head>
    
    <title>个人信息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  <body>
   <center>
   <h1 style="text-align: center;">个人信息</h1>
   <hr style="background: #6CE26C; height: 5px; border: 0px;" />
   
   <table>
   		<tr>
			<td>
			 用户名:
			</td>
			<td>
			 <input type="text"  name="userName"  readonly="readonly" value="<%=u.getUser_name()%>">
			</td>
		</tr>  
		 <tr>
			<td>
			 所属组:
			</td>
			<td>
				<input type="radio" style="width:auto;" value="1" name="userGroup"  <%=u.getGroup_id()==1?"checked=checked":"false"%> />android
				<input type="radio" style="width:auto;" value="2" name="userGroup"  <%=u.getGroup_id()==2?"checked=checked":"false"%>/>ios
				<input type="radio" style="width:auto;" value="3" name="userGroup"   <%=u.getGroup_id()==3?"checked=checked":"false"%>/>sender
			</td>
		</tr>  
        <tr>
			<td>
		      角色:
			</td>
			<td>
			<input type="radio" style="width:auto;" value="1" name="userRole"  <%=u.getRole_id()==1?"checked=checked":"false"%> />超级管理员
			<input type="radio" style="width:auto;" value="2" name="userRole"  <%=u.getRole_id()==2?"checked=checked":"false"%>/>数据组
			<input type="radio" style="width:auto;" value="3" name="userRole"   <%=u.getRole_id()==3?"checked=checked":"false"%>/>页面开发人员
			</td>
		</tr>  
   </table>
   </center>
  </body>
</html>
