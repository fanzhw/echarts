<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<%@ include file="header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="text/javascript" src="../static/js/product_category.js"></script>
<script type="text/javascript" src="../static/js/product.js"></script>
<script type="text/javascript" src="../static/js/product_order.js"></script>
<script type="text/javascript" src="../static/js/product_menu.js"></script>
<script type="text/javascript" src="../static/js/WdatePicker/WdatePicker.js"></script>

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-2">
        	<ul class="side_nav">
            	<li><a href="#" class="side_nav_on">省局</a>
                	<ul id="productNav">
                        <li id="productCate"><a href="#" onclick="showProductCateList_setting()">商品类别列表</a> </li>
                        <li id="productMenu"><a href="#" onclick="showProductList_setting()">商品清单</a> </li>
                        <li id="bill"><a href="#" onclick="showProductMenuList_setting()">商品列表</a> </li>
                        <li id="order"><a href="#" onclick="showProductOrderList_setting()">订购列表</a> </li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="col-md-10" id="contentDivPage">
            
        </div>
    </div>
</div>

<div id="productCateList" style="display: none">
            <div class="row">
            	<h4 class="col-md-2"><strong>商品类别列表</strong></h4>
                <p class="col-md-4 pull-right text-right"><button class="btn btn-primary mr10" id="addtype" data-toggle="modal" data-target="#myModal">添加</button><button class="btn btn-danger">删除</button></p>
            </div>
            <table class="table comtable" id="proCatetab">
            <thead>
            	<tr>
                	<th width="100" class="text-center"><input type="checkbox"> 全选</th>
                    <th width="100" class="text-center">序号</th>
                    <th class="text-center">商品类别</th>
                    <th>类别描述</th>
                    <th width="140" class="text-center">操作</th>
                </tr>
              </thead>
               <tbody id="proCatetbody"></tbody>
            </table>
</div>

 <div id="productList" style="display: none">
            <div class="row">
            	<h4 class="col-md-2"><strong>商品列表</strong></h4>
                <p class="col-md-4 pull-right text-right"><button class="btn btn-primary mr10" id="addtype" data-toggle="modal" data-target="#myModal">添加</button><button class="btn btn-danger">删除</button></p>
            </div>
            <table class="table comtable" id="producttab">
            <thead>
            	<tr>
                	<th width="100" class="text-center"><input type="checkbox"> 全选</th>
                    <th width="100" class="text-center">序号</th>
                    <th class="text-center">商品名称</th>
                    <th width="100" class="text-center">商品类别</th>
                    <th class="text-center">单价</th>
                    <th>商品描述</th>
                    <th width="130" class="text-center">操作</th>
                </tr>
              </thead>
              <tbody id="producttbody"></tbody>
            </table>
</div>

<div id="menulist" style="display: none">
            <div class="row border_bottom">
            <p class="col-md-4 pull-right text-right"><button class="btn btn-primary mr10" data-toggle="modal" data-target="#myModal">添加</button><button class="btn btn-danger">删除</button></p>
            </div>
            <div id="proMenuList"></div>
</div>

 <div id="orderList" style="display: none">
        	<div class="search well">
            	<ul class="row list-inline">
                	<li class="col-md-4">开始时间：<input  id="startTime" type="text" onClick="WdatePicker()" class="form-control" style="width:180px"></li>
                    <li class="col-md-4">结束时间：<input  id="stopTime" type="text" onClick="WdatePicker()" class="form-control" style="width:180px"></li>
                    <li class="col-md-3">商品状态：<select class="form-control"><option>已取货</option><option>未取货</option></select></li>
                    <li class="col-md-1"><button class="btn btn-warning">搜索</button></li>
                </ul>
            </div>
            <div class="row">
            	<h4 class="col-md-2"><strong>订购历史记录</strong></h4>
                <p class="col-md-4 pull-right text-right"><button class="btn  btn-primary">打印所有</button><button class="btn btn-success col-xs-offset-1">打印已确认订单</button></p>
            </div>
            <table class="table comtable" id="ordertab">
             <thead>
            	<tr>
                	<th width="80">姓名</th>
                    <th width="120">订餐时间</th>
                    <th width="120">取餐时间</th>
                    <th width="180">菜品</th>
                    <th width="80">总金额</th>
                    <th width="160">备注</th>
                    <th width="140" class="text-center">支付状态</th>
                </tr>
               </thead>
               <tbody id="ordertbody"></tbody>
            </table>
</div>
        
<!-- Modal 添加类别弹出-->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">添加商品类别</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" role="form">
          <div class="form-group">
            <label for="inputEmail3" class="col-sm-3 control-label">商品序号：</label>
            <div class="col-sm-6">
              <input type="text" class="form-control" id="inputEmail3" placeholder="">
            </div>
          </div>
          <div class="form-group">
            <label for="inputEmail3" class="col-sm-3 control-label">商品类别名称：</label>
            <div class="col-sm-6">
              <input type="text" class="form-control" id="inputEmail3" placeholder="">
            </div>
          </div>
          <div class="form-group">
            <label for="inputEmail3" class="col-sm-3 control-label">商品类别介绍：</label>
            <div class="col-sm-9">
              <textarea class="form-control" rows="3"></textarea>
            </div>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary">确定</button>
      </div>
    </div>
  </div>
</div>


</body>
</html>