<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
   %>
	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <style>
   .row{
   	padding-top:200px ;
   }
  </style>
  <body>
  	<div  class="row">
  		 <div class="col-md-3 col-md-offset-4">
   <form class="form-horizontal" id="login">
   	<h2 align="center">校园快捷点餐后台管理</h2>
 <div class="form-group">
    <label for="input" class="col-sm-2 control-label">账号:</label>
    <div class="col-sm-10">
      <input type="input" class="form-control" name="username" id="user"  placeholder="username">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">密码:</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" name="password" id="Password"  placeholder="Password">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="button" class="btn btn-default" id="btn_login">登陆</button>
    </div>
</form>
</div>
</div>
  </body>
</html>
 <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <script>
   $("#btn_login").click(function(){
        $.ajax({
        url:"${APP_PATH}/wx/count",
      	type:"GET",
      	data:$("#login").serialize(),
      	success:function(res){
      	   console.log(res);
      	   var count=res;
           if(count==1){
      	  	location.href="admin.jsp";
      	   }else{
      	   	$("#login input").val("");
      	   	alert("密码或账号错误");
      	   }      	   
      	}
   });
   });
   </script>