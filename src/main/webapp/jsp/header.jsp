<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../static/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../static/css/style.css">
<link rel="stylesheet" type="text/css" href="../static/css/jquery.dataTables.css">
<!--[if lt IE 9]>
      <script src="/assets/html5.js"></script>
      <script src="/assets/respond.js"></script>
    <![endif]-->
    <script type="text/javascript">
     var path = "<%=request.getContextPath() %>";
     </script>
<script type="text/javascript" src="../static/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="../static/js/bootstrap.js"></script>
<script type="text/javascript" src="../static/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="../static/js/common.js"></script>
</head>
<body>
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
    	<div class="row">
            <div class="col-md-3">
                <p class="logo">后勤服务系统</p>    
            </div>
            <div class="col-md-6">
                <ul class="nav nav-pills nav-head" id="headerNav">
                    <li id="foodService"><a href="#" onclick="gotoFoodService()">餐饮服务</a></li>
                    <li id="product"><a href="#" onclick="gotoProductManage()">订购管理</a></li>
                    <li id="service"><a href="#" onclick="gotoService()">微服务</a></li>                    
                    <li id="department"><a href="#" onclick="gotoDepManage()">部门管理</a></li>
                </ul>
            </div>
            <div class="col-md-3">
            	<p class="text-right pt20">当前用户：<%=request.getParameter("username") %> 超级管理员 <a href="#">退出</a></p>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">

function gotoFoodService(){
	var urlLogin = path+"/foodCateController/gotoFoodCategoryList";
	 window.location.href = urlLogin;
	
}

function gotoProductManage(){
	var urlLogin = path+"/productCateController/gotoProductCategoryList";
	 window.location.href = urlLogin;
	
}

function gotoService(){
	var urlLogin = path+"/microServiceController/gotoMicroServiceList";
	 window.location.href = urlLogin;
	
}

function gotoDepManage(){
	var urlLogin = path+"/departmentController/gotoDepList";
	 window.location.href = urlLogin;
	
}
</script>
</body>
</html>