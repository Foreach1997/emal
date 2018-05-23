<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'order.jsp' starting page</title>
    <%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
   %>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  </head>
  
  <body>
  </div>
<div class="container">
	<div class="row">
	<div class="col-md-10 col-md-offset-1">
  <table class="table table-hover">
         	 <th>code</th>
         	 <th>goodsName</th>
         	 <th>price</th>
         	 <th>order</th>
         	 <tbody id="t1">
         	 	
         	 </tbody>
  </table>
 </div>
  </body>
</html>
  <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
    $(function(){
     getAll(); 
        
    })
   
    function getAll(){
         		$.ajax({
         			type:"get",
         			url:"${APP_PATH}/wx/getAllOrder",
         			async:true,
         			success:function(res){
         				console.log(res);
         				var res=res;
         			   $.each(res, function(index,item) {
         			   var code=$("<td></td>").append(item.code);
         			   var goodsName=$("<td></td>").append(item.goodsName);
         			   var price=$("<td></td>").append(item.price);
         			   var goodstime=$("<td></td>").append(item.time);
         			   $("<tr></tr>").append(goodsName).append(price).append(code).append(goodstime).appendTo("#t1");
         			   
         			})
         		}
         		});		
         		 setTimeout(getAll, 5000);
         		 $('#t1').empty(); 
         	}
    
    </script>
