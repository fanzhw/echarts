<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>后勤服务</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="../static/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../static/css/style.css">
</head>
<body>
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
    	<div class="row">
            <div class="col-md-3">
                <p class="logo">后勤服务系统</p>    
            </div>
            <div class="col-md-6">
                <ul class="nav nav-pills nav-head">
                    <li class='active'><a href="#">餐饮服务</a></li>
                    <li ><a href="#">订购管理</a></li>
                    <li><a href="#">微服务</a></li>
                </ul>
            </div>
            <div class="col-md-3">
            	<p class="text-right pt20">当前用户：admin 超级管理员 <a href="#">退出</a></p>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-2">
        	<ul class="side_nav">
            	<li><a href="#" class="side_nav_on">省局</a>
                	<ul>
                        <li class="active"><a href="#">菜品类别列表</a> </li>
                        <li><a href="#">菜品列表</a> </li>
                        <li><a href="#">菜单列表</a> </li>
                        <li><a href="#">订餐列表</a> </li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="col-md-10">
        	<div class="search well">
            	<ul class="row list-inline">
                	<li class="col-md-3">开始时间：<select class="form-control"><option>2014年9月1日</option></select></li>
                    <li class="col-md-3">结束时间：<select class="form-control"><option>2014年9月2日</option></select></li>
                    <li class="col-md-3">支付状态：<select class="form-control"><option>已确认</option></select></li>
                    <li class="col-md-2"><button class="btn btn-warning">搜索</button></li>
                </ul>
            </div>
            <div class="row">
            	<p class="col-md-2"><strong>订餐历史记录</strong></p>
                <p class="col-md-4 pull-right text-right"><button class="btn  btn-primary">打印所有</button><button class="btn btn-success col-xs-offset-1">打印已确认订单</button></p>
            </div>
            <table class="table comtable">
            	<tr>
                	<th width="80">姓名</th>
                    <th width="120">订餐时间</th>
                    <th width="120">取餐时间</th>
                    <th width="180">菜品</th>
                    <th width="80">总金额</th>
                    <th width="160">备注</th>
                    <th width="160">支付状态</th>
                </tr>
                <tr>
                	<td width="40">张三</td>
                    <td width="80">2014.09.12 <br /> 08:12</td>
                    <td width="80">2014.09.12 <br /> 08:12</td>
                    <td width="160"><span class="text-success">红烧肉￥ 2.5*1，<br />炒饭 ￥2.0*1</span></td>
                    <td><span class="c_red fb">￥4.5</span></td>
                    <td> - </td>
                    <td><button class="btn btn-primary btn-sm">确认</button><button class="btn btn-default btn-sm col-xs-offset-1">返回意见</button></td>
                </tr>
                <tr>
                	<td width="40">张三</td>
                    <td width="80">2014.09.12 <br /> 08:12</td>
                    <td width="80">2014.09.12 <br /> 08:12</td>
                    <td width="160"><span class="text-success">红烧肉￥ 2.5*1，<br />炒饭 ￥2.0*1</span></td>
                    <td><span class="c_red fb">￥4.5</span></td>
                    <td> - </td>
                    <td><button class="btn btn-primary btn-sm">确认</button><button class="btn btn-default btn-sm col-xs-offset-1">返回意见</button></td>
                </tr>
                <tr>
                	<td width="40">张三</td>
                    <td width="80">2014.09.12 <br /> 08:12</td>
                    <td width="80">2014.09.12 <br /> 08:12</td>
                    <td width="160"><span class="text-success">红烧肉￥ 2.5*1，<br />炒饭 ￥2.0*1</span></td>
                    <td><span class="c_red fb">￥4.5</span></td>
                    <td> - </td>
                    <td><button class="btn btn-primary btn-sm">确认</button><button class="btn btn-default btn-sm col-xs-offset-1">返回意见</button></td>
                </tr>
                <tr>
                	<td width="40">张三</td>
                    <td width="80">2014.09.12 <br /> 08:12</td>
                    <td width="80">2014.09.12 <br /> 08:12</td>
                    <td width="160"><span class="text-success">红烧肉￥ 2.5*1，<br />炒饭 ￥2.0*1</span></td>
                    <td><span class="c_red fb">￥4.5</span></td>
                    <td> - </td>
                    <td><button class="btn btn-primary btn-sm">确认</button><button class="btn btn-default btn-sm col-xs-offset-1">返回意见</button></td>
                </tr>
                <tr>
                	<td width="40">张三</td>
                    <td width="80">2014.09.12 <br /> 08:12</td>
                    <td width="80">2014.09.12 <br /> 08:12</td>
                    <td width="160"><span class="text-success">红烧肉￥ 2.5*1，<br />炒饭 ￥2.0*1</span></td>
                    <td><span class="c_red fb">￥4.5</span></td>
                    <td> - </td>
                    <td><button class="btn btn-primary btn-sm">确认</button><button class="btn btn-default btn-sm col-xs-offset-1">返回意见</button></td>
                </tr>
            </table>
        </div>
    </div>
</div>
<script src="../static/js/bootstrap.js"></script>
</body>
</html>