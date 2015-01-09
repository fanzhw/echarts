<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<%@ include file="header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="text/javascript" src="../static/js/food.js"></script>
<script type="text/javascript" src="../static/js/WdatePicker/WdatePicker.js"></script>
</head>
<body>
<div class="col-md-12">
    <div class="container">  
            <ul class="nav nav-tabs" role="tablist" id="foodPageNav">
                 <li id="category"><a href="#" onclick="showCateList_setting()">菜品类别列表</a></li>  
                 <li id="foodlist"><a href="#" onclick="showfoodList_setting()">菜品列表</a></li> 
           </ul>
        </div>  
</div>

<input type="hidden" id="tableLength" />
<input type="hidden" id="selectList" name="selectList"/>
<div id="foodTablePage" class="col-md-12"></div>

<div id="foodCateList" style="display: none">
           <div class="row" >
           <br/>
            	<h4 class="col-md-2"><strong>菜品类别列表</strong></h4>
                <p class="col-md-4 pull-right text-right"><button class="btn btn-primary mr10" id="addtype" data-toggle="modal" data-target="#myAddModal" >添加</button><button class="btn btn-danger"  onclick="confirmDelBySerialNum('all')">删除</button></p>
            </div>
            <table class="table comtable" id="foodcatetab">
                <thead>
            	<tr>
                	<th width="100" class="text-center"><input type="checkbox" id="setCheckAll" onclick="checkAll(this)"> 全选</th>
                    <th width="100" class="text-center">序号</th>
                    <th class="text-center">菜品类别</th>
                    <th class="text-center">类别描述</th>
                    <th width="140" class="text-center">操作</th>
                </tr>
                </thead>
                <tbody id="foodcatetbody"></tbody>
            </table>
   
</div>

 <div id="foodList" style="display: none">
           <div class="row">
           <br/>
            	<h4 class="col-md-2"><strong>菜品列表</strong></h4>
                <p class="col-md-4 pull-right text-right"><button class="btn btn-primary mr10" data-toggle="modal" data-target="#myAddFoodModal" onclick="getFoodCate()">添加</button><button class="btn btn-danger">删除</button></p>
            </div>
            <table class="table comtable" id="foodtab">
            <thead>
            	<tr>
                	<th width="100" class="text-center"><input type="checkbox"  id="setCheckAll" onclick="checkAll(this)"> 全选</th>
                    <th width="100" class="text-center">序号</th>
                    <th class="text-center">菜品</th>
                    <th width="100" class="text-center">菜品类别</th>
                    <th class="text-center">单价</th>
                    <th class="text-center">商品描述</th>
                    <th width="130" class="text-center">操作</th>
                </tr>
             </thead>
             <tbody id="foodtbody">
             </tbody>
             </table>
 </div>
 
 
 
<!-- Modal 添加类别弹出-->
<div class="modal fade" id="myAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">添加菜品类别</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" role="form">
          <div class="form-group">
            <label for="inputEmail3" class="col-sm-3 control-label">菜品类别序号：</label>
            <div class="col-sm-6">
              <input type="text" class="form-control" id="serial" placeholder="">
            </div>
          </div>
          <div class="form-group">
            <label for="inputEmail3" class="col-sm-3 control-label">菜品类别名称：</label>
            <div class="col-sm-6">
              <input type="text" class="form-control" id="foodCateName" placeholder="">
            </div>
          </div>
          <div class="form-group">
            <label for="inputEmail3" class="col-sm-3 control-label">菜品类别介绍：</label>
            <div class="col-sm-9">
              <textarea class="form-control" rows="3" id="foodCateContent"></textarea>
            </div>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" onclick="checkAddInput()">确定</button>
      </div>
    </div>
  </div>
</div>


<!-- Modal 编辑类别弹出-->
<div class="modal fade" id="editcateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">编辑菜品类别</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" role="form">
          <div class="form-group">
            <label for="inputEmail3" class="col-sm-3 control-label">菜品类别序号：</label>
            <div class="col-sm-6">
              <input type="text" class="form-control" id="editSerial" placeholder="">
              <input type="hidden" id="editId" >
            </div>
          </div>
          <div class="form-group">
            <label for="inputEmail3" class="col-sm-3 control-label">菜品类别名称：</label>
            <div class="col-sm-6">
              <input type="text" class="form-control" id="editFoodCateName" placeholder="">
            </div>
          </div>
          <div class="form-group">
            <label for="inputEmail3" class="col-sm-3 control-label">菜品类别介绍：</label>
            <div class="col-sm-9">
              <textarea class="form-control" rows="3" id="editFoodCateContent"></textarea>
            </div>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" onclick="editFoodCate()">确定</button>
      </div>
    </div>
  </div>
</div>
 
 
 <!-- Modal 添加菜品弹出-->
<div class="modal fade" id="myAddFoodModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">添加菜品</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" role="form">
          <div class="form-group">
            <label for="inputEmail3" class="col-sm-3 control-label">菜品序号：</label>
            <div class="col-sm-3">
              <input type="text" class="form-control" id="foodserial" placeholder="">
            </div>
            <label for="inputEmail3" class="col-sm-3 control-label">菜品名称：</label>
            <div class="col-sm-3">
              <input type="text" class="form-control" id="foodName" placeholder="">
            </div>
          </div>
          <div class="form-group">
            <label for="inputEmail3" class="col-sm-3 control-label">菜品类别：</label>
            <div class="col-sm-3">
             <select id="foodCateselect">
              <option id="default">---请选择---</option>
              
             </select>
             </div>
            <label for="inputEmail3" class="col-sm-3 control-label">单价： ￥</label>
            <div class="col-sm-3">
              <input type="text" class="form-control" id="foodPrice" placeholder="">
            </div>
          </div>
          <div class="form-group">
            <label for="inputEmail3" class="col-sm-3 control-label">菜品描述：</label>
            <div class="col-sm-9">
              <textarea class="form-control" rows="3" id="foodContent"></textarea>
            </div>
          </div>
          </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" onclick="checkAddFoodInput()">确定</button>
      </div>
    </div>
  </div>
  </div>
</body>
</html>