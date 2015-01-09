<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../static/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../static/css/style.css">

<script type="text/javascript" src="../static/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="../static/js/bootstrap.js"></script>
</head>
<body class="login_bg">
	<div class="login_contaner">
    	<h3 class="login_header">登录</h3>
        <div class="login_content">
            <form role="form" action="login" method="post">
                <div class="form-group">
                    <label class="control-label" for="username">用户名:</label>                    
                    <input type="text" class="form-control" id="username" />
                </div>
                <div class="form-group">
                    <label class="control-label" for="password">密码:</label>
                    <input type="password" class="form-control" id="password" />
                </div>
                <div class="form-group clearfix">
                
                    <div class="pull-right"><a href="javascript:checkLogin();" class="btn btn-warning btn-large">登录</a></div>
                </div>             
            </form>   
        </div>
    </div>
    <script type="text/javascript">
    
     var path = "<%=request.getContextPath() %>";
     
     function checkLogin(){
    	 var username = $("#username").val();
    	 var password = $("#password").val();
    	 
    	 if(username==""){
    		 alert("用户名不能为空！！");
    		 return;
    	 }else if(password == ""){
    		 alert("密码不能为空！！");
    		 return;
    	 }
    	
    	 $.ajax({
             url:path+'/loginController/login',
             data:{
            	  username : username ,
                  password: password
             },
             type:'POST',
             dataType:'json',
             async: true,
             success:function(data) {
                 var urlLogin = path+"/foodCateController/gotoFoodCategoryList";
                 if(data[0].failcause == "NONE"){
                    window.location.href = urlLogin;
                 }
                  
             },
             error:function(){
                alert("登陆失败");
         }
              
         });
     }
    
    </script>
</body>
</html>