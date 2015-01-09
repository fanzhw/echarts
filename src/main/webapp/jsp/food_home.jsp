<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<%@ include file="header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="text/javascript" src="../static/js/food_home.js"></script>
<script type="text/javascript" src="../static/js/food_order.js"></script>
<script type="text/javascript" src="../static/js/food_menu.js"></script>
<script type="text/javascript" src="../static/js/WdatePicker/WdatePicker.js"></script>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-2">
        	<ul class="side_nav">
            	<li>
                    <a href="#" class="side_nav_on">省局</a> 
                	<ul id="foodNav">
                        <li id="food"><a href="#" onclick="showFoodCateList_setting()">菜品列表</a> </li>
                        <li id="menu"><a href="#" onclick="showMenuList_setting()">菜单列表</a> </li>
                        <li id="order"><a href="#" onclick="showOrderList_setting()">订餐列表</a> </li>
                    </ul>
                </li>
            </ul>
        </div>
        <div id="contentDivPage"  class="col-md-10"> 
        </div>
</div>
</div>
<input type="hidden" id="tableLength" />
<input type="hidden" id="selectList" name="selectList"/>
<div id="foodPage" style="display: none">
  <%@ include file="food.jsp"%>
</div>

            
<div id="menuList" style="display: none">
            <div class="row">
            	<h4 class="col-md-2"><strong>供餐列表</strong></h4>
                <p class="col-md-4 pull-right text-right"><button class="btn btn-primary mr10" data-toggle="modal" data-target="#myModal">添加</button><button class="btn btn-danger">删除</button></p>
            </div>
            <table class="table comtable" id="menutab">
            <thead>
            	<tr>
                	<th width="100" class="text-center"><input type="checkbox"> 全选</th>
                    <th width="100" class="text-center">序号</th>
                    <th class="text-center">供餐时间</th>
                    <th class="text-center">供餐类别</th>
                    <th width="220" class="text-center">操作</th>
                </tr>
             </thead>
               <tbody id="menutbody">
               </tbody>
             </table>
</div>


<div id="orderList" style="display: none">
           <div class="search well">
            	<ul class="row list-inline">
                	<li class="col-md-4">开始时间：<input  id="startTime" type="text" onClick="WdatePicker()" class="form-control" style="width:180px"></li>
                    <li class="col-md-4">结束时间：<input  id="stopTime" type="text" onClick="WdatePicker()" class="form-control" style="width:180px"></li>
                    <li class="col-md-3">支付状态：<select class="form-control"><option>已确认</option><option>已退回</option><option>等待处理</option></select></li>
                    <li class="col-md-1"><button class="btn btn-warning" onclick="search()">搜索</button></li>
                </ul>
            </div>
            <div class="row">
            	<h4 class="col-md-2"><strong>订餐历史记录</strong></h4>
                <p class="col-md-4 pull-right text-right"><button class="btn  btn-primary">打印所有</button><button class="btn btn-success col-xs-offset-1">打印已确认订单</button></p>
            </div>
            <table class="table comtable" id="ordertab">
              <thead>
            	<tr>
                	<th width="80" class="text-center">姓名</th>
                    <th width="120" class="text-center">订餐时间</th>
                    <th width="120" class="text-center">取餐时间</th>
                    <th width="180" class="text-center">菜品</th>
                    <th width="80" class="text-center">总金额</th>
                    <th width="160" class="text-center">备注</th>
                    <th width="140" class="text-center">支付状态</th>
                </tr>
              </thead>
              <tbody id="ordertbody">
              </tbody>
            </table>
 </div>



</body>
</html>