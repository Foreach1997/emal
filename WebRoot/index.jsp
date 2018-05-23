<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <form action="wx/testfileName" method="post" enctype="multipart/form-data">
  <input type="file" name="file">
  <button type="submit">提交</button>
  </form>
  <a href="wx/count">123</a>
  <a href="wx/user">user</a>
  <a href="wx/getAllAndgoods">gerAllAndgoods</a>
  <a href="wx/getCountCode">getCountCode</a>
    <a href="wx/getOrder">getOrder</a>
    <a href="wx/getImage">getImage</a>
     <a href="wx/getdd">getdd</a>
        <a href="wx/su">test</a>
        <a href="wx/getGoods">goods</a>
  </body>
</html>
