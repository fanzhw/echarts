<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../static/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../static/css/style.css">
<link rel="stylesheet" type="text/css" href="../static/css/jquery.dataTables.css">
<script type="text/javascript" src="../static/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="../static/js/bootstrap.js"></script>
<script type="text/javascript" src="../static/js/jquery.dataTables.js"></script>
</head>
<body>
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
        <button type="button" class="btn btn-primary" onclick="addFoodCategory()">确定</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>