<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'admin.jsp' starting page</title>
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
		<div class="modal fade" id="emp" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加食物</h4>
      </div>
      <div class="modal-body">
       <form class="form-horizontal" id="add_emp">
 <div class="form-group">
    <label for="input" class="col-sm-2 control-label">goodsName:</label>
    <div class="col-sm-10">
      <input type="input" class="form-control" name="goodsName"  placeholder="goodsName">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">price:</label>
    <div class="col-sm-10">
      <input type="input" class="form-control" name="price"  placeholder="price">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">photo:</label>
    <div class="col-sm-10">
      <input type="input" class="form-control" name="photo"  placeholder="photo">
    </div>
  </div>
</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="btn_add">添加</button>
      </div>
    </div>
  </div>
</div>


	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">食物修改</h4>
      </div>
      <div class="modal-body">
       <form class="form-horizontal" id="login">
 <div class="form-group">
    <label for="input" class="col-sm-2 control-label">goodsName:</label>
    <div class="col-sm-10">
      <input type="input" class="form-control" name="goodsName" id="goodsName"  placeholder="goodsName">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">price:</label>
    <div class="col-sm-10">
      <input type="input" class="form-control" name="price" id="price"  placeholder="price">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">photo:</label>
    <div class="col-sm-10">
      <input type="input" class="form-control" name="photo" id="photo"  placeholder="photo">
    </div>
  </div>
</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="btn_save">保存</button>
      </div>
    </div>
  </div>
</div>

<div class="row">
<button type="button" id="add" class="btn btn-success col-md-1 col-md-offset-6">添加</button>
<button type="button" class="btn btn-success col-md-1" id="order">订单</button>
</div>
<div class="container">
	<div class="row">
	<div class="col-md-12">
  <table class="table table-hover">
             <th>#</th>
         	 <th>goodsName</th>
         	 <th>price</th>
         	 <th>photo</th>
         	 <tbody id="t1">
         	 	
         	 </tbody>
  </table>
 </div>
  </body>
</html>
	  <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
         <script>
         var save_id;
         	$(function(){
         	
         		getAll();
         	})  
         	function getAll(){
         		$.ajax({
         			type:"get",
         			url:"${APP_PATH}/wx/getAllAndgoods",
         			async:true,
         			success:function(res){
         				console.log(res);
         				var res=res;
         			   $.each(res, function(index,item) {
         			   var id=$("<td></td>").append(item.id);
         			   var goodsName=$("<td></td>").append(item.goodsName);
         			   var price=$("<td></td>").append(item.price);
         			   var photo=$("<td></td>").append(item.photo);
         			   var add=$("<button></button>").addClass("edit_btn").addClass("btn btn-primary").append("修改");
         			   add.attr("edit_id",item.id);
         			   var nbsp=$("<span>&nbsp;</span>");
         			   var de=$("<button></button>").addClass("del_btn").addClass("btn btn-primary").append("删除");
         			   de.attr("del_id",item.id);
         			   $("<tr></tr>").append(id).append(goodsName).append(price).append(photo).append(add).append(nbsp).append(de).appendTo("#t1");
         			})
         		}
         		});		
         	}
     function edit(id){
         		$.ajax({
         			type:"get",
         			url:"${APP_PATH}/wx/getGoods",
         			async:true,
         			data:"edit_id="+id,
         			success:function(res){
         				console.log(res);
         				var res=res;
         			   $("#goodsName").val(res.goodsName);
         			   $("#price").val(res.price);
         			   $("#photo").val(res.photo);
         			}
        }
        )};
      $(document).on("click",".edit_btn",function(){
             save_id=$(this).attr("edit_id");
             //alert(save_id);
             edit($(this).attr("edit_id"));
			$('#myModal').modal('show');
		});
	  $("#btn_save").click(function(){
	      $('#myModal').modal('hide');
	      $('#t1').empty(); 
	      save();
	  });
	 function save(){
	  var login="id="+save_id+"&"+$("#login").serialize();
	  //alert(login);
	   $.ajax({
        url:"${APP_PATH}/wx/setGoods",
      	type:"GET",
      	async:true,
      	data:login,
      	success:function(res){  
      	console.log(res);
      	   getAll();	  
      	  alert("保存成功");       
      	}
	    }) 
	 }
	   $(document).on("click",".del_btn",function(){
             $('#t1').empty(); 
             delGoods($(this).attr("del_id"));
		});
	 function delGoods(id){ 
	  $.ajax({
        url:"${APP_PATH}/wx/delGoods",
      	type:"GET",
      	async:true,
      	data:"del_id="+id,
      	success:function(res){  
      	console.log(res);
      	   getAll();	  
      	  alert("删除成功");       
      	}
	    }) 
	 }	
	 function addGoods(){
	 $.ajax({
        url:"${APP_PATH}/wx/addGoods",
      	type:"GET",
      	async:true,
      	data:$("#add_emp").serialize(),
      	success:function(res){  
      	console.log(res);
      	   getAll();	  
      	  alert("添加成功");       
      	}
	    }) 
	 
	 }
	 $("#btn_add").click(function(){
	  $('#t1').empty(); 
	  $('#emp').modal('hide');
	    addGoods();
	 })
	 $("#add").click(function(){
	 	$('#emp').modal('show');
	 	$("#add_emp input").val("");
	 })
	 $("#order").click(function(){
	     location.href="order.jsp"
	 })
         </script>