<%@page import="ctrip.system.model.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
User user = (User)session.getAttribute("user");
if(user==null)
{
	response.sendRedirect("login.jsp");
	return;
}
else
{
	if(user.getRole_id()!=1)
	{
		out.println("<center><h1>需要管理员权限</h1></center>");
		out.close();
		return;
	}
}
 %>

<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link href="../script/miniui/themes/icons.css" rel="stylesheet" type="text/css" /> 
	<script type="text/javascript" charset="utf-8" src="../script/jquery-1.8.2.js"></script>
	<link href="../script/miniui/themes/default/miniui.css" rel="stylesheet" type="text/css" />        
    <script src="../script/miniui/miniui.js" type="text/javascript"></script>
  </head>
  <body>
  		<!-- search table start -->
  		<table border="0" cellpadding="1" cellspacing="2" style="width:100%;table-layout:fixed;">
  			<tr>
  				<td style="width:90px;">用户名：</td>
  				<td><input type="text" id="txt_user_name" /></td>
  				<td style="width:90px;">所属组：</td>
				<td><select id="group_id">
						<option value="0">全部</option>
						<option value="1">android</option>
						<option value="2">ios</option>
						<option value="3">sender</option></select></td>
				<td style="width:90px;">角色：</td>
				<td><select id="role_id">
						<option value="0">全部</option>
						<option value="3">页面开发人员</option>
						<option value="2">数据组</option>
						<option value="1">超级管理员</option></select></td>		
  			</tr>
			<tr>
					<td style="width:25%;" align="center"><input value="搜索"  type="button" onclick="searchUser()" style="width:80px;" /></td>
					<td style="width:25%;" align="center"><input value="清空"  type="button" onclick="resetSearchField()" style="width:80px;"/></td>
					<td style="width:25%;"  align="center"><input value="刷新"  type="button" onclick="refresh()" style="width:80px;"/></td>
				<!-- <td style="width:25%;"  align="center"><input value="添加"  type="button" onclick="addUser()" style="width:80px;"/></td> -->	
			</tr>
  		</table>
  		<!-- search table end -->
  		<div id="userGrid" class="mini-datagrid" style="width:100%;height:530px;"  allowResize="true" pageSize="20"  
		        url="searchUser.do"  idField="id" >
				<div property="columns">		  
					<div field="id" width="60" headerAlign="center" >编号
		            </div>   
		            <div field="user_name" width="120" headerAlign="center" allowSort="true">用户名
		                <input property="editor" class="mini-textbox" style="width:100%;"/>
		            </div>                          
		            <div field="group_id" width="100" allowSort="true" renderer="onGroupRendereronGroupRenderer" >所属组
		            </div>
		            <div field="role_id" width="100" allowSort="true" renderer="onRoleRenderer" >角色	                
		            </div>                  
		            <div name="action" width="40"  headerAlign="center" align="center" renderer="onActionRenderer" cellStyle="padding:0;">操作
		        </div>
		    </div>    
		 </div>    
		 
		 <div id="editWindow" class="mini-window" title="Window" style="width:650px;" 
		    showModal="true" allowResize="true" allowDrag="true">
		    <div id="editform" class="form" >
		        <input class="mini-hidden" name="id"/>
		        <table style="width:100%;">
		            <tr>
		                <td style="width:80px;">用户名：</td>
		                <td style="width:150px;"><input name="user_name" class="mini-textbox" /></td>
		            </tr>
		            <tr>
		                <td style="width:80px;">所属组：</td>
		                <td style="width:150px;"><div name="group_id" class="mini-radiobuttonlist" repeatItems="1" repeatLayout="table" repeatDirection="vertical"
						    textField="text" valueField="id" value="1" 
						    data="[{'id':1,'text':'android'},{'id':2,'text':'ios'},{'id':3,'text':'sender'}]" >
						</div></td>
		            </tr>
		            <tr>
		                <td style="width:80px;">角色：</td>
		                <td style="width:150px;"><div name="role_id" class="mini-radiobuttonlist" repeatItems="1" repeatLayout="table" repeatDirection="vertical"
						    textField="text" valueField="id" value="3" 
						    data="[{'id':1,'text':'超级管理员'},{'id':2,'text':'数据组'},{'id':3,'text':'页面开发人员'}]" >
						</div></td>
		            </tr>
		            <tr>
		                <td style="width:80px;">密码：</td>
		                <td style="width:150px;"><input id="user_pwd" name="user_pwd" class="mini-textbox" /></td>
		            </tr>
		            <tr>
		                <td style="text-align:center;" colspan="6">
		                	<input type="button" onclick="updateUser();" value="提&nbsp;交"  style="width:80px;" />
							<input type="button" onclick="cancelEditWin();" value="取&nbsp;消"  style="width:80px;" />
		                </td>                
		            </tr>
		        </table>
		    </div>
		</div>
  		
  	  <script type="text/javascript" charset="utf-8">
  			mini.parse();
  			
  		    var grid = mini.get("userGrid");
  		    editWindow = mini.get("editWindow"); 
  		    grid.load();
  		    
  			
   			function onActionRenderer(e)
  			{
  				    var s ="<a href='javascript:;' onClick='userDetail("+e.record.id+");' >修改</a>"
  				    +"&nbsp;&nbsp;&nbsp;<a href='javascript:;' onClick='delUser("+e.record.id+");' >删除</a>";
            	    return s;
  			}
  			
  	   function onGroupRenderer(e)
       {
       		var group_id=e.value;
       		if(group_id==1)
       		{
       			return 'android';
       		}else if(group_id==2)
       		{
       			return 'ios';
       		}else 
       		{
       			return '数据组';
       		}
       }
       
       function onRoleRenderer(e)
       {
       		var role_id=e.value;
       		if(role_id==1)
       		{
       			return '超级管理员';
       		}else if(role_id==2)
       		{
       			return '数据组';
       		}else 
       		{
       			return '页面开发人员';
       		}
       }
  			
  			function userDetail(id)
  			{
  				 var row = grid.getSelected();
  				 editWindow.show();
  				 var form = new mini.Form("#editform");
  				 form.clear();
  				  form.loading();
  				   $.ajax({
                    url: "userInfo.do?id=" + id,
                    success: function (text) {
                        form.unmask();
                        form.setData(text);                      
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        alert("表单加载错误");
                        form.unmask();
                    }
                });
  			}
  			
  			function delUser(id)
  			{
        	mini.confirm("确定删除用户" + id + "?", "确认删除",
	            function (action) {            
	                if (action == "ok") {                          
			           	if (id) {
			                grid.loading("处理中，请稍后......");
			                $.ajax({
			                    url: "delUser.do?id=" + id,
			                    success: function (text) {
			                        mini.alert("用户" + id + "已删除！");   
			                       	grid.reload();                  
			                    },
			                    error: function (jqXHR, textStatus, errorThrown) {
			                        alert("表单加载错误");
			                        grid.unmask();
			                    }
			                });
			            }
	                }
	            }
	        );      
  			}
  			
  			function updateUser()
  			{
  				var form = new mini.Form("#editform");
            	var json = form.getData();
            	
            	if(!(json.id))
				json.id = 0;
				
				grid.loading("保存中，请稍后......");
            //json = mini.encode(o);
           	 $.ajax({
                url: "userReg.do",
                data: json,
                type: "post",
                success: function (text) {  
                	if(text.success){              
                    	grid.reload();
                    }else{
                    	mini.alert(text.msg);   
                    }             
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert(jqXHR.responseText);
                    grid.unmask();
                }
            });

            editWindow.hide(); 
  			}
  			
  			function searchUser()
  			{
  				grid.load({
			    user_name: $("#txt_user_name").val(), 
			    group_id: $("#group_id").val(),
			    role_id: $("#role_id").val() 
				}); 
  			}

		function resetSearchField() {
		$("#txt_user_name").val("");
		$("#group_id").val(0);
		$("#role_id").val(0);
		}
		
		function cancelEditWin()
		{
			editWindow.hide();
		}
			
		function refresh()
		{
			grid.reload();
		}
		</script>
  </body>
</html>